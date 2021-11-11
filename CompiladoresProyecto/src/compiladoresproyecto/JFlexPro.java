package compiladoresproyecto;
import java.io.*;
import java.nio.file.*;
/**
 *
 * @author reyna
 */
public class JFlexPro {
    public static void generarLexer() throws Exception {
        // Ruta del archivo donde se encuentra el archivo lex.flex
        String[] ruta = {"C:\\Users\\reyna\\OneDrive\\Documentos\\NetBeansProjects\\CompiladoresProyectoFinal\\compiladores-proyecto-final\\CompiladoresProyecto\\src\\compiladoresproyecto\\lex.flex"};
        try {
            jflex.Main.generate(ruta);

            String[] ruta1 = {ruta + "/src/compiladoresproyecto/Lex.flex"};
            String[] ruta2 = {ruta + "/src/compiladoresproyecto/LexerCup.flex"};
            String[] rutaS = {"-parser", "Sintax", ruta + "/src/compiladoresproyecto/Sintax.cup"};

            jflex.Main.generate(ruta1);
            jflex.Main.generate(ruta2);
            jflex.Main.main(rutaS);

            Path rutaSym = Paths.get(ruta + "/src/domain/sym.java");
            if (Files.exists(rutaSym)) {
                Files.delete(rutaSym);
            }
            Files.move(
                    Paths.get(ruta + "/sym.java"),
                    Paths.get(ruta + "/src/compiladoresproyecto/sym.java")
            );
            Path rutaSin = Paths.get(ruta + "/src/compiladoresproyecto/Sintax.java");
            if (Files.exists(rutaSin)) {
                Files.delete(rutaSin);
            }
            Files.move(
                    Paths.get(ruta + "/Sintax.java"),
                    Paths.get(ruta + "/src/compiladoresproyecto/Sintax.java")
            );

        } catch (Exception e) {
            throw new Exception("Error al crear  Archivo Lexer.java ");
        }

    }
    public static void main(String[] args) throws Exception {

        /*try {
         generarLexer();
         } catch (Exception ex) {
         throw new Exception("Error al generar Archivo Lexer" + ex);
         }*/
        try {
            generarLexer();
        } catch (Exception ex) {
            throw new Exception("Error al generar Archivo Lexer" + ex);
        }
    }
}
