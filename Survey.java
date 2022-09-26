//imported packages
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
// survey class created and the Jframe is prepared
class Survey extends JFrame implements ActionListener {  
    
	// key features defined
	JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
    
    Survey(String s) {  
        super(s);  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++) {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        
        // buttons and borders defined
        b1=new JButton("Next");  
        b2=new JButton("Bookmark");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        add(b1);add(b2);  
        set();  
        l.setBounds(30,40,450,20);  
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30);
        
        // specify the option for the close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);  
    }  
    
    // function of the button is defined
    public void actionPerformed(ActionEvent e) {  
        if(e.getSource()==b1) {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==9) {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        } 
    
        // bookmark feature defined
        if(e.getActionCommand().equals("Bookmark")) {  
            JButton bk=new JButton("Bookmark"+x);  
            bk.setBounds(480,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9)  
                b2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        
        // for loop for bookmark
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Bookmark"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
        // result part created at the end of the survey
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            JOptionPane.showMessageDialog(this,"Your FutureUs Point: " + count);  
            System.exit(0);  
        }  
    }  
    // questions and answers defined
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Que1: You find it difficult to introduce yourself to other people.");  
            jb[0].setText("0-25");jb[1].setText("26-50");jb[2].setText("51-75");jb[3].setText("76-100");   
        }  
        if(current==1)  
        {  
            l.setText("Que2: You think you are more practical than creative.");  
            jb[0].setText("0-25");jb[1].setText("26-50");jb[2].setText("51-75");jb[3].setText("76-100");   
        }  
        if(current==2)  
        {  
            l.setText("Que3: People can rarely upset you.");  
            jb[0].setText("0-25");jb[1].setText("26-50");jb[2].setText("51-75");jb[3].setText("76-100");   
        }  
        if(current==3)  
        {  
            l.setText("Que4: Your travel plans are usually well thought out.");  
            jb[0].setText("0-25");jb[1].setText("26-50");jb[2].setText("51-75");jb[3].setText("76-100");   
        }  
        if(current==4)  
        {  
            l.setText("Que5: You are not usually the one to initiate conversations.");  
            jb[0].setText("0-25");jb[1].setText("26-50");jb[2].setText("51-75");jb[3].setText("76-100");   
        }  
        if(current==5)  
        {  
            l.setText("Que6: You rarely do anything out of sheer curiosity.");  
            jb[0].setText("0-25");jb[1].setText("26-50");jb[2].setText("51-75");jb[3].setText("76-100");   
        }  
        if(current==6)  
        {  
            l.setText("Que7: You feel superior to other people. ");  
            jb[0].setText("0-25");jb[1].setText("26-50");jb[2].setText("51-75");jb[3].setText("76-100");   

        }  
        if(current==7)  
        {  
            l.setText("Que8: Being organized is more important to you than keeping fit.");  
            jb[0].setText("0-25");jb[1].setText("26-50");jb[2].setText("51-75");jb[3].setText("76-100");   
         
        }  
        if(current==8)  
        {  
            l.setText("Que9: You are generally highly motivated and energetic.");  
            jb[0].setText("0-25");jb[1].setText("26-50");jb[2].setText("51-75");jb[3].setText("76-100");   
        }  
        if(current==9)  
        {  
            l.setText("Que10: Your mood can change very quickly.");  
            jb[0].setText("0-25");jb[1].setText("26-50");jb[2].setText("51-75");jb[3].setText("76-100");   

        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    // true and false calculated here
    boolean check()  
    {  
        if(current==0)  
            return(jb[1].isSelected());  
        if(current==1)  
            return(jb[2].isSelected());  
        if(current==2)  
            return(jb[3].isSelected());  
        if(current==3)  
            return(jb[0].isSelected());  
        if(current==4)  
            return(jb[2].isSelected());  
        if(current==5)  
            return(jb[2].isSelected());  
        if(current==6)  
            return(jb[1].isSelected());  
        if(current==7)  
            return(jb[3].isSelected());  
        if(current==8)  
            return(jb[1].isSelected());  
        if(current==9)  
            return(jb[2].isSelected());  
        return false;  
    }  
    // main part for Survey
    public static void main(String s[])  
    {  
        new Survey("FutureUs | Character Analysis Survey");  
    }  
}  