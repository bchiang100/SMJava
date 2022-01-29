package projects;
// Photoshop program that can run several manipulations on 
// an image
// filler code by Mr. David

import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class Photoshop extends Component {

	// the name of the output file. will be determined by which methods are called
    private String outputName;
    
    // the 2d array of colors representing the image
    private Color[][] pixels;
    
    // the width and height of the image 
    private int w,h;
    

    // this method increases each color's rgb value by a given amount.
    // don't forget that rgb values are limited to the range [0,255]
    public void brighten(int amount) {
        outputName = "brightened_" + outputName;
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {

                Color c = pixels[i][j];

                int r = Math.max(0,Math.min(c.getRed()+amount,255));
                int g = Math.max(0,Math.min(c.getGreen()+amount,255));
                int b = Math.max(0,Math.min(c.getBlue()+amount,255));

                pixels[i][j] = new Color(r,g,b);

            }
        }
    }
    
    // flip an image either horizontally or vertically.
    public void flip(boolean horizontally) {
        outputName = (horizontally?"h":"v") + "_flipped_" + outputName;
        
        if (horizontally) {
	        for (int i = 0; i < h/2; i++) {
	            for (int j = 0; j < w; j++) {
	
	                Color c = pixels[i][j];
	                Color d = pixels[pixels.length - 1 - i][j];
	                int r = Math.max(0,Math.min(c.getRed(),255));
	                int g = Math.max(0,Math.min(c.getGreen(),255));
	                int b = Math.max(0,Math.min(c.getBlue(),255));
	                
	                int R = Math.max(0,Math.min(d.getRed(),255));
	                int G = Math.max(0,Math.min(d.getGreen(),255));
	                int B = Math.max(0,Math.min(d.getBlue(),255));
	                
	
	                pixels[i][j] = new Color(R,G,B);
	                pixels[pixels.length - 1 - i][j] = new Color(r, g, b);
	    
	
	            }
	
	        }
	    }
        else {
        	for (int i = 0; i < h; i++) {
	            for (int j = 0; j < w/2; j++) {
	
	                Color c = pixels[i][j];
	                Color d = pixels[i][pixels[i].length - 1 - j];
	                int r = Math.max(0,Math.min(c.getRed(),255));
	                int g = Math.max(0,Math.min(c.getGreen(),255));
	                int b = Math.max(0,Math.min(c.getBlue(),255));
	                
	                int R = Math.max(0,Math.min(d.getRed(),255));
	                int G = Math.max(0,Math.min(d.getGreen(),255));
	                int B = Math.max(0,Math.min(d.getBlue(),255));
	                
	
	                pixels[i][j] = new Color(R,G,B);
	                pixels[i][pixels[i].length - 1 - j] = new Color(r, g, b);
	    
	
	            }
	
	        }
        }
    }
    
    // negates an image
    // to do this: subtract each pixel's rgb value from 255 
    // and use this as the new value
    public void negate() {
        outputName = "negated_" + outputName;
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {

                Color c = pixels[i][j];

                int r = 255 - Math.max(0,Math.min(c.getRed(),255));
                if (r < 0) {
                	r = 0;
                }
                int g = 255 - Math.max(0,Math.min(c.getGreen(),255));
                if (g < 0) {
                	g = 0;
                }
                int b = 255 - Math.max(0,Math.min(c.getBlue(),255));
                if (b < 0) {
                	b = 0;
                }

                pixels[i][j] = new Color(r,g,b);

            }
        }
    }
    
    // this makes the image 'simpler' by redrawing it using only a few colors
    // to do this: for each pixel, find the color in the list that is closest to
    // the pixel's rgb value. 
    // use this predefined color as the rgb value for the changed image.
    public void simplify() {
    
    		// the list of colors to compare to. Feel free to change/add colors
    		Color[] colorList = {Color.BLUE, Color.RED,Color.ORANGE, Color.MAGENTA,
                Color.BLACK, Color.WHITE, Color.GREEN, Color.YELLOW, Color.CYAN};
        outputName = "simplified_" + outputName;
        	
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {


                double diff = Integer.MAX_VALUE;	
                int diffI = 0;


                for(int k = 0; k < colorList.length; k++) {
                    double temp = distance(pixels[i][j], colorList[k]);
                    
                    if (temp < diff) {
                    	diff = temp;
                    	diffI=k;
                    }
                }
                pixels[i][j] = colorList[diffI];   
            }
        }
    }
    
    // optional helper method (recommended) that finds the 'distance' 
    // between two colors.
    // use the 3d distance formula to calculate
    public double distance(Color c1, Color c2) {
    	
    	int r = Math.max(0,Math.min(c1.getRed(),255));
        int g = Math.max(0,Math.min(c1.getGreen(),255));
        int b = Math.max(0,Math.min(c1.getBlue(),255));
        
        int R = Math.max(0,Math.min(c2.getRed(),255));
        int G = Math.max(0,Math.min(c2.getGreen(),255));
        int B = Math.max(0,Math.min(c2.getBlue(),255));
        
        double distance = Math.sqrt(Math.pow(R-r, 2) + Math.pow(G-g, 2) + Math.pow(B-b, 2));
    		return distance;
    }
    
    // this blurs the image
    // to do this: at each pixel, sum the 8 surrounding pixels' rgb values 
    // with the current pixel's own rgb value. 
    // divide this sum by 9, and set it as the rgb value for the blurred image
    public void blur() {
		outputName = "blurred_" + outputName;
		for (int i = 0; i < h-2; i++) {
			for (int j = 0; j < w-2; j++) {
				
                int avgR = 0;
        		int avgG = 0;
        		int avgB = 0;
        		
                for (int k = i; k < i+3; k++) {
                	for (int l = j; l < j+3; l++) {
                		Color c = pixels[k][l];
                		int r = Math.max(0,Math.min(c.getRed(),255));
                        int g = Math.max(0,Math.min(c.getGreen(),255));
                        int b = Math.max(0,Math.min(c.getBlue(),255));
                		avgR += r;
                		avgG += g;
                		avgB += b;	
                	}
                }
        		
                avgR/=9;
                avgG/=9;
                avgB/=9;

                pixels[i+1][j+1] = new Color(avgR, avgG, avgB);
			}
		}
    }
	
    
    // this highlights the edges in the image, turning everything else black. 
    // to do this: at each pixel, sum the 8 surrounding pixels' rgb values. 
    // now, multiply the current pixel's rgb value by 8, then subtract the sum.
    // this value is the rgb value for the 'edged' image
    public void edge() {
        outputName = "edged_" + outputName;
        Color pixelsTemp[][] = new Color[h][w];
        
        for (int i = 0; i < h-3; i++) {
			for (int j = 0; j < w-3; j++) {
				
                int sumR = 0;
        		int sumG = 0;
        		int sumB = 0;
        		
        		int centerR = 0;
        		int centerG = 0;
        		int centerB = 0;
        		
                for (int k = i; k < i+3; k++) {
                	for (int l = j; l < j+3; l++) {
                		Color c = pixels[k][l];
                		Color d = pixels[k+1][l+1];
                		if (k == i + 1 && l == j + 1) {
                			centerR = Math.max(0,Math.min(d.getRed(),255));
                            centerG = Math.max(0,Math.min(d.getGreen(),255));
                            centerB = Math.max(0,Math.min(d.getBlue(),255));

                            
                		} else {
                		int r = Math.max(0,Math.min(c.getRed(),255));
                        int g = Math.max(0,Math.min(c.getGreen(),255));
                        int b = Math.max(0,Math.min(c.getBlue(),255));              
                		sumR += r;
                		sumG += g;
                		sumB += b;
                		}
                	}
                }
        		
        		centerR *= 8;
        		centerG *= 8;
        		centerB *= 8;
        		
        		centerR -= sumR;
        		centerG -= sumG;
        		centerB -= sumB;
                
                if (centerR < 0) {
                	centerR = 0;
                }
                if (centerG < 0) {
                	centerG = 0;
                }
                if (centerB < 0) {
                	centerB = 0;
                }
                if (centerR > 255) {
                	centerR = 255;
                }
                if (centerG > 255) {
                	centerG = 255;
                }
                if (centerB > 255) {
                	centerB = 255;
                }
                pixelsTemp[i+1][j+1] = new Color(centerR, centerG,  centerB);
			}
		}
        for (int m = 0; m < h; m++) {
        	for (int n = 0; n < w; n++) {
        		if (pixelsTemp[m][n] == null) {
        			pixels[m][n] = new Color(255, 255, 255);
        			continue;
        		}
        		pixels[m][n] = pixelsTemp[m][n];
        	}
        }
    }
    
    public void replace(boolean red) {
    	outputName = (red?"r":"b") + "_replaced_" + outputName;
    	if (red) {
	    	for (int i = 0; i < h; i++) {
	            for (int j = 0; j < w; j++) {
	
	                Color c = pixels[i][j];
	
	                int r = Math.max(0,Math.min(c.getRed(),255));
	                int g = Math.max(0,Math.min(c.getGreen(),255));
	                int b = Math.max(0,Math.min(c.getBlue(),255));
	                
	                if (r >= 150 && r <= 255 && g >= 0 && g <= 70 && b >= 0 && b <= 50) {
	                	r = 0;
	                	g = 0;
	                	b = 255;
	                }
	
	                pixels[i][j] = new Color(r,g,b);
	
	            }
	
	        }
    	}
    	else {
    		for (int i = 0; i < h; i++) {
	            for (int j = 0; j < w; j++) {
	
	                Color c = pixels[i][j];
	
	                int r = Math.max(0,Math.min(c.getRed(),255));
	                int g = Math.max(0,Math.min(c.getGreen(),255));
	                int b = Math.max(0,Math.min(c.getBlue(),255));
	                
	                
	                if (r >= 0 && r <= 50 && g >= 0 && g <= 255 && b >= 150 && b <=255) {
	                	r = 255;
	                	g = 0;
	                	b = 0;
	                }
	
	                pixels[i][j] = new Color(r,g,b);
	
	            }
	
	        }
    	}
    }
    
    
    // *************** DON'T MESS WITH THE BELOW CODE **************** //
    
    // feel free to check it out, but don't change it unless you've consulted 
    // with Mr. David and understand what the code's doing
    
    

    public void run() {
    	JFileChooser fc = new JFileChooser();
		File workingDirectory = new File(System.getProperty("user.dir")+System.getProperty("file.separator")+ "Images");
		fc.setCurrentDirectory(workingDirectory);
		fc.showOpenDialog(null);
		File my_file = fc.getSelectedFile();
		if (my_file == null)
			System.exit(-1);
		
		// reads the image file and creates our 2d array
        BufferedImage image;
		try {
			image = ImageIO.read(my_file);
		
	        BufferedImage new_image = new BufferedImage(image.getWidth(),
	                        image.getHeight(), BufferedImage.TYPE_INT_ARGB);
	        create_pixel_array(image);
			outputName = my_file.getName();
			
			// runs the manipulations determined by the user
			System.out.println("Enter the manipulations you would like to run on the image.\nYour "
					+ "choices are: brighten, flip, negate, blur, edge, simplify, or replace.\nEnter each "
					+ "manipulation you'd like to run, then type in 'done'.");
			Scanner in = new Scanner(System.in);
			String action = in.next().toLowerCase();
			while (!action.equals("done")) {
	    			try {
		    			if (action.equals("brighten")) {
		    				System.out.println("enter an amount to increase the brightness by");
		    				int brightness = in.nextInt();
		        			Method m = getClass().getDeclaredMethod(action, int.class);
		        			m.invoke(this, brightness);
		    			}
		    			else if (action.equals("flip")) {
		    				System.out.println("enter \"h\" to flip horizontally, anything else to flip vertically.");
		        			Method m = getClass().getDeclaredMethod(action, boolean.class);
		        			m.invoke(this, in.next().equals("h"));
		    			}
		    			else if (action.equals("replace")) {
		    				System.out.println("enter \"r\" to replace all red colors to blue, anything else to replace all blue colors to red.");
		        			Method m = getClass().getDeclaredMethod(action, boolean.class);
		        			m.invoke(this, in.next().equals("r"));
		    			}
		    			else {
		        			Method m = getClass().getDeclaredMethod(action);
		        			m.invoke(this, new Object[0]);
		    			}
		    			System.out.println("done. enter another action, or type 'done'");
	    			}
	    			catch (NoSuchMethodException e) {
	    				System.out.println("not a valid action, try again");
	    			} catch (IllegalAccessException e) {e.printStackTrace();System.exit(1);} 
	    			catch (IllegalArgumentException e) {e.printStackTrace();System.exit(1);}
	    			catch (InvocationTargetException e) {e.printStackTrace();System.exit(1);}
	    			
	    			action = in.next().toLowerCase();
	    		} 
	        in.close();
	        
	        // turns our 2d array of colors into a new png file
	        create_new_image(new_image);
	        File output_file = new File("Images/" + outputName);
	        ImageIO.write(new_image, "png", output_file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
		
    
    public void create_pixel_array(BufferedImage image) {
        w = image.getWidth();
        h = image.getHeight();
        pixels = new Color[h][];
        for (int i = 0; i < h; i++) {
            pixels[i] = new Color[w];
            for (int j = 0; j < w; j++) {
                pixels[i][j] = new Color(image.getRGB(j,i));
            }
        }
    }

    public void create_new_image(BufferedImage new_image) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
            		new_image.setRGB(j, i, pixels[i][j].getRGB());
            }
        }
    }

    public static void main(String[] args) {
		new Photoshop();
	}

    public Photoshop() {
		run();
    }
}
