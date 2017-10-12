import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigValues {
    private String dbName;
    private String host;
    private String user;
    private String pass;
    private String port;

    InputStream inputStream;
    Properties prop = new Properties();

    public void loadInput(String path) throws IOException{
        try{
            inputStream = getClass().getClassLoader().getResourceAsStream(path);

            if (inputStream != null) {
                prop.load(inputStream);
                System.out.println("Input Stream is loaded.");
            } else {
                throw new FileNotFoundException("property file '" + path + "' not found in the classpath");
            }

            user = prop.getProperty("user");
            port = prop.getProperty("port");
            pass = prop.getProperty("pass");
            host = prop.getProperty("host");
            dbName = prop.getProperty("dbName");
        } catch (Exception e){
            System.out.println("Exception" + e);
        } finally {
            inputStream.close();
        }
    }

    public String getUser(){
        return user;
    }

    public String getPort(){
        return port;
    }

    public String getPass(){
        return pass;
    }

    public String getHost(){
        return host;
    }

    public String getDbName(){
        return dbName;
    }

}
