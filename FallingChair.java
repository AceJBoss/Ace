import java.awt.* ;
import javax.swing.* ;
import java.awt.image.*;
import java.awt.geom.* ;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FallingChair extends JApplet implements Runnable
{
   int applet_width, applet_height ;

   Thread  animation_thread  =  null ;

   boolean  thread_must_be_executed  =  false ;

   BufferedImage offscreen_drawing_surface ;
   BufferStrategy buffer_strategy ;

   @Override
   public void init()
   {
      applet_width     =  getSize().width ;
      applet_height    =  getSize().height ;

      setIgnoreRepaint( true ) ;

      Canvas canvas_for_drawing = new Canvas();
      canvas_for_drawing.setIgnoreRepaint( true );
      canvas_for_drawing.setSize( applet_width, applet_height );
      
      add( canvas_for_drawing ) ;

      canvas_for_drawing.createBufferStrategy( 2 );
      buffer_strategy = canvas_for_drawing.getBufferStrategy();
   
      GraphicsEnvironment graphics_environment = GraphicsEnvironment.getLocalGraphicsEnvironment() ;
   
      GraphicsDevice graphics_device = graphics_environment.getDefaultScreenDevice() ;
   
      GraphicsConfiguration graphics_configuration = graphics_device.getDefaultConfiguration() ;
   
      offscreen_drawing_surface = graphics_configuration.createCompatibleImage( applet_width, applet_height ) ;
   }


   @Override
   public void start()
   {
      if ( animation_thread  ==  null )
      {
         animation_thread  =  new  Thread( this ) ;

         thread_must_be_executed  =  true ;

         animation_thread.start() ;
      }
   }

   @Override
   public void stop()
   {
      if ( animation_thread  !=  null )
      {
         animation_thread.interrupt() ;

         thread_must_be_executed  =  false ;

         animation_thread  =  null ;
      }
   }

   @Override
   public void paint(Graphics g)
   {
       super.paint(g);
       g.setColor(Color.red);
       g.fillRect(20, 10, 20, 10);
   }
   @Override
   public void run()
   {
      Graphics   graphics = null ;
      Graphics2D graphics2D = null ;
      Color background_color = Color.PINK ;
    
	  
      int frames_per_second = 0;
      int frames_during_last_second = 0;
      long total_time = 0;
      long current_time = System.currentTimeMillis();
      long previous_time = current_time;

      GeneralPath chair = new GeneralPath();
      
      chair.moveTo(200, 0);
      chair.lineTo(200, 100);
      chair.lineTo(270, 250);
      chair.lineTo(270, 350);
      
      GeneralPath  heart_shape  =  new  GeneralPath() ;

      heart_shape.moveTo( 0, 0 ) ;
      heart_shape.append( new Arc2D.Double( -100, -50, 100, 100, 0, 180, Arc2D.OPEN ), true ) ; 
      heart_shape.curveTo( -90, 60, -5, 90, 0, 150 ) ;
      heart_shape.curveTo(   5, 90, 90, 60, 100, 0 ) ;
      heart_shape.append( new Arc2D.Double(    0, -50, 100, 100, 0, 180, Arc2D.OPEN ), true ) ;
      heart_shape.closePath() ;

      double current_drawing_scale  =  1.00 ;

      boolean heart_is_enlarging  =  true ;

      while ( thread_must_be_executed  ==  true )
      {
         try
         {

            graphics2D = offscreen_drawing_surface.createGraphics();
            graphics2D.setColor( background_color );
            graphics2D.fillRect( 0, 0, applet_width, applet_height );
            graphics2D.setColor( Color.RED ) ;
            
            graphics2D.setFont( new Font( "Monospaced", Font.BOLD, 12 ) );
            graphics2D.drawString( "Animate A Heart That Beat on a line", 20, 20 );
            
            graphics2D.setColor( Color.RED ) ;  

            
            graphics2D.translate( applet_width / 2, applet_height / 5 * 2 ) ;
            //graphics2D.rotate(Math.toRadians(current_drawing_scale));
            graphics2D.draw( chair ) ;
	
            graphics = buffer_strategy.getDrawGraphics() ;
            graphics.drawImage( offscreen_drawing_surface, 0, 0, null ) ;
    
            if( ! buffer_strategy.contentsLost() )
            {
               buffer_strategy.show();
            }
            if ( heart_is_enlarging == true )
            {
               if ( current_drawing_scale < 90.0 )
               {
                  current_drawing_scale += 5.0 ;
               }
               else
               {
                  heart_is_enlarging  =  false ;

                  try
                  {
                     Thread.sleep( 100 ) ; 
                  }
                  catch ( InterruptedException  caught_exception )
                  {
                     thread_must_be_executed  =  false ;
                  }
               }
            }
            else
            {
               if ( current_drawing_scale  >  1.00 )
               {
                  current_drawing_scale  -= 5.0 ;
               }
               else
               {
                  heart_is_enlarging  =  true ;

                  try
                  {
                     Thread.sleep( 1000 ) ;
                  }
                  catch ( InterruptedException  caught_exception )
                  {
                     thread_must_be_executed  =  false ;
                  }
               }
            }
         }
         finally
         {
            if ( graphics != null ) 
            {
               graphics.dispose() ;
            }
   
            if ( graphics2D != null ) 
            {
               graphics2D.dispose() ;
            }
         }

         try
         {
            Thread.sleep( 2 ) ;  
         }
         catch ( InterruptedException  caught_exception )
         {
            thread_must_be_executed  =  false ;
         }
         previous_time = current_time ;
         current_time  = System.currentTimeMillis() ;
         total_time += current_time - previous_time ;
   
         if( total_time > 1000 )
         {
            total_time -= 1000;
            frames_per_second = frames_during_last_second ;
            frames_during_last_second = 0 ;
         }
    
         frames_during_last_second ++ ;
      } 
   }
}