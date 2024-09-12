
package com.mycompany.tarea9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import static com.mycompany.tarea9.Tarea9.panelDeslizableExtra;
import java.io.File;


public class Tarea9 extends JFrame implements ActionListener{
    
    String nombreImagen, sAncho, sLargo;
    int Ancho, Largo, x, y, vRed, vGreen, vBlue;
    
    int[] totalRojo = new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
    0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
    0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
    0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
    0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
    0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
    0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
    0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    
    int[] totalVerde = new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
    0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
    0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
    0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
    0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
    0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
    0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
    0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    
    int[] totalAzul = new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
    0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
    0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
    0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
    0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
    0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
    0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
    0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    
    public BufferedImage imagen;

    private JMenuBar menuBar, menuExtra;
    private JMenu menu1, menu2, menu3, menuFiltros;
    private JMenuItem abrir, cerrar, hrojo, hverde, hazul, neg, brillo, 
            borde, sobelH, sobelV, prewittH, prewittV, laplaciano, personalizado;
    private JPanel panel;
    private JLabel nombre, ancho, largo, red, green, blue, equis, ye;
    static JScrollPane panelDeslizable = new JScrollPane();
    static JScrollPane panelDeslizableExtra = new JScrollPane();
    private JLabel foto = new JLabel();
    private JLabel fotoNeg = new JLabel();
    
    
    public Tarea9() {
        
        menuBar=new JMenuBar();
        setJMenuBar(menuBar);

        menu1=new JMenu("Archivo");
        menuBar.add(menu1);

        abrir=new JMenuItem("Abrir");
        menu1.add(abrir);
        abrir.addActionListener(this);
        cerrar=new JMenuItem("Cerrar Archivo");
        menu1.add(cerrar);
        cerrar.addActionListener(this);
        
        
        menu2 = new JMenu("Histogramas");
        menuBar.add(menu2);
        menu2.setEnabled(false);
        
        hrojo=new JMenuItem("Rojo");
        menu2.add(hrojo);
        hrojo.addActionListener(this);
        hverde=new JMenuItem("Verde");
        menu2.add(hverde);
        hverde.addActionListener(this);
        hazul=new JMenuItem("Azul");
        menu2.add(hazul);
        hazul.addActionListener(this);
        
        menu3 = new JMenu("Efectos");
        menuBar.add(menu3);
        menu3.setEnabled(false);
        
        neg = new JMenuItem("Negativo");
        menu3.add(neg);
        neg.addActionListener(this);
        brillo = new JMenuItem("Brillo");
        menu3.add(brillo);
        brillo.addActionListener(this);
        
        menuFiltros = new JMenu("Filtros");
        menuBar.add(menuFiltros);
        menuFiltros.setEnabled(false);
        
        
        
        borde = new JMenuItem("Borde");
        menuFiltros.add(borde);
        borde.addActionListener(this);
        sobelH = new JMenuItem("Sobel Horizontal");
        menuFiltros.add(sobelH);
        sobelH.addActionListener(this);
        sobelV = new JMenuItem("Sobel Vertical");
        menuFiltros.add(sobelV);
        sobelV.addActionListener(this);
        prewittH = new JMenuItem("Prewitt Horizontal");
        menuFiltros.add(prewittH);
        prewittH.addActionListener(this);
        prewittV = new JMenuItem("Prewitt Vertical");
        menuFiltros.add(prewittV);
        prewittV.addActionListener(this);
        laplaciano = new JMenuItem("Laplaciano");
        menuFiltros.add(laplaciano);
        laplaciano.addActionListener(this);
        personalizado = new JMenuItem("Personalizado");
        menuFiltros.add(personalizado);
        personalizado.addActionListener(this);
        
        nombre = new JLabel(nombreImagen);
        menuBar.add(nombre);
        ancho = new JLabel(sAncho);
        menuBar.add(ancho);
        largo = new JLabel(sLargo);
        menuBar.add(largo);
        
        equis = new JLabel();
        menuBar.add(equis);
        ye = new JLabel();
        menuBar.add(ye);
        
        red = new JLabel();
        menuBar.add(red);
        green = new JLabel();
        menuBar.add(green);
        blue = new JLabel();
        menuBar.add(blue);
        
        setJMenuBar(menuBar);       
        
        setTitle("Aplicacion 9 PDI");
        setSize(300, 200); //Dimensiones del JFrame
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setVisible(true);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDeslizable, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDeslizable, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        
        
        foto.addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    if (imagen != null){
                        x = e.getX();
                    
                        y = e.getY();

                        int packedInt = imagen.getRGB(e.getX(), e.getY());
                        Color color = new Color(packedInt, true);

                        equis.setText("  X: " + x);
                        ye.setText("  Y: " + y);

                        red.setText("  R: " + Integer.toString(color.getRed()));
                        //System.out.println(color.getRed());
                        green.setText("  G: " + Integer.toString(color.getGreen()));
                        blue.setText("  B: " + Integer.toString(color.getBlue()));
                    }
                }
            });
           
        pack();   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()==abrir) {
            JFileChooser archivo = new JFileChooser();
            archivo.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    
            FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif"); 
            archivo.setFileFilter(imgFilter);
            
            int result = archivo.showOpenDialog(this);
            
            if (result != JFileChooser.CANCEL_OPTION) {

                java.io.File fileName = archivo.getSelectedFile();
                nombreImagen = "        Nombre Archivo: " + fileName.getName();
                try{
                    imagen = ImageIO.read(fileName);
                } catch(IOException ex){
                    ex.printStackTrace();
                }
                
                foto.setIcon(new ImageIcon(fileName.toString()));
                foto.setHorizontalAlignment(JLabel.CENTER);
                panelDeslizable.getViewport().add(foto);
                
                if (imagen != null){
                    nombre.setText(nombreImagen);
                    Largo = imagen.getHeight(this);
                    Ancho = imagen.getWidth(this);
                    sAncho = "  (" + Ancho;
                    ancho.setText(sAncho);
                    sLargo = " x " + Largo+")";
                    largo.setText(sLargo);
                    menu2.setEnabled(true);
                    menu3.setEnabled(true);
                    menuFiltros.setEnabled(true);
                    
                    for(int i = 0;i < Largo; i += 1){
                        
                        for(int j = 0;j < Ancho; j += 1){
                            
                            int coloresInt = imagen.getRGB(j, i);
                            Color colores = new Color(coloresInt, true);
                            
                            totalRojo[colores.getRed()] += 1 ;
                            totalVerde[colores.getGreen()] += 1;
                            totalAzul[colores.getBlue()] += 1;   
                            
                        } 
                    }                   
                }
            }
        }
        
        if (e.getSource()==cerrar) {
            
            nombre.setText("");
            ancho.setText("");
            largo.setText("");
            imagen = null;
            foto.setIcon(null);
            equis.setText("");
            ye.setText("");
            red.setText("");
            green.setText("");
            blue.setText("");
            menu2.setEnabled(false);
            menu3.setEnabled(false);
            menuFiltros.setEnabled(false);
            
        }
        
        if (e.getSource()==hrojo){
            Histograma histoR = new Histograma(this, false,
                    totalRojo, "Rojo");
            histoR.setVisible(true);
        }
        
        if (e.getSource()==hverde){
            Histograma histoV = new Histograma(this, false,
                    totalVerde, "Verde");
            histoV.setVisible(true);
        }
        
        if (e.getSource()==hazul){
            Histograma histoA = new Histograma(this, false,
                    totalAzul, "Azul");
            histoA.setVisible(true);
        }
        
        if(e.getSource()==neg){
            
            int[][][] imgNeg = new int[Largo][Ancho][3];
            
            for(int i = 0;i < Largo; i += 1){
                for(int j = 0;j < Ancho; j += 1){
                            
                    int coloresInt = imagen.getRGB(j, i);
                    Color colores = new Color(coloresInt, true);
                            
                    imgNeg[i][j][0] = 255 - colores.getRed();
                    imgNeg[i][j][1] = 255 - colores.getGreen();
                    imgNeg[i][j][2] = 255 - colores.getBlue();
                            
                } 
            }
            
            int width = Ancho;
            int height = Largo;

            BufferedImage imageNeg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int rgb = imgNeg[y][x][0];
                    rgb = (rgb << 8) + imgNeg[y][x][1]; 
                    rgb = (rgb << 8) + imgNeg[y][x][2];
                    
                    imageNeg.setRGB(x, y, rgb);
                    
                } 
            }
            
            Extra nega = new Extra(/*this, false,*/ Largo, Ancho,
                    imageNeg, fotoNeg, "Negativo");
            nega.setVisible(true);
   
        }
        
        if(e.getSource() == brillo){
            
            int[][][] imgBrillo = new int[Largo][Ancho][3];
            
            for(int i = 0;i < Largo; i += 1){
                for(int j = 0;j < Ancho; j += 1){
                            
                    int coloresInt = imagen.getRGB(j, i);
                    Color colores = new Color(coloresInt, true);
                            
                    imgBrillo[i][j][0] = colores.getRed();
                    imgBrillo[i][j][1] = colores.getGreen();
                    imgBrillo[i][j][2] = colores.getBlue();
                            
                } 
            }
            
            int width = Ancho;
            int height = Largo;
            
            BufferedImage imageBrillo = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int rgb = imgBrillo[y][x][0];
                    rgb = (rgb << 8) + imgBrillo[y][x][1]; 
                    rgb = (rgb << 8) + imgBrillo[y][x][2];
                    
                    imageBrillo.setRGB(x, y, rgb);
                    
                } 
            }
            
            Brillo brillo = new Brillo(this, false, Largo, Ancho,
                    imageBrillo, fotoNeg);
            brillo.setVisible(true);
            
        }
        
        if(e.getSource() == borde){
            
            int[][] borde = {{-1,-1,-1},{-1,8,-1},{-1,-1,-1}};
            
            BufferedImage imageMatris = Matris3.Matris3(borde, "Filtro Borde", Largo, Ancho, imagen);
            Extra filtro = new Extra(/*this, false,*/ Largo, Ancho,
                    imageMatris, fotoNeg, "Filtro Borde");
            filtro.setVisible(true);
            
            
            
        }
        
        if(e.getSource() == sobelH){
            
            int[][] matris = {{-1,-1,-1},{0,0,0},{1,1,1}};
            
            BufferedImage imageMatris = Matris3.Matris3(matris, "Filtro Borde", Largo, Ancho, imagen);
            Extra filtro = new Extra(/*this, false,*/ Largo, Ancho,
                    imageMatris, fotoNeg, "Filtro Sobel Horizontal");
            filtro.setVisible(true);
            
        }
        
        if(e.getSource() == sobelV){
            
            int[][] matris = {{-1,0,1},{-1,0,1},{-1,0,1}};
            
            BufferedImage imageMatris = Matris3.Matris3(matris, "Filtro Borde", Largo, Ancho, imagen);
            Extra filtro = new Extra(/*this, false,*/ Largo, Ancho,
                    imageMatris, fotoNeg, "Filtro Sobel Vertical");
            filtro.setVisible(true);
            
        }
        
        if(e.getSource() == prewittH){
            
            int[][] matris = {{-1,-2,-1},{0,0,0},{1,2,1}};
            
            BufferedImage imageMatris = Matris3.Matris3(matris, "Filtro Borde", Largo, Ancho, imagen);
            Extra filtro = new Extra(/*this, false,*/ Largo, Ancho,
                    imageMatris, fotoNeg, "Filtro Prewitt Horizontal");
            filtro.setVisible(true);
            
        }
        
        if(e.getSource() == prewittV){
            
            int[][] matris = {{-1,0,1},{-2,0,2},{-1,0,1}};
            
            BufferedImage imageMatris = Matris3.Matris3(matris, "Filtro Borde", Largo, Ancho, imagen);
            Extra filtro = new Extra(/*this, false,*/ Largo, Ancho,
                    imageMatris, fotoNeg, "Filtro Prewitt Vertical");
            filtro.setVisible(true);
            
        }
        
        if(e.getSource() == laplaciano){
            
            int[][] matris = {{0,-1,0},{-1,4,-1},{0,-1,0}};
            
            BufferedImage imageMatris = Matris3.Matris3(matris, "Filtro Borde", Largo, Ancho, imagen);
            Extra filtro = new Extra(/*this, false,*/ Largo, Ancho,
                    imageMatris, fotoNeg, "Filtro Laplaciano");
            filtro.setVisible(true);
            
        }
        
        if(e.getSource() == personalizado){
            MatrisP matrisP = new MatrisP(/*this, false,*/ Largo, Ancho, imagen, fotoNeg);
            matrisP.setVisible(true);
        }
        
    }
    
    

    public static void main(String[] args) {

        new Tarea9().setVisible(true);

    }
}

class Matris3{
    public static BufferedImage Matris3(int[][] matris, String titulo, int Largo, int Ancho, BufferedImage imagen){
        
        int[][][] imgMatris = new int[Largo][Ancho][3];
            
            for(int i = 0;i < Largo; i += 1){
                for(int j = 0;j < Ancho; j += 1){
                            
                    int coloresInt = imagen.getRGB(j, i);
                    Color colores = new Color(coloresInt, true);
                    
                    

                    if (i == 0){
                                                
                        if(j==0){
                            
                            int color6 = imagen.getRGB(j+1, i);
                            Color rgb6 = new Color(color6, true);
                            
                            int color8 = imagen.getRGB(j, i+1);
                            Color rgb8 = new Color(color8, true);
                            
                            int color9 = imagen.getRGB(j+1, i+1);
                            Color rgb9 = new Color(color9, true);
                            
                            imgMatris[i][j][0] = (rgb6.getRed()* matris[1][2])
                                    + (colores.getRed()*matris[1][1]) + (rgb9.getRed()*matris[2][2])
                                    + (rgb8.getRed()*matris[2][1]);
                            
                            imgMatris[i][j][1] = (rgb6.getGreen()* matris[1][2])
                                    + (colores.getGreen()*matris[1][1]) + (rgb9.getGreen()*matris[2][2])
                                    + (rgb8.getGreen()*matris[2][1]);
                            
                            imgMatris[i][j][2] = (rgb6.getBlue()* matris[1][2])
                                    + (colores.getBlue()*matris[1][1]) + (rgb9.getBlue()*matris[2][2])
                                    + (rgb8.getBlue()*matris[2][1]);
                            
                        }
                        
                        else if(j == Ancho-1){
                            
                            int color4 = imagen.getRGB(j-1, i);
                            Color rgb4 = new Color(color4, true);
                            
                            int color7 = imagen.getRGB(j-1, i+1);
                            Color rgb7 = new Color(color7, true);
                            
                            int color8 = imagen.getRGB(j, i+1);
                            Color rgb8 = new Color(color8, true);
                            
                            imgMatris[i][j][0] = (rgb4.getRed()* matris[1][0])
                                    + (colores.getRed()*matris[1][1]) + (rgb7.getRed()*matris[2][0])
                                    + (rgb8.getRed()*matris[2][1]);
                            
                            imgMatris[i][j][1] = (rgb4.getGreen()* matris[1][0])
                                    + (colores.getGreen()*matris[1][1]) + (rgb7.getGreen()*matris[2][0])
                                    + (rgb8.getGreen()*matris[2][1]);
                            
                            imgMatris[i][j][2] = (rgb4.getBlue()*matris[1][0])
                                    + (colores.getBlue()*matris[1][1]) + (rgb7.getBlue()*matris[2][0])
                                    + (rgb8.getBlue()*matris[2][1]);
                            
                        }else{
                            
                            int color4 = imagen.getRGB(j-1, i);
                            Color rgb4 = new Color(color4, true);
                            
                            int color6 = imagen.getRGB(j+1, i);
                            Color rgb6 = new Color(color6, true);
                            
                            int color7 = imagen.getRGB(j-1, i+1);
                            Color rgb7 = new Color(color7, true);
                            
                            int color8 = imagen.getRGB(j, i+1);
                            Color rgb8 = new Color(color8, true);
                            
                            int color9 = imagen.getRGB(j+1, i+1);
                            Color rgb9 = new Color(color9, true);
                            
                            imgMatris[i][j][0] = (rgb4.getRed()* matris[1][0])+ (colores.getRed()*matris[1][1])
                                    + (rgb6.getRed()* matris[1][2]) + (rgb7.getRed()* matris[2][0])
                                    + (rgb8.getRed()*matris[2][1]) + (rgb9.getRed()*matris[2][2]);
                            
                            imgMatris[i][j][1] = (rgb4.getGreen()* matris[1][0])+ (colores.getGreen()*matris[1][1])
                                    + (rgb6.getGreen()* matris[1][2]) + (rgb7.getGreen()* matris[2][0])
                                    + (rgb8.getGreen()*matris[2][1]) + (rgb9.getGreen()*matris[2][2]);
                            
                            imgMatris[i][j][2] = (rgb4.getBlue()* matris[1][0])+ (colores.getBlue()*matris[1][1])
                                    + (rgb6.getBlue()* matris[1][2]) + (rgb7.getBlue()* matris[2][0])
                                    + (rgb8.getBlue()*matris[2][1]) + (rgb9.getBlue()*matris[2][2]);
                        }
                        
                    }else if (i == Largo - 1){
                        
                        if(j==0){
                            
                            int color2 = imagen.getRGB(j, i-1);
                            Color rgb2 = new Color(color2, true);
                            
                            int color3 = imagen.getRGB(j+1, i-1);
                            Color rgb3 = new Color(color3, true);
                            
                            int color6 = imagen.getRGB(j+1, i);
                            Color rgb6 = new Color(color6, true);
                            
                            imgMatris[i][j][0] = (rgb2.getRed()* matris[0][1])
                                    + (colores.getRed()*matris[1][1]) + (rgb3.getRed()*matris[0][2])
                                    + (rgb6.getRed()*matris[1][2]);
                            
                            imgMatris[i][j][1] = (rgb2.getGreen()* matris[0][1])
                                    + (colores.getGreen()*matris[1][1]) + (rgb3.getGreen()*matris[1][2])
                                    + (rgb6.getGreen()*matris[1][2]);
                            
                            imgMatris[i][j][2] = (rgb2.getBlue()* matris[0][1])
                                    + (colores.getBlue()*matris[1][1]) + (rgb3.getBlue()*matris[1][2])
                                    + (rgb6.getBlue()*matris[1][2]);
                            
                        }
                        
                        else if(j == Ancho-1){
                            
                            int color1 = imagen.getRGB(j-1, i-1);
                            Color rgb1 = new Color(color1, true);
                            
                            int color2 = imagen.getRGB(j, i-1);
                            Color rgb2 = new Color(color2, true);
                            
                            int color4 = imagen.getRGB(j-1, i);
                            Color rgb4 = new Color(color4, true);
                            
                            
                            imgMatris[i][j][0] = (rgb4.getRed()* matris[1][0])
                                    + (colores.getRed()*matris[1][1]) + (rgb1.getRed()*matris[0][0])
                                    + (rgb2.getRed()*matris[0][1]);
                            
                            imgMatris[i][j][1] = (rgb4.getGreen()* matris[1][0])
                                    + (colores.getGreen()*matris[1][1]) + (rgb1.getGreen()*matris[0][0])
                                    + (rgb2.getGreen()*matris[0][1]);
                            
                            imgMatris[i][j][2] = (rgb4.getBlue()*matris[1][0])
                                    + (colores.getBlue()*matris[1][1]) + (rgb1.getBlue()*matris[0][0])
                                    + (rgb2.getBlue()*matris[0][1]);
                            
                        }
                        else{
                            
                            int color1 = imagen.getRGB(j-1, i-1);
                            Color rgb1 = new Color(color1, true);
                            
                            int color2 = imagen.getRGB(j, i-1);
                            Color rgb2 = new Color(color2, true);
                            
                            int color3 = imagen.getRGB(j+1, i-1);
                            Color rgb3 = new Color(color3, true);
                            
                            int color4 = imagen.getRGB(j-1, i);
                            Color rgb4 = new Color(color4, true);
                            
                            int color6 = imagen.getRGB(j+1, i);
                            Color rgb6 = new Color(color6, true);
                            
                            
                            imgMatris[i][j][0] = (rgb4.getRed()* matris[1][0])+ (colores.getRed()*matris[1][1])
                                    + (rgb6.getRed()* matris[1][2]) + (rgb1.getRed()* matris[0][0])
                                    + (rgb2.getRed()*matris[0][1]) + (rgb3.getRed()*matris[0][2]);
                            
                            imgMatris[i][j][1] = (rgb4.getGreen()* matris[1][0])+ (colores.getGreen()*matris[1][1])
                                    + (rgb6.getGreen()* matris[1][2]) + (rgb1.getGreen()* matris[0][0])
                                    + (rgb2.getGreen()*matris[0][1]) + (rgb3.getGreen()*matris[0][2]);
                            
                            imgMatris[i][j][2] = (rgb4.getBlue()* matris[1][0])+ (colores.getBlue()*matris[1][1])
                                    + (rgb6.getBlue()* matris[1][2]) + (rgb1.getBlue()* matris[0][0])
                                    + (rgb2.getBlue()*matris[0][1]) + (rgb3.getBlue()*matris[0][2]);
                        }
                       
                    }else if (j == 0){
                        
                            int color2 = imagen.getRGB(j, i-1);
                            Color rgb2 = new Color(color2, true);
                            
                            int color3 = imagen.getRGB(j+1, i-1);
                            Color rgb3 = new Color(color3, true);

                            int color6 = imagen.getRGB(j+1, i);
                            Color rgb6 = new Color(color6, true);
                            
                            int color8 = imagen.getRGB(j, i+1);
                            Color rgb8 = new Color(color8, true);
                            
                            int color9 = imagen.getRGB(j+1, i+1);
                            Color rgb9 = new Color(color9, true);
                            
                            imgMatris[i][j][0] = (rgb2.getRed()* matris[0][1])+ (colores.getRed()*matris[1][1])
                                    + (rgb6.getRed()* matris[1][2]) + (rgb3.getRed()* matris[0][2])
                                    + (rgb8.getRed()*matris[2][1]) + (rgb9.getRed()*matris[2][2]);
                            
                            imgMatris[i][j][1] = (rgb2.getGreen()* matris[0][1])+ (colores.getGreen()*matris[1][1])
                                    + (rgb6.getGreen()* matris[1][2]) + (rgb3.getGreen()* matris[0][2])
                                    + (rgb8.getGreen()*matris[2][1]) + (rgb9.getGreen()*matris[2][2]);
                            
                            imgMatris[i][j][2] = (rgb2.getBlue()* matris[0][1])+ (colores.getBlue()*matris[1][1])
                                    + (rgb6.getBlue()* matris[1][2]) + (rgb3.getBlue()* matris[0][2])
                                    + (rgb8.getBlue()*matris[2][1]) + (rgb9.getBlue()*matris[2][2]);
                            
                    }else if(j == Ancho -1){
                        
                        int color2 = imagen.getRGB(j, i-1);
                            Color rgb2 = new Color(color2, true);
                            
                            int color1 = imagen.getRGB(j-1, i-1);
                            Color rgb1 = new Color(color1, true);

                            int color4 = imagen.getRGB(j-1, i);
                            Color rgb4 = new Color(color4, true);
                            
                            int color8 = imagen.getRGB(j, i+1);
                            Color rgb8 = new Color(color8, true);
                            
                            int color7 = imagen.getRGB(j-1, i+1);
                            Color rgb7 = new Color(color7, true);
                            
                            imgMatris[i][j][0] = (rgb2.getRed()* matris[0][1])+ (colores.getRed()*matris[1][1])
                                    + (rgb1.getRed()* matris[0][0]) + (rgb4.getRed()* matris[1][0])
                                    + (rgb8.getRed()*matris[2][1]) + (rgb7.getRed()*matris[2][0]);
                            
                            imgMatris[i][j][1] = (rgb2.getGreen()* matris[0][1])+ (colores.getGreen()*matris[1][1])
                                    + (rgb1.getGreen()* matris[0][0]) + (rgb4.getGreen()* matris[1][0])
                                    + (rgb8.getGreen()*matris[2][1]) + (rgb7.getGreen()*matris[2][0]);
                            
                            imgMatris[i][j][2] = (rgb2.getBlue()* matris[0][1])+ (colores.getBlue()*matris[1][1])
                                    + (rgb1.getBlue()* matris[0][0]) + (rgb4.getBlue()* matris[1][0])
                                    + (rgb8.getBlue()*matris[2][1]) + (rgb7.getBlue()*matris[2][0]);
                    }
                    
                    
                    else{
                        
                        int color1 = imagen.getRGB(j-1, i-1);
                        Color rgb1 = new Color(color1, true);
                            
                        int color2 = imagen.getRGB(j, i-1);
                        Color rgb2 = new Color(color2, true);
                            
                        int color3 = imagen.getRGB(j+1, i-1);
                        Color rgb3 = new Color(color3, true);
                        
                        int color4 = imagen.getRGB(j-1, i);
                        Color rgb4 = new Color(color4, true);
                            
                        int color6 = imagen.getRGB(j+1, i);
                        Color rgb6 = new Color(color6, true);
                            
                        int color7 = imagen.getRGB(j-1, i+1);
                        Color rgb7 = new Color(color7, true);
                            
                        int color8 = imagen.getRGB(j, i+1);
                        Color rgb8 = new Color(color8, true);
                            
                        int color9 = imagen.getRGB(j+1, i+1);
                        Color rgb9 = new Color(color9, true);
                            
                        imgMatris[i][j][0] = (rgb1.getRed()* matris[0][0])+ (rgb2.getRed()*matris[0][1])
                                +(rgb3.getRed()* matris[0][2])
                                +(rgb4.getRed()* matris[1][0])+ (colores.getRed()*matris[1][1])
                                + (rgb6.getRed()* matris[1][2]) + (rgb7.getRed()* matris[2][0])
                                + (rgb8.getRed()*matris[2][1]) + (rgb9.getRed()*matris[2][2]);
                            
                            imgMatris[i][j][1] = (rgb1.getGreen()* matris[0][0])+ (rgb2.getGreen()*matris[0][1])
                                +(rgb3.getGreen()* matris[0][2])
                                +(rgb4.getGreen()* matris[1][0])+ (colores.getGreen()*matris[1][1])
                                + (rgb6.getGreen()* matris[1][2]) + (rgb7.getGreen()* matris[2][0])
                                + (rgb8.getGreen()*matris[2][1]) + (rgb9.getGreen()*matris[2][2]);
                            
                            imgMatris[i][j][2] = (rgb1.getBlue()* matris[0][0])+ (rgb2.getBlue()*matris[0][1])
                                +(rgb3.getBlue()* matris[0][2])
                                +(rgb4.getBlue()* matris[1][0])+ (colores.getBlue()*matris[1][1])
                                + (rgb6.getBlue()* matris[1][2]) + (rgb7.getBlue()* matris[2][0])
                                + (rgb8.getBlue()*matris[2][1]) + (rgb9.getBlue()*matris[2][2]);
                        
                    }
                    
                    if (imgMatris[i][j][0] > 255){
                        imgMatris[i][j][0] = 255;
                    }else if(imgMatris[i][j][0] < 0){
                        imgMatris[i][j][0] = 0;
                    }
                    
                    if (imgMatris[i][j][1] > 255){
                        imgMatris[i][j][1] = 255;
                    }else if(imgMatris[i][j][1] < 0){
                        imgMatris[i][j][1] = 0;
                    }
                    
                    if (imgMatris[i][j][2] > 255){
                        imgMatris[i][j][2] = 255;
                    }else if(imgMatris[i][j][2] < 0){
                        imgMatris[i][j][2] = 0;
                    }
                          
                } 
            }
            
            
            int width = Ancho;
            int height = Largo;
            
            BufferedImage imageMatris = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int rgb = imgMatris[y][x][0];
                    rgb = (rgb << 8) + imgMatris[y][x][1]; 
                    rgb = (rgb << 8) + imgMatris[y][x][2];
                    
                    imageMatris.setRGB(x, y, rgb);
                    
                } 
            }
            
        return imageMatris;
    }
}

class Extra extends JDialog implements ActionListener{
    
    private JMenuItem guardar;
    private JMenu mG;
    private JMenuBar menuExtra;
    BufferedImage imagenExtra;
    
    public Extra(/*Tarea8 parent, boolean modal,*/ int Largo, int Ancho,
            BufferedImage imageExtra, JLabel fotoExtra, String titulo){
        //super(parent, modal);
        
        imagenExtra = imageExtra;
        
        menuExtra = new JMenuBar();
        setJMenuBar(menuExtra);
        
        mG = new JMenu("Guardar");
        menuExtra.add(mG);
        
        guardar = new JMenuItem("Guardar");
        guardar.addActionListener(this);
        mG.add(guardar);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDeslizableExtra, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDeslizableExtra, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        
        fotoExtra.setIcon(new ImageIcon(imageExtra));
        fotoExtra.setHorizontalAlignment(JLabel.CENTER);
        panelDeslizableExtra.getViewport().add(fotoExtra);
        
        setBounds(Ancho * 1/2,Largo * 1/10, Ancho * 3/4,Largo* 3/4);
        setTitle(titulo);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== guardar){
            Guardar save = new Guardar(imagenExtra);
        }
    }
    
}

class Brillo extends JDialog implements ActionListener{
    
    private JMenuItem brillo_5, brillo_4,brillo_3, brillo_2, brillo_1, 
            brillo1, brillo2, brillo3, brillo4, brillo5, guardar;
    private BufferedImage imagenBrillo, imBE;
    private int LargoB, AnchoB;
    private JLabel fotoExtra;
    private JMenuBar menu;
    private JMenu brillos, gu;
    private JLabel foto;
    
    public Brillo(Tarea9 parent, boolean modal, int Largo, int Ancho,
            BufferedImage imageExtra, JLabel fotoExtra){
        super(parent, modal);
        
        imagenBrillo = imageExtra;
        imBE = imageExtra;
        LargoB = Largo;
        AnchoB = Ancho;
        foto = fotoExtra;
        
        menu = new JMenuBar();
        brillos = new JMenu("Brillos");
        
        brillo_5 = new JMenuItem("-5");
        brillo_4 = new JMenuItem("-4");
        brillo_3 = new JMenuItem("-3");
        brillo_2 = new JMenuItem("-2");
        brillo_1 = new JMenuItem("-1");
        brillo1 = new JMenuItem("+1");
        brillo2 = new JMenuItem("+2");
        brillo3 = new JMenuItem("+3");
        brillo4 = new JMenuItem("+4");
        brillo5 = new JMenuItem("+5");
        
        
        gu = new JMenu("Guardar");
        menu.add(gu);
        guardar = new JMenuItem("Guardar");
        guardar.addActionListener(this);
        gu.add(guardar);
        
        setJMenuBar(menu);
        menu.add(brillos);
        brillos.add(brillo_5);
        brillos.add(brillo_4);
        brillos.add(brillo_3);
        brillos.add(brillo_2);
        brillos.add(brillo_1);
        brillos.add(brillo1);
        brillos.add(brillo2);
        brillos.add(brillo3);
        brillos.add(brillo4);
        brillos.add(brillo5);
        
        brillo_5.addActionListener(this);
        brillo_4.addActionListener(this);
        brillo_3.addActionListener(this);
        brillo_2.addActionListener(this);
        brillo_1.addActionListener(this);
        brillo1.addActionListener(this);
        brillo2.addActionListener(this);
        brillo3.addActionListener(this);
        brillo4.addActionListener(this);
        brillo5.addActionListener(this);
           
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDeslizableExtra, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDeslizableExtra, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        
        fotoExtra.setIcon(new ImageIcon(imageExtra));
        fotoExtra.setHorizontalAlignment(JLabel.CENTER);
        panelDeslizableExtra.getViewport().add(fotoExtra);
        
        setBounds(40,40,Ancho * 3/4,Largo* 3/4);
              
    }
    
    @Override
    public void actionPerformed(ActionEvent ev){
        
        if(ev.getSource()== guardar){
            Guardar save = new Guardar(imBE);
        }
        
        if(ev.getSource() == brillo_5){
            BufferedImage imgAlterada = ModificarBrillo(-100, imagenBrillo, LargoB, AnchoB);
            imBE = imgAlterada;
            
            foto.setIcon(new ImageIcon(imgAlterada));
            foto.setHorizontalAlignment(JLabel.CENTER);
            panelDeslizableExtra.getViewport().add(foto);
        }
        
        if(ev.getSource() == brillo_4){
            BufferedImage imgAlterada = ModificarBrillo(-80, imagenBrillo, LargoB, AnchoB);
            imBE = imgAlterada;
            foto.setIcon(new ImageIcon(imgAlterada));
            foto.setHorizontalAlignment(JLabel.CENTER);
            panelDeslizableExtra.getViewport().add(foto);
        }
        
        if(ev.getSource() == brillo_3){
            BufferedImage imgAlterada = ModificarBrillo(-60, imagenBrillo, LargoB, AnchoB);
            imBE = imgAlterada;
            foto.setIcon(new ImageIcon(imgAlterada));
            foto.setHorizontalAlignment(JLabel.CENTER);
            panelDeslizableExtra.getViewport().add(foto);
        }
        
        if(ev.getSource() == brillo_2){
            BufferedImage imgAlterada = ModificarBrillo(-40, imagenBrillo, LargoB, AnchoB);
            imBE = imgAlterada;
            foto.setIcon(new ImageIcon(imgAlterada));
            foto.setHorizontalAlignment(JLabel.CENTER);
            panelDeslizableExtra.getViewport().add(foto);
        }
        
        if(ev.getSource() == brillo_1){
            BufferedImage imgAlterada = ModificarBrillo(-20, imagenBrillo, LargoB, AnchoB);
            imBE = imgAlterada;
            foto.setIcon(new ImageIcon(imgAlterada));
            foto.setHorizontalAlignment(JLabel.CENTER);
            panelDeslizableExtra.getViewport().add(foto);
        }
        
        if(ev.getSource() == brillo5){
            BufferedImage imgAlterada = ModificarBrillo(100, imagenBrillo, LargoB, AnchoB);
            imBE = imgAlterada;
            foto.setIcon(new ImageIcon(imgAlterada));
            foto.setHorizontalAlignment(JLabel.CENTER);
            panelDeslizableExtra.getViewport().add(foto);
        }
        
        if(ev.getSource() == brillo4){
            BufferedImage imgAlterada = ModificarBrillo(80, imagenBrillo, LargoB, AnchoB);
            imBE = imgAlterada;
            foto.setIcon(new ImageIcon(imgAlterada));
            foto.setHorizontalAlignment(JLabel.CENTER);
            panelDeslizableExtra.getViewport().add(foto);
        }
        
        if(ev.getSource() == brillo3){
            BufferedImage imgAlterada = ModificarBrillo(60, imagenBrillo, LargoB, AnchoB);
            imBE = imgAlterada;
            foto.setIcon(new ImageIcon(imgAlterada));
            foto.setHorizontalAlignment(JLabel.CENTER);
            panelDeslizableExtra.getViewport().add(foto);
        }
        
        if(ev.getSource() == brillo2){
            BufferedImage imgAlterada = ModificarBrillo(40, imagenBrillo, LargoB, AnchoB);
            imBE = imgAlterada;
            foto.setIcon(new ImageIcon(imgAlterada));
            foto.setHorizontalAlignment(JLabel.CENTER);
            panelDeslizableExtra.getViewport().add(foto);
        }
        
        if(ev.getSource() == brillo1){
            BufferedImage imgAlterada = ModificarBrillo(20, imagenBrillo, LargoB, AnchoB);
            imBE = imgAlterada;
            foto.setIcon(new ImageIcon(imgAlterada));
            foto.setHorizontalAlignment(JLabel.CENTER);
            panelDeslizableExtra.getViewport().add(foto);
        }
    }
    
    private BufferedImage ModificarBrillo(int brillo, BufferedImage imagen, int Largo, int Ancho){
        
        int[][][] imgBrillo = new int[Largo][Ancho][3];
        int rojo, verde, azul;
        
        for(int i = 0;i < Largo; i += 1){
            for(int j = 0;j < Ancho; j += 1){
                            
                int coloresInt = imagen.getRGB(j, i);
                Color colores = new Color(coloresInt, true);
                
                if (brillo > 0){
                    rojo = colores.getRed() + brillo;
                    if (rojo > 255){
                        imgBrillo[i][j][0] = 255;
                    }else{
                        imgBrillo[i][j][0] = rojo;
                       
                    }
                    
                    verde = colores.getGreen() + brillo;
                    if (verde > 255){
                        imgBrillo[i][j][1] = 255;
                    }else{
                        imgBrillo[i][j][1] = verde;
                    }
                    
                    azul = colores.getBlue() + brillo;
                     if (azul > 255){
                        imgBrillo[i][j][2] = 255;
                    }else{
                        imgBrillo[i][j][2] = azul;
                    }
                    
                }else{
                    
                    rojo = colores.getRed() + brillo;
                    if (rojo < 0){
                        imgBrillo[i][j][0] = 0;
                    }else{
                        imgBrillo[i][j][0] = rojo;
                        
                    }

                    verde = colores.getGreen() + brillo;
                    if (verde < 0){
                        imgBrillo[i][j][1] = 0;
                    }else{
                        imgBrillo[i][j][1] = verde;
                    }
             
                    azul = colores.getBlue() + brillo;
                    if (azul < 0){
                        imgBrillo[i][j][2] = 0;
                    }else{
                        imgBrillo[i][j][2] = azul;
                    }
                }     
                            
            } 
        }
            
        int width = Ancho;
        int height = Largo;

        BufferedImage imageNeg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = imgBrillo[y][x][0];
                rgb = (rgb << 8) + imgBrillo[y][x][1]; 
                rgb = (rgb << 8) + imgBrillo[y][x][2];
                    
                imageNeg.setRGB(x, y, rgb);
                    
            } 
        }
        
        return imageNeg;    
        
    }
   
}

class Histograma extends JDialog{
      
    public Histograma(Tarea9 parent, boolean modal, int[] datos, String color){
        super(parent, modal);
        
        setLayout(null);
        setBounds(440,10,610,410);
        
        IntervalXYDataset dataset = createDataset(datos);
        JFreeChart chart = createChart(dataset, color);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
        
    }
    
    private IntervalXYDataset createDataset(int[] datos) {
        final XYSeries series = new XYSeries("Frecuencia");
        
        for (int i = 0; i<=255; i += 1){
            series.add(i, datos[i]);
        }
        
        final XYSeriesCollection dataset = new XYSeriesCollection(series);
        return dataset;
    }
    
    private JFreeChart createChart(IntervalXYDataset dataset, String color) {
        final JFreeChart chart = ChartFactory.createXYBarChart(
            "Histograma " + color,
            "X", 
            false,
            "Y", 
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );
        
        XYPlot plot = (XYPlot) chart.getPlot();
        
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        
        if(color == "Rojo"){
            renderer.setSeriesPaint( 0 , Color.RED );
        }else if(color == "Verde"){
            renderer.setSeriesPaint( 0 , Color.GREEN );
        }else{
            renderer.setSeriesPaint( 0 , Color.BLUE );
        }
        
        renderer.setBaseShapesFilled(false);
        renderer.setDrawOutlines(false);
        plot.setRenderer( renderer ); 
        
        return chart;    
    }
    
}



class MatrisP extends JDialog implements ActionListener{
    
    private JLabel mensMat, fotoNegM;
    private JPanel mensaje, mat, bot;
    private JTextField m1,m2,m3,m4,m5,m6,m7,m8,m9;
    private String n1,n2,n3,n4,n5,n6,n7,n8,n9;
    private int nu1,nu2,nu3,nu4,nu5,nu6,nu7,nu8,nu9, LargoM, AnchoM;
    private JButton enviar;
    GridLayout layout = new GridLayout(0,3);
    private BufferedImage imagenM;
    
    public MatrisP(/*Tarea8 parent, boolean modal, */int Largo, int Ancho, BufferedImage imagen, JLabel fotoNeg){
        
        //super(parent, modal);
        
        AnchoM = Ancho;
        LargoM = Largo;
        imagenM = imagen;
        fotoNegM = fotoNeg;
        
        mensaje = new JPanel();
        add(mensaje, BorderLayout.NORTH);
        
        mensMat = new JLabel("Ingrese únicamente caracteres numericos");
        mensaje.add(mensMat);
        
        mat = new JPanel();
        mat.setLayout(layout);
        
        //add(mat);
        
        m1 = new JTextField(5);
        mat.add(m1);
        
        m2 = new JTextField();
        mat.add(m2);
        
        m3 = new JTextField();
        mat.add(m3);
        
        m4 = new JTextField();
        mat.add(m4);
        
        m5 = new JTextField();
        mat.add(m5);
        
        m6 = new JTextField();
        mat.add(m6);
        
        m7 = new JTextField();
        mat.add(m7);
        
        m8 = new JTextField();
        mat.add(m8);
        
        m9 = new JTextField();
        mat.add(m9);
        
        add(mat, BorderLayout.CENTER);
        
        bot = new JPanel();
        add(bot, BorderLayout.SOUTH);
        
        enviar = new JButton("Terminar");
        enviar.addActionListener(this);
        bot.add(enviar);
        
        setTitle("Matris Personalizada");
        setSize(300,300);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == enviar){
            
            n1 = m1.getText();
            m1.setText("");
            n2 = m2.getText();
            m2.setText("");
            n3 = m3.getText();
            m3.setText("");
            n4 = m4.getText();
            m4.setText("");
            n5 = m5.getText();
            m5.setText("");
            n6 = m6.getText();
            m6.setText("");
            n7 = m7.getText();
            m7.setText("");
            n8 = m8.getText();
            m8.setText("");
            n9 = m9.getText();
            m9.setText("");
            
            
            
            if(n1.matches("^-?\\d+$") && n2.matches("^-?\\d+$") && n3.matches("^-?\\d+$")
                     && n4.matches("^-?\\d+$")  && n5.matches("^-?\\d+$")  && n6.matches("^-?\\d+$") 
                     && n7.matches("^-?\\d+$")  && n8.matches("^-?\\d+$")  && n9.matches("^-?\\d+$") ){
                
                nu1 = Integer.parseInt(n1);
                nu2 = Integer.parseInt(n2);
                nu3 = Integer.parseInt(n3);
                nu4 = Integer.parseInt(n4);
                nu5 = Integer.parseInt(n5);
                nu6 = Integer.parseInt(n6);
                nu7 = Integer.parseInt(n7);
                nu8 = Integer.parseInt(n8);
                nu9 = Integer.parseInt(n9);
                
                int[][] matris = {{nu1,nu2,nu3},{nu4,nu5,nu6},{nu7,nu8,nu9}};
              
                BufferedImage imageMatris = Matris3.Matris3(matris, "Filtro Borde", LargoM, AnchoM, imagenM);
                Extra filtro = new Extra(/*this, false,*/ LargoM, AnchoM,
                    imageMatris, fotoNegM, "Filtro Personalizado");
                filtro.setVisible(true);
                
            }else{
                
                Error error = new Error(this, false);
                error.setVisible(true);
                
            }
            
        }
    }
    
}

class Error extends JDialog{
    
    private JLabel menError;
    
    public Error(MatrisP parent, boolean modal){
        super(parent,modal);
        
        menError = new JLabel("Caracter Invalido");
        add(menError);
        
        setTitle("Error");
        setSize(60,60);
        
    }
}

class Guardar{
    public Guardar(BufferedImage asalvar){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File(".jpg"));
        fileChooser.setFileFilter(new FileNameExtensionFilter("*JPG & GIF", "jpg", "gif"));
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                ImageIO.write((BufferedImage) asalvar, "jpg", new File(file.getAbsolutePath()));
            } catch (IOException ex) {
                System.out.println("Error");
            }
        } else {
            System.out.println("Ninguna Imagen Seleccionada");
        }
    
    }
}