
import java.awt.Graphics;
// import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class Animation {
    private BufferedImage[] Images;
    private int numImages;
    private boolean ticksStopped;
    private boolean isRepeating;
    private int animTotalTime;
    private int animPeriod;
    private int seqDuration;
    private int showPeriod;
    private int imPosition;


    public Animation(String fileName,int num,int period,int duration,boolean repeat) {
        numImages=num;
        animPeriod=period;
        seqDuration=duration;
        isRepeating=repeat;
        
        animTotalTime=0;
        Images=setAnimImagesFromOneFile(fileName,numImages);

              imPosition = 0;
      ticksStopped = false;
      showPeriod = (int) (1000 * seqDuration / numImages);
    }

        public Animation(String prefixfileName,String postfixFileName ,int num,int period,int duration,boolean repeat) {
        numImages=num;
        animPeriod=period;
        seqDuration=duration;
        isRepeating=repeat;

        animTotalTime=0;
        Images=this.setAnimImagesFromFiles(prefixfileName, postfixFileName, num);

              imPosition = 0;
      ticksStopped = false;
      showPeriod = (int) (1000 * seqDuration / numImages);
    }

    public BufferedImage loadImage(String fnm) {
  
            BufferedImage im = new BufferedImage(fnm);
            return im;

    }

    public BufferedImage[] setAnimImagesFromOneFile(String fnm, int num) {
        BufferedImage bim = loadImage(fnm);
        BufferedImage[] ims = new BufferedImage[num];
        int imWidth = (int) bim.getWidth() / num;
        int imHeight = bim.getHeight();
//         Graphics g;
        for (int i = 0; i < num; i++) {
            ims[i]= new BufferedImage(imWidth,imHeight);
//             g=ims[i].getGraphics();
            ims[i].drawImage(bim,-i*imWidth,0);
 
        }
        return ims;
    }

   public BufferedImage[] setAnimImagesFromFiles(String prefixFileName,String postFileName, int num){
               BufferedImage[] ims = new BufferedImage[num];
       for(int i=0;i<num;i++){
           ims[i]=loadImage(prefixFileName+String.valueOf(i)+postFileName);
       }
               return ims;
   }


      public void updateImage()
  /* We assume that this method is called every animPeriod ms */
  {
    if (!ticksStopped) {
      // update total animation time, modulo the animation sequence duration
      animTotalTime = (animTotalTime + animPeriod) % (1000 * seqDuration);

      // calculate current displayable image position
      imPosition = (int) (animTotalTime / showPeriod);   // in range 0 to num-1

      if ((imPosition == numImages-1) && (!isRepeating)) {  // at end of sequence
        ticksStopped = true;   // stop at this image

      }
    }
  }
      public BufferedImage getCurrentImage(){
          return Images[imPosition];
      }
        public void stop()
  /* updateTick() calls will no longer update the
     total animation time or imPosition. */
  {  ticksStopped = true;  }

  public boolean isStopped()
  {  return ticksStopped;  }

    public void resume()
  // start at previous image position
  {
    if (numImages != 0)
      ticksStopped = false;
  }

      public void draw(BufferedImage g,int x ,int y){
          BufferedImage im=Images[imPosition];
          g.drawImage(im, x, y);
      }
}
