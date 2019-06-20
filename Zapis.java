import java.io.*;


public class Zapis {

    public void Zapis(String str)
    {
        //Soxranit sxr = new Soxranit();
        File nf = new File("Kont.txt");

        try
        {
            if(!nf.exists())
            {
                nf.createNewFile();
            }
            PrintWriter out = new PrintWriter(nf.getAbsoluteFile());
            try
            {
                out.print(str);
            }
            finally
            {
                out.close();
            }
        }
        catch(IOException ioe)
        {
            throw new RuntimeException(ioe);
        }
       // System.out.println(nf.getAbsolutePath());
    }
}
