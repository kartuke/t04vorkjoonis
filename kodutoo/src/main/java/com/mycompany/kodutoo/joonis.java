package com.mycompany.kodutoo;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.net.*;
import java.io.*;

public class joonis{
    public static void main(String[] arg) throws Exception{
        BufferedImage bi=new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
        Graphics g=bi.createGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 500, 500);
        String aadress="http://www.tlu.ee/~jaagup/veeb1/loomad.txt";
        BufferedReader br=new BufferedReader(new InputStreamReader(
          new URL(aadress).openStream()));
        String rida=br.readLine();
        rida=br.readLine();
        
        //muutujad:
        String mass=new String("");
        String kõrg=new String("");

        while(rida!=null){
            String[] m=rida.split(",");
            if(m[0].equals("kass")){
                g.setColor(Color.orange);
                mass= m[1];
                kõrg=m[2];
          
            }
            else{
                g.setColor(Color.white);
                mass= m[1];
                kõrg=m[2];
            }
            g.drawString(mass,Integer.parseInt(m[1])/10,Integer.parseInt(m[1])/10);//string,int x, int y
            g.drawString(kõrg,Integer.parseInt(m[2])/10,Integer.parseInt(m[2])/10);//string intx int y
            rida=br.readLine();
        }
        ImageIO.write(bi, "png", new File("loomad.png"));
    }
}
