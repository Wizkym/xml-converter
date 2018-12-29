/*
    Parsing xml data from a file
*/
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import java.io.*;


public class MyDomParser {
    private static final int PRETTY_PRINT_INDENT_FACTOR = 4;

    public static void main(String[] args) {
        BufferedReader br = null;
        String line;
        StringBuilder sb = new StringBuilder();

        try {
            br = new BufferedReader(new FileReader(new File("ab.xml")));
            try {
                while ((line = br.readLine())!= null){
                    sb.append(line.trim());
                }

                // Call the converter function
                System.out.println(converter(sb.toString()));

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static String converter (String myString) {
        String jsonPrettyPrintString = null;
        try {
            JSONObject jsonObject = XML.toJSONObject(myString);
            jsonPrettyPrintString = jsonObject.toString(PRETTY_PRINT_INDENT_FACTOR);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonPrettyPrintString;
    }

}
