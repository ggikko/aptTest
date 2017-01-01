package me.ggikko;

import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;

@SupportedAnnotationTypes("me.ggikko.GgikkoAnnotation")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class HelloProcessor extends AbstractProcessor {

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return super.getSupportedSourceVersion();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton(GgikkoAnnotation.class.getName());
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment env) {
        StringBuilder builder = new StringBuilder()
                .append("package me.ggikko;\n")
                .append("public class GgikkoMessageHandler {\n\n") // open class
                .append("\tpublic String getMessage() {\n") // open method
                .append("\t\treturn \"");


        // for each javax.lang.model.element.Element annotated with the CustomAnnotation
        for (Element element : env.getElementsAnnotatedWith(GgikkoAnnotation.class)) {
            String objectType = element.getSimpleName().toString();



            // this is appending to the return statement
            builder.append(objectType).append(" ");
        }


        builder.append("\";\n") // end return
                .append("\t}\n") // close method
                .append("}\n"); // close class



        try { // write the file

            JavaFileObject source = processingEnv.getFiler().createSourceFile("me.ggikko.GgikkoMessageHandler");


            Writer writer = source.openWriter();
            writer.write(builder.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            // Note: calling e.printStackTrace() will print IO errors
            // that occur from the file already existing after its first run, this is normal
        }


        return true;
    }
}
