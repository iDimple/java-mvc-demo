import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.util.Observer;
import java.util.Observable;

public class TextView extends JPanel implements Observer
{
Model model;

public TextView()
{
}
public TextView(Model model)
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
this.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.black,1),"TextView"));
}

public void paintComponent(Graphics g)
{
super.paintComponent(g);
if ( model == null ) return;
int x = 20,y = 50;
int h = g.getFontMetrics().getHeight();
for ( int i=0; i< model.size(); i++ )
{
Data data = model.getData(i);
g.drawString(data.name + ":",x,y);
x+= g.getFontMetrics().stringWidth(data.name) + 20;
g.drawString(String.valueOf(data.value),x,y);
y+=h;
x = 20;
}
}
// 当模型数据发生改变时，会自动调用此方法来刷新图形
public void update(Observable o, Object arg)
{
this.model =(Model) o;
repaint();
}
}