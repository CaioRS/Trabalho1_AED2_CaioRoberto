import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;


public class MundoBlocos 
{
    public static void main(String[] args) throws Exception 
    {
        FileReader fr = new FileReader(System.getProperty("user.dir") + "\\entrada.txt");
        BufferedReader br = new BufferedReader(fr);
        TBlocos mundoDosBlocos = new TBlocos(Integer.parseInt(br.readLine()));
        String line = br.readLine();
        do
        {
            if (line.contains("quit")) // encerrra os comandos caso encontro linha quit
            {
                FileWriter fw = new FileWriter(System.getProperty("user.dir") + "\\saida.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(mundoDosBlocos.ToString());
                bw.close();
                fw.close();
            }
            else
            {   // divide a linha, usando o separador &nspr para definir os comandos
                int blocosParaMover = Integer.parseInt(line.split(" ")[1]);
                int posicaoParaMover = Integer.parseInt(line.split(" ")[3]);
                if (line.contains("move") && (line.contains("on")))
                {
                    mundoDosBlocos.MoveOnto(blocosParaMover, posicaoParaMover);
                }
                else if (line.contains("move") && (line.contains("over")))
                {
                    mundoDosBlocos.MoveOver(blocosParaMover, posicaoParaMover);
                }
                else if (line.contains("pile") && (line.contains("on")))
                {
                    mundoDosBlocos.PileOnto(blocosParaMover, posicaoParaMover);
                }
                else
                {
                    mundoDosBlocos.PileOver(blocosParaMover, posicaoParaMover);
                }
            }
            line = br.readLine();
        }
        while(line != null);
        br.close();
        fr.close();
    }
}
