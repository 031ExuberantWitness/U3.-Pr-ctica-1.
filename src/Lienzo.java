
import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.Timer;

public class Lienzo extends Canvas{
    public Color color;
    public int x, y = 20;
    private Timer t, tt;
    private int contador = 0;
    
    Random rand = new Random();
    private int randomizer;
    
    FrmHome puntero;
    
    String frases[] =  {"Never in the field of human conflict was so much owed by so many to so few.","Success is not final, failure is not fatal: it is the courage to continue that counts.",
                        "In war there is no prize for the runner-up.","Ours is a world of nuclear giants and ethical infants. We know more about war than we know about peace, more about killing than we know about living.",
                        "The soldier above all others prays for peace, for it is the soldier who must suffer and bear the deepest wounds and scars of war.","They died hard, those savage men - like wounded wolves at bay. They were filthy, and they were lousy, and they stunk. And I loved them.",
                        "We must be prepared to make heroic sacrifices for the cause of peace that we make ungrudgingly for the cause of war. There is no task that is more important or closer to my heart.","Future years will never know the seething hell and the black infernal background, the countless minor scenes and interiors of the secession war; and it is best they should not. The real war will never get in the books.",
                        "There's no honorable way to kill, no gentle way to destroy. There is nothing good in war. Except its ending.","The death of one man is a tragedy. The death of millions is a statistic.",
                        "Death solves all problems - no man, no problem.","In the Soviet army it takes more courage to retreat than advance.",
                        "It is foolish and wrong to mourn the men who died. Rather we should thank God that such men lived.","Never think that war, no matter how necessary, nor how justified, is not a crime.",
                        "Every man's life ends the same way. It is only the details of how he lived and how he died that distinguish one man from another.","All wars are civil wars, because all men are brothers.",
                        "I have never advocated war except as a means of peace.","Older men declare war. But it is the youth that must fight and die.",
                        "Only the dead have seen the end of war.","Death is nothing, but to live defeated and inglorious is to die daily.",
                        "It is well that war is so terrible, or we should get too fond of it.","A soldier will fight long and hard for a bit of colored ribbon.",
                        "He who fears being conquered is sure of defeat.","You must not fight too often with one enemy, or you will teach him all your art of war.",
                        "If we don't end war, war will end us.","From my rotting body, flowers shall grow and I am in them and that is eternity.",
                        "He who has a thousand friends has not a friend to spare, And he who has one enemy will meet him everywhere.","For the Angel of Death spread his wings on the blast, And breathed in the face of the foe as he pass'd; And the eyes of the sleepers wax'd deadly and chill, And their hearts but once heaved, and for ever grew still!",
                        "They wrote in the old days that it is sweet and fitting to die for one's country. But in modern war, there is nothing sweet nor fitting in your dying. You will die like a dog for no good reason.","",
                        "War would end if the dead could return.","When you have to kill a man it costs nothing to be polite.",
                        "War is as much a punishment to the punisher as it is to the sufferer.","History will be kind to me for I intend to write it.",
                        "When you get to the end of your rope, tie a knot and hang on.","If the opposition disarms, well and good. If it refuses to disarm, we shall disarm it ourselves.",
                        "Better to fight for something than live for nothing.","Courage is fear holding on a minute longer.",
                        "We happy few, we band of brothers/For he today that sheds his blood with me/Shall be my brother.","We happy few, we band of brothers/For he today that sheds his blood with me/Shall be my brother.",};

    
    public void ssTop(){
        t.stop();
    }
    
    public Lienzo() {
        //Marquesina para que regrese al lado izquierdo una vez salga de la ventana.
        t = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x++;
                if(x > 1280){
                    x = -200;
                }
                
                repaint();
            }
        });
        
        //Controla el tiempo en el que el texto y color cambian.
        tt = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contador++;
                if(contador > 20){
                        randomizer = randomizer = rand.nextInt(40);
                        color = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
                        
                        contador = 0;
                }
                
                repaint();
            }
        });
        
        //Iniciadores
        t.start();
        tt.start();
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        this.setBackground(Color.gray);
        
        //String
        g2.setColor(color);
        g.setFont(new Font("Arial", Font.PLAIN, 25)); 
        g2.drawString(frases[randomizer], x, 30);
        
        //String que dice cuando tiempo pasa, quitarle // de comentario para que funcione.
        //g2.drawString("Tiempo: " + contador, x, 60);
    }
}
