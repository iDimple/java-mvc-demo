
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.util.Observer;
import java.util.Observable;

public class GraphicsView extends JPanel implements Observer
{
Model model;

public GraphicsView()
{
}
public GraphicsView(Model model)
{
try
{
this.model = model;
jbInit();
}
catch(Exception e)
{
e.printStackTrace();
}
}
private void jbInit() throws Exception
{
this.setBackground(Color.white);
this.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.black,1),"GraphicsView"));
}

public void paintComponent(Graphics g)
{
super.paintComponent(g);
if ( model == null ) return;
int x = 10,y = 30;
int h = g.getFontMetrics().getHeight();
int width = this.getWidth();
int height = this.getHeight();
int sy = height / (model.size() +1);
int sx = width/ 2 -40;
for ( int i=0; i< model.size(); i++ )
{
Data data = model.getData(i);
int value = data.value;
int dx = 3;
int r = 3;
Color c = new Color((int)(255*Math.random()),(int)(255*Math.random()),(int)(255*Math.random()));
int cx = sx;
int cy = y+i * sy;
/*
for ( int j=0;j {
g.setColor(c);
g.drawOval(cx,cy,r,r);
r+=dx;
}
//*/
g.draw3DRect( cx,cy,value*2,15,true);
g.setColor(c);
g.fill3DRect(cx,cy,value*2,15,true );
g.drawString(data.name,25,cy+15);
}
}
// 当模型数据发生改变时，会自动调用此方法来刷新图形
public void update(Observable o, Object arg)
{
this.model =(Model) o;
repaint();
}
}
