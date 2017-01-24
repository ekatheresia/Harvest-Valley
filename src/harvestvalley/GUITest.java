package harvestvalley;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.Timer;
import java.io.File;
import java.util.Formatter;     
import java.io.FileNotFoundException;
import java.io.FileReader;

public class GUITest extends JFrame implements KeyListener, MouseMotionListener, MouseListener
{
    //SCREEN
    private final static int ScreenWidth = 1280;
    private final static int ScreenHeight = 720;
    
    //JTextField
    JPanel jp = new JPanel();
    JLabel jl = new JLabel();
    JTextField jt = new JTextField(30);
    JButton jb = new JButton("Enter");
    
    //Atributes
    Player player;
    Field field;
    Time time;
    MainTime maintime;
    Barn barn;
    Coop coop;
    Rumah house;
    
    //untuk back from map
    boolean a = false,b = false,c = false,d = false,d1 = false,f = false;
    
    //Player Using Tools
    //Hoe
    private Animation nh;
    private Animation sh;
    private Animation wh;
    private Animation eh;
    //Sickle
    private Animation ns;
    private Animation ss;
    private Animation ws;
    private Animation es;
    //Take Water
    private Animation ntw;
    private Animation stw;
    private Animation wtw;
    private Animation etw;
    //Watering Can
    private Animation nwc;
    private Animation swc;
    private Animation wwc;
    private Animation ewc;
    //Milker
    private Animation emk;
    private Animation wmk;
    private Animation nmk;
    private Animation smk;
    //Clipper
    private Animation ecl;
    private Animation wcl;
    private Animation ncl;
    private Animation scl;
    //Player Movement
    private Animation nm;
    private Animation sm;
    private Animation wm;
    private Animation em;
    private Animation sl;
    private final Image playerIconNorth = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\JackBelakang1a.png").getImage();
    private final Image playerIconSouth = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\JackDepan1a.png").getImage();
    private final Image playerIconWest = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\JackBarat1a.png").getImage();
    private final Image playerIconEast = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\JackTimur1a.png").getImage();
    private boolean isMoving; //kondisi apakah player sedang bergerak atau tidak
    private boolean isUsingTools;//kondisi apakah pemain menggunakan tools
    //Background
    private Image timebackground = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Time-banner.png").getImage();
    private Image toolsactivebackground = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Tools-active-background.png").getImage();
    private Image mapbackground = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\peta.png").getImage();
    private Image fieldbackground = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\field.png").getImage();
    private Image jackhead = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\jackhead.png").getImage();
    //Image
    private Image plot = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\unwatered.png").getImage();
    private Image plotwatered = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Watered.png").getImage();
    private Image plotseed = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Seed.png").getImage();
    private Image pond = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Pond.png").getImage();
    //Corn
    private Image cornmature = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Corn-mature.png").getImage();
    private Image cornharvest = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Corn-harvest.png").getImage();
    private Image cornwithered = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Corn-withered.png").getImage();
    private Image corn = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Corn.png").getImage();
    //Cabbage
    private Image cabbagemature = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Cabbage-mature.png").getImage();
    private Image cabbageharvest = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Cabbage-harvest.png").getImage();
    private Image cabbagewithered = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Cabbage-withered.png").getImage();
    private Image cabbage = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Cabbage.png").getImage();
    //Turnip
    private Image turnipmature = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Turnip-mature.png").getImage();
    private Image turnipharvest = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Turnip-harvest.png").getImage();
    private Image turnipwithered = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Turnip-withered.png").getImage();
    private Image turnip = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Turnip.png").getImage();
    //Carrot
    private Image carrotmature = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Carrot-mature.png").getImage();
    private Image carrotharvest = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Carrot-harvest.png").getImage();
    private Image carrotwithered = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Carrot-withered.png").getImage();
    private Image carrot = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Carrot.png").getImage();
    //Tomato
    private Image tomatomature = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Tomato-mature.png").getImage();
    private Image tomatoharvest = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Tomato-harvest.png").getImage();
    private Image tomatowithered = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Tomato-withered.png").getImage();
    private Image tomato = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Tomato.png").getImage();
    //Grass
    private Image grassharvest = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Grass-mature.png").getImage();
    private Image grasswithered = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Grass-withered.png").getImage();
    private Image fodder = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Fodder.png").getImage();
    //Tools
    private Image hoe = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\a2.png").getImage();
    private Image sickle = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\a3.png").getImage();
    private Image wateringcan = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\WateringCan.png").getImage();
    private Image milker = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Milker.png").getImage();
    private Image clipper = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Clipper.png").getImage();

    //Jack Using Tool
    //Hoe
    //North
    private Image hoenorth1 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-hoe-north-1.png").getImage();
    private Image hoenorth2 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-hoe-north-2.png").getImage();
    private Image hoenorth3 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-hoe-north-3.png").getImage();
    private Image hoenorth4 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-hoe-north-4.png").getImage();
    private Image hoenorth5 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-hoe-north-5.png").getImage();
    private Image hoenorth6 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-hoe-north-6.png").getImage();
    //South
    private Image hoesouth1 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-hoe-south-1.png").getImage();
    private Image hoesouth2 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-hoe-south-2.png").getImage();
    private Image hoesouth3 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-hoe-south-3.png").getImage();
    private Image hoesouth4 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-hoe-south-4.png").getImage();
    private Image hoesouth5 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-hoe-south-5.png").getImage();
    private Image hoesouth6 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-hoe-south-6.png").getImage();
    //West
    private Image hoewest1 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-hoe-west-1.png").getImage();
    private Image hoewest2 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-hoe-west-2.png").getImage();
    private Image hoewest3 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-hoe-west-3.png").getImage();
    private Image hoewest4 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-hoe-west-4.png").getImage();
    private Image hoewest5 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-hoe-west-5.png").getImage();
    private Image hoewest6 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-hoe-west-6.png").getImage();
    //East
    private Image hoeeast1 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-hoe-east-1.png").getImage();
    private Image hoeeast2 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-hoe-east-2.png").getImage();
    private Image hoeeast3 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-hoe-east-3.png").getImage();
    private Image hoeeast4 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-hoe-east-4.png").getImage();
    private Image hoeeast5 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-hoe-east-5.png").getImage();
    private Image hoeeast6 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-hoe-east-6.png").getImage();
    //Jack Using Tool
    //Sickle
    //North
    private Image sicklenorth1 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-sickle-north-1.png").getImage();
    private Image sicklenorth2 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-sickle-north-2.png").getImage();
    //South
    private Image sicklesouth1 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-sickle-south-1.png").getImage();
    private Image sicklesouth2 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-sickle-south-2.png").getImage();
    //West
    private Image sicklewest1 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-sickle-west-1.png").getImage();
    private Image sicklewest2 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-sickle-west-2.png").getImage();
    //East
    private Image sickleeast1 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-sickle-east-1.png").getImage();
    private Image sickleeast2 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-sickle-east-2.png").getImage();
    //Take Water
    private int wateringcanIndex;
    //North
    private Image takewaternorth1 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-takewater-north-1.png").getImage();
    private Image takewaternorth2 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-takewater-north-2.png").getImage();
    //South
    private Image takewatersouth1 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-takewater-south-1.png").getImage();
    private Image takewatersouth2 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-takewater-south-2.png").getImage();
    //West
    private Image takewaterwest1 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-takewater-west-1.png").getImage();
    private Image takewaterwest2 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-takewater-west-2.png").getImage();
    //East
    private Image takewatereast1 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-takewater-east-1.png").getImage();
    private Image takewatereast2 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-takewater-east-2.png").getImage();
    //Watering Can
    //North
    private Image wateringcannorth1 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-wateringcan-north-1.png").getImage();
    private Image wateringcannorth2 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-wateringcan-north-2.png").getImage();
    //South
    private Image wateringcansouth1 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-wateringcan-south-1.png").getImage();
    private Image wateringcansouth2 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-wateringcan-south-2.png").getImage();
    //West
    private Image wateringcanwest1 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-wateringcan-west-1.png").getImage();
    private Image wateringcanwest2 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-wateringcan-west-2.png").getImage();
    //East
    private Image wateringcaneast1 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-wateringcan-east-1.png").getImage();
    private Image wateringcaneast2 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-wateringcan-east-2.png").getImage();
    
    //Clipper
    private Image clipperwest = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\ClipperKiri.png").getImage();
    private Image clippereast = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\ClipperKanan.png").getImage();
    private Image clippersouth = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\ClipperDepan.png").getImage();
    private Image clippernorth = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\ClipperBelakang.png").getImage();
    
    //Milker
    private Image milkerwest = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-milker-west.png").getImage();
    private Image milkereast = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-milker-east.png").getImage();
    private Image milkersouth = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-milker-south.png").getImage();
    private Image milkernorth = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Jack-milker-north.png").getImage();
    
    //Livestock
    private Image cow = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\CowDepan1a.png").getImage();
    private Image sheep = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\SheepTimur1f.png").getImage();
    private Image cowb = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\CowBarat1e.png").getImage();
    private Image chicken = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Chicken6.png").getImage();
    
    //Animal Feed
    private Image fodderimg = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Fodder.png").getImage();
    boolean fodderstate;
    private Image chickfeedimg = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\chickenfeed.png").getImage();
    boolean chickfeed;
    
    //Seed Items
    private Image turnipseed = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Seed_Lobak.png").getImage();
    private Image cornseed = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Seed_Jagung.png").getImage();
    private Image tomatoseed = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Seed_Tomato.png").getImage();
    private Image cabbageseed = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Seed_3.png").getImage();
    private Image grassseed = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Seed_4.png").getImage();
    private Image carrotseed = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Seed_5.png").getImage();
    
    //Products
    private Image milk = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\milk.png").getImage();
    private Image wool = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\wol.png").getImage();
    private Image egg = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\egg.png").getImage();
    
    //Furniture
    private Image bed = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Bed.png").getImage();
    private Image bookshelf = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Bookshelf.png").getImage();
    private Image cupboard = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\cupboard.png").getImage();
    private Image tv = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Tv.png").getImage();
    private Image box = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Box.png").getImage();
    boolean sleeping=false;
    
    //Icon
    private Image cowic = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Icon_Cow.png").getImage();
    private Image chickenic = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Icon_Chicken.png").getImage();
    private Image sheepic = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Icon_Sheep.png").getImage();
    private Image playeric = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Icon_Jack.png").getImage();
    private Image gold = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\gold.png").getImage();
    
    //Buildings
    private Image barnbg = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Barn.png").getImage();
    private Image coopbg = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\ChickenCoop.png").getImage();
    private Image inventbg = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\iinventbg.png").getImage();
    private Image housebg = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\housebg.png").getImage();
    private Image houseb = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\house.png").getImage();
    private Image barnb = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\barnb.png").getImage();
    private Image coopb = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Coop.png").getImage();
    private Image buildingbg = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\buildingbg.png").getImage();
    
    //Scene
    boolean scenefield;
    boolean scenebuilding;
    boolean scenebuysell;
    boolean scenebarn;
    boolean scenecoop;
    boolean scenehouse;
    boolean sceneinvent;
    boolean scenemap;
    boolean scenemainmenu;
    boolean issaving;
    boolean entername;
    
    //Load game
    String cek;
	//inner Class
	public class PanelGUI extends JPanel
        {
	    public int delay 	= 50; 	
	    PanelGUI()
	    {
		 ActionListener counter = new ActionListener() {
			public void actionPerformed(ActionEvent evt) 
			{ 
			      repaint();
			}};
		 new Timer(delay, counter).start();
	    }

	    public void paintComponent(Graphics g)
	    {
		super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, ScreenWidth, ScreenHeight);
                if(scenefield) {
                    drawSceneField(g);
                    g.drawImage(toolsactivebackground, 1150, 570, null);
                    drawActiveTools(g);
                    drawTime(g);
                    if (maintime.getTime().getHours()==3) { // Kasus jika pemain terjaga hingga pukul 3 pagi
                        scenehouse=true;
                    }
                }
                if(scenebarn) {
                    drawSceneBarn(g);
                    g.drawImage(toolsactivebackground, 1150, 570, null);
                    drawActiveTools(g);
                    drawTime(g);
                    if (maintime.getTime().getHours()==3) { // Kasus jika pemain terjaga hingga pukul 3 pagi
                        scenehouse=true;
                    }
                }
                
                if (scenemap) {
                    drawSceneMap(g);
                    if (a) {
                        g.drawImage(jackhead, 65, 500, null);
                    }
                    if (b) {
                        g.drawImage(jackhead, 550, 300, null);
                    }
                    if (c) {
                        g.drawImage(jackhead, 65, 100, null);
                    }
                    if (d) {
                        g.drawImage(jackhead, 65, 300, null);
                    }
                    if (d1) {
                        g.drawImage(jackhead, 250, 300, null);
                    }
                    if (f) {
                        g.drawImage(jackhead, 1100, 65, null);
                    }
                }
                
                if(sceneinvent) {
                    drawSceneInvent(g);
                    g.drawImage(toolsactivebackground, 1150, 570, null);
                    drawActiveTools(g);
                    if(issaving) {
                        saveGame(g);
                    }
                }
                if(scenehouse) {
                    drawSceneHouse(g);
                    g.drawImage(toolsactivebackground, 1150, 570, null);
                    drawActiveTools(g);
                    drawTime(g);
                }
                if(scenecoop) {
                    drawSceneCoop(g);
                    g.drawImage(toolsactivebackground, 1150, 570, null);
                    drawActiveTools(g);
                    drawTime(g);
                    if (maintime.getTime().getHours()==3) { // Kasus jika pemain terjaga hingga pukul 3 pagi
                        scenehouse=true;
                    }
                }
                if(isBuySell){
                    Font courier = new Font("Courier New", Font.BOLD, 72);
                    g.setFont(courier);
                    g.setColor(Color.DARK_GRAY);
                    drawBuySell(g);
                    drawBuySell(g);
                    drawPlayerMoving(g);
                    drawTime(g);
                    if (maintime.getTime().getHours()==3) { // Kasus jika pemain terjaga hingga pukul 3 pagi
                        scenehouse=true;
                    }
                }
                if(scenebuilding) {
                    drawSceneBuilding(g);
                    drawTime(g);
                    if (maintime.getTime().getHours()==3) { // Kasus jika pemain terjaga hingga pukul 3 pagi
                        scenehouse=true;
                    }
                }
                if(scenemainmenu) {
                    drawMainMenu(g);
                    try {
                        drawAfterMenu(g);
                    } catch (FileNotFoundException ex) {
                        g.drawString("FILE NOT FOUND!", 600, 30);
                    }
                }
                if(entername) {
                    drawEnterName(g);
                }
                if(isBuy){
                    drawBuy(g);
                }
                if(isSell){
                    drawSell(g);
                }
                if(iscredit){
                    scenemainmenu = false;
                    g.drawImage(credit, 0, 0, null);
                }
                if(isBuy) {
                        drawBuy(g);
                    }
                    if(isSell) {
                        drawSell(g);
                }
    }
}
    public void drawTime(Graphics g) {
        //draw Time
                //background time
                g.drawImage(timebackground, 950, 20, null);
                //Font,bisa diubah
                Font helvetica = new Font("Helvetica", Font.BOLD, 24);
                g.setFont(helvetica);
                g.setColor(Color.WHITE);
                g.drawString(maintime.t.getNameDays(maintime.t.getDayIndex()),1120, 70);
                g.drawString("Day " + maintime.t.getDays(), 980, 70);
                g.drawString("Month " + maintime.t.getMonths(), 980, 95);
                g.drawString("Year " + maintime.t.getYears(), 1120, 95);
                Font helveticabig = new Font("Helvetica", Font.BOLD, 40);
                g.setFont(helveticabig);
                g.drawString("" + maintime.t.getHours(), 1030, 135);
                g.drawString(" : ", 1080, 135);
                g.drawString(maintime.t.getMinutes()+"", 1140, 135);
    }    
    //METHOD
    //Method animasi gerak pemain ke utara
    public void moveNorth(){
        nm = new Animation();
        //Masukin gambar 
        Image jacknorth1 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\JackBelakang1b.png").getImage();
        Image jacknorth2 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\JackBelakang1c.png").getImage();
        //panggil method animation addscene
        nm.addScene(jacknorth1, 100);
        nm.addScene(jacknorth2, 100);
        //setnavigation north
        player.setNavigation("north");
    }
    
    //Method animasi gerak pemain ke selatan
    public void moveSouth(){
        sm = new Animation();
        //Masukin gambar 
        Image jacksouth1 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\JackDepan1b.png").getImage();
        Image jacksouth2 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\JackDepan1c.png").getImage();
        //panggil method animation addscene
        sm.addScene(jacksouth1, 100);
        sm.addScene(jacksouth2, 100);
        //setnavigation south
        player.setNavigation("south");
    }
    
    //Method animasi gerak pemain ke barat
    public void moveWest(){
        wm = new Animation();
        //Masukin gambar 
        Image jackwest1 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\JackBarat1b.png").getImage();
        Image jackwest2 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\JackBarat1c.png").getImage();
        //panggil method animation addscene
        wm.addScene(jackwest1, 100);
        wm.addScene(jackwest2, 100);
        //setnavigation west
        player.setNavigation("west");
    }
    
    //Method animasi gerak pemain ke timur
    public void moveEast(){
        em = new Animation();
        //Masukin gambar 
        Image jackeast1 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\JackTimur1b.png").getImage();
        Image jackeast2 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\JackTimur1c.png").getImage();
        //panggil method animation addscene
        em.addScene(jackeast1, 100);
        em.addScene(jackeast2, 100);
        //setnavigation east
        player.setNavigation("east");
    }
    
    //Method animasi player mencangkul dengan arah hadap utara
    public void hoeNorth(Graphics g){
        nh = new Animation();
        //add scene
        nh.addScene(hoenorth1, 100);
        nh.addScene(hoenorth2, 100);
        nh.addScene(hoenorth3, 100);
        nh.addScene(hoenorth4, 100);
        nh.addScene(hoenorth5, 100);
        nh.addScene(hoenorth6, 100);
        int x= (int)player.getLocation().getX(); 
        int y= (int)player.getLocation().getY();
        long startingTime = System.currentTimeMillis();
        long cumTime = startingTime;
        while(cumTime - startingTime<600){
            long timePassed = System.currentTimeMillis() - cumTime;
            cumTime += timePassed;
            nh.update(timePassed);
            g.drawImage(nh.getImage(), x, y, null);
            try{
                Thread.sleep(20);
            }catch(Exception ex){}  
        }
        
    }
    
    //Method animasi player mencangkul dengan arah hadap selatan
    public void hoeSouth(Graphics g){
        sh = new Animation();
        //add scene
        sh.addScene(hoesouth1, 100);
        sh.addScene(hoesouth2, 100);
        sh.addScene(hoesouth3, 100);
        sh.addScene(hoesouth4, 100);
        sh.addScene(hoesouth5, 100);
        sh.addScene(hoesouth6, 100);
        int x= (int)player.getLocation().getX(); 
        int y= (int)player.getLocation().getY();
        long startingTime = System.currentTimeMillis();
        long cumTime = startingTime;
        while(cumTime - startingTime<600){
            long timePassed = System.currentTimeMillis() - cumTime;
            cumTime += timePassed;
            sh.update(timePassed);
            g.drawImage(sh.getImage(), x, y, null);
            try{
                Thread.sleep(20);
            }catch(Exception ex){}
        }
    }
    
    //Method animasi player mencangkul dengan arah hadap utara
    public void hoeWest(Graphics g){
        wh = new Animation();
        //add scene
        wh.addScene(hoewest1, 100);
        wh.addScene(hoewest2, 100);
        wh.addScene(hoewest3, 100);
        wh.addScene(hoewest4, 100);
        wh.addScene(hoewest5, 100);
        wh.addScene(hoewest6, 100);
        int x= (int)player.getLocation().getX(); 
        int y= (int)player.getLocation().getY();
        long startingTime = System.currentTimeMillis();
        long cumTime = startingTime;
        while(cumTime - startingTime<600){
            long timePassed = System.currentTimeMillis() - cumTime;
            cumTime += timePassed;
            wh.update(timePassed);
            g.drawImage(wh.getImage(), x, y, null);
            try{
                Thread.sleep(20);
            }catch(Exception ex){}
        }
    }
    
    //Method animasi player mencangkul dengan arah hadap utara
    public void hoeEast(Graphics g){
        eh = new Animation();
        //add scene
        eh.addScene(hoeeast1, 100);
        eh.addScene(hoeeast2, 100);
        eh.addScene(hoeeast3, 100);
        eh.addScene(hoeeast4, 100);
        eh.addScene(hoeeast5, 100);
        eh.addScene(hoeeast6, 100);
        int x= (int)player.getLocation().getX(); 
        int y= (int)player.getLocation().getY();
        long startingTime = System.currentTimeMillis();
        long cumTime = startingTime;
        while(cumTime - startingTime<600){
            long timePassed = System.currentTimeMillis() - cumTime;
            cumTime += timePassed;
            eh.update(timePassed);
            g.drawImage(eh.getImage(), x, y, null);
            try{
                Thread.sleep(20);
            }catch(Exception ex){}
        }
    }
    
    //Method animasi player menggunakan arit dengan arah hadap utara
    public void sickleNorth(Graphics g){
        ns = new Animation();
        //add scene
        ns.addScene(sicklenorth1, 250);
        ns.addScene(sicklenorth2, 250);
        int x= (int)player.getLocation().getX(); 
        int y= (int)player.getLocation().getY();
        long startingTime = System.currentTimeMillis();
        long cumTime = startingTime;
        while(cumTime - startingTime<500){
            long timePassed = System.currentTimeMillis() - cumTime;
            cumTime += timePassed;
            ns.update(timePassed);
            g.drawImage(ns.getImage(), x, y, null);
            try{
                Thread.sleep(20);
            }catch(Exception ex){}
        }
    }
    
    //Method animasi player menggunakan arit dengan arah hadap utara
    public void sickleSouth(Graphics g){
        ss = new Animation();
        //add scene
        ss.addScene(sicklesouth1, 250);
        ss.addScene(sicklesouth2, 250);
        int x= (int)player.getLocation().getX(); 
        int y= (int)player.getLocation().getY();
        long startingTime = System.currentTimeMillis();
        long cumTime = startingTime;
        while(cumTime - startingTime<500){
            long timePassed = System.currentTimeMillis() - cumTime;
            cumTime += timePassed;
            ss.update(timePassed);
            g.drawImage(ss.getImage(), x, y, null);
            try{
                Thread.sleep(20);
            }catch(Exception ex){}
        }
    }
    
    //Method animasi player menggunakan arit dengan arah hadap utara
    public void sickleWest(Graphics g){
        ws = new Animation();
        //add scene
        ws.addScene(sicklewest1, 250);
        ws.addScene(sicklewest2, 250);
        int x= (int)player.getLocation().getX(); 
        int y= (int)player.getLocation().getY();
        long startingTime = System.currentTimeMillis();
        long cumTime = startingTime;
        while(cumTime - startingTime<500){
            long timePassed = System.currentTimeMillis() - cumTime;
            cumTime += timePassed;
            ws.update(timePassed);
            g.drawImage(ws.getImage(), x, y, null);
            try{
                Thread.sleep(20);
            }catch(Exception ex){}
        }
    }
    
    //Method animasi player menggunakan arit dengan arah hadap utara
    public void sickleEast(Graphics g){
        es = new Animation();
        //add scene
        es.addScene(sickleeast1, 250);
        es.addScene(sickleeast2, 250);
        int x= (int)player.getLocation().getX(); 
        int y= (int)player.getLocation().getY();
        long startingTime = System.currentTimeMillis();
        long cumTime = startingTime;
        while(cumTime - startingTime<500){
            long timePassed = System.currentTimeMillis() - cumTime;
            cumTime += timePassed;
            es.update(timePassed);
            g.drawImage(es.getImage(), x, y, null);
            try{
                Thread.sleep(20);
            }catch(Exception ex){}
        }
    }
    
    //Method animasi player mengisi watering can dengan arah hadap utara
    public void takeWaterEast(Graphics g){
        etw = new Animation();
        //add scene
        etw.addScene(takewatereast1, 250);
        etw.addScene(takewatereast2, 250);
        int x= (int)player.getLocation().getX(); 
        int y= (int)player.getLocation().getY();
        long startingTime = System.currentTimeMillis();
        long cumTime = startingTime;
        while(cumTime - startingTime<500){
            long timePassed = System.currentTimeMillis() - cumTime;
            cumTime += timePassed;
            etw.update(timePassed);
            g.drawImage(etw.getImage(), x, y, null);
            try{
                Thread.sleep(20);
            }catch(Exception ex){}
        }
    }
    
    //Method mengambil air dengan player menghadap south
    public void takeWaterSouth(Graphics g){
        stw = new Animation();
        //add scene
        stw.addScene(takewatersouth1, 250);
        stw.addScene(takewatersouth2, 250);
        int x= (int)player.getLocation().getX(); 
        int y= (int)player.getLocation().getY();
        long startingTime = System.currentTimeMillis();
        long cumTime = startingTime;
        while(cumTime - startingTime<500){
            long timePassed = System.currentTimeMillis() - cumTime;
            cumTime += timePassed;
            stw.update(timePassed);
            g.drawImage(stw.getImage(), x, y, null);
            try{
                Thread.sleep(20);
            }catch(Exception ex){}
        }
    }
    
    //Method animasi player menyiram dengan arah hadap utara
    public void waterNorth(Graphics g){
        nwc = new Animation();
        //add scene
        nwc.addScene(wateringcannorth1, 250);
        nwc.addScene(wateringcannorth2, 250);
        int x= (int)player.getLocation().getX(); 
        int y= (int)player.getLocation().getY();
        long startingTime = System.currentTimeMillis();
        long cumTime = startingTime;
        while(cumTime - startingTime<500){
            long timePassed = System.currentTimeMillis() - cumTime;
            cumTime += timePassed;
            nwc.update(timePassed);
            g.drawImage(nwc.getImage(), x, y, null);
            try{
                Thread.sleep(20);
            }catch(Exception ex){}
        }
    }
    
    //Method animasi player menyiram dengan arah hadap selatan
    public void waterSouth(Graphics g){
        swc = new Animation();
        //add scene
        swc.addScene(wateringcansouth1, 250);
        swc.addScene(wateringcansouth2, 250);
        int x= (int)player.getLocation().getX(); 
        int y= (int)player.getLocation().getY();
        long startingTime = System.currentTimeMillis();
        long cumTime = startingTime;
        while(cumTime - startingTime<500){
            long timePassed = System.currentTimeMillis() - cumTime;
            cumTime += timePassed;
            swc.update(timePassed);
            g.drawImage(swc.getImage(), x, y, null);
            try{
                Thread.sleep(20);
            }catch(Exception ex){}
        }
    }
    
    //Method animasi player menyiram dengan arah hadap barat
    public void waterWest(Graphics g){
        wwc = new Animation();
        //add scene
        wwc.addScene(wateringcanwest1, 250);
        wwc.addScene(wateringcanwest2, 250);
        int x= (int)player.getLocation().getX(); 
        int y= (int)player.getLocation().getY();
        long startingTime = System.currentTimeMillis();
        long cumTime = startingTime;
        while(cumTime - startingTime<500){
            long timePassed = System.currentTimeMillis() - cumTime;
            cumTime += timePassed;
            wwc.update(timePassed);
            g.drawImage(wwc.getImage(), x, y, null);
            try{
                Thread.sleep(20);
            }catch(Exception ex){}
        }
    }
    
    //Method animasi player menyiram dengan arah hadap timur
    public void waterEast(Graphics g){
        ewc = new Animation();
        //add scene
        ewc.addScene(wateringcaneast1, 250);
        ewc.addScene(wateringcaneast2, 250);
        int x= (int)player.getLocation().getX(); 
        int y= (int)player.getLocation().getY();
        long startingTime = System.currentTimeMillis();
        long cumTime = startingTime;
        while(cumTime - startingTime<500){
            long timePassed = System.currentTimeMillis() - cumTime;
            cumTime += timePassed;
            ewc.update(timePassed);
            g.drawImage(ewc.getImage(), x, y, null);
            try{
                Thread.sleep(20);
            }catch(Exception ex){}
        }
    }
    
    private String temp; //boolean untuk menyimpan scene saat membuka inventory
    //keyPressed, gerakan player
    public void keyPressed(KeyEvent e){
        String nav = player.getNavigation();
        int x= (int)player.getLocation().getX(); 
        int y= (int)player.getLocation().getY();
        int keyCode = e.getKeyCode();
        switch(keyCode) {
            case KeyEvent.VK_UP:
                y -= 10;
                if(scenebarn) {
                    if(y<80){y = 80;}
                }
		if(scenefield) {
                    if(y<5){
                        scenefield = false;
                        scenebuilding = true;
                        player.setLocation(400, 400);
			player.setNavigation("north");
                        repaint();
                        }
                }
                if(scenecoop) {
                    if(y<130){y = 130;}
                }
                if(scenehouse) {
                    if(y<80){y = 80;}
                }
                if(scenebuilding) {
                    if(y>=70 && y <260){y = 260;}
                }
		if(isBuySell) {
                    if(x>640) {
                        if(y<=50){
                            isBuySell = false;
                            scenefield = true;
                            player.setLocation(400,400);
                        }
                    }
                    if(x>880){
                        if(y<150){y = 150;}
                    }
                }
                player.setLocation((double)x, (double)y);
                e.consume();
                player.setNavigation("north");
                isMoving = true;
                break;
            case KeyEvent.VK_DOWN:
                y += 10;
                if(scenebarn) {
                    if(y>400){y = 400;}
                }
		if(scenefield) {
                    if(y>(ScreenHeight)){
			player.setLocation(660, 10);
                        scenefield = false;
			isBuySell = true;
                    }
                    if(y>375 && x>1010) {
                        y=375;
                    }
                }
                if(scenecoop) {
                    if(y>455){y = 455;}
                }
                if(scenehouse) {
                    if(y>455){y = 455;}
                }
                if(scenebuilding) {
                    if(y>690){
                        player.setLocation(550, 10);
			scenebuilding = false;
			scenefield = true;
                    }
		}
		if(isBuySell) {
                    if(y>250){y=250;}
                }
                player.setLocation((double)x, (double)y);
                e.consume();
                player.setNavigation("south");
                isMoving = true;
                break;
            case KeyEvent.VK_LEFT:
                x -= 10;
                if(scenebarn) {
                    if(x<3){x = 3;}
                }
                if(scenefield) {
                    if(x<5){x = 5;}
                }
                if(scenecoop) {
                    if(x<3){x = 3;}
                }
                if(scenehouse) {
                    if(x<3){x=3;}
                    if(x<210 && y<280) {
                        x=210;
                    }
                }
                if(scenebuilding) {
                    if(x<10){x = 10;}
		}
		if(isBuySell) {
                    if(x<600){x=600;}
		}
                e.consume();
                player.setLocation((double)x, (double)y);
                player.setNavigation("west");
                isMoving = true;
                break;
            case KeyEvent.VK_RIGHT:
                x += 10;
                if(scenebarn) { 
                    if(x>1150){x = 1150;}
		}
		if(scenefield) {
                    if(x>1150){x = 1150;}
                    if(y>375 && x>910) {
                        x=910;
                    }
                }
                if(scenecoop) {
                    if(x>1150){x = 1150;}
                }
                if(scenehouse) {
                    if(x>1150){x = 1150;}
                }
                if(scenebuilding) {
                    if(x>800){x = 800;}
		}
		if(isBuySell) {
                    if(x>880){
                        if(y<150){x = 880;}
                    }
                    if(x>1180){x=1180;}
		}
                player.setLocation((double)x, (double)y);
                e.consume();
                player.setNavigation("east");
                isMoving = true;
                break;
            case KeyEvent.VK_X:
		if(scenebarn || scenecoop || scenefield) {
		isUsingTools=true;
		}
		if(scenehouse) {
                    if(x-50<=220 && y+50<300) {
                    sleeping = true;
                    }
                }
		if(isBuySell) {
                    if(x+50>900 && x+50<1000){
                       if(y+150>350 && y+150<450){
                           isTalking=true;
                        }
                    }
                }
                e.consume();
                break;
            case KeyEvent.VK_W:
                sceneinvent = true;
            case KeyEvent.VK_Q:
                sceneinvent = false;
            case KeyEvent.VK_D:
                if(scenebarn) {
                    temp = "scenebarn";
                    scenebarn=false;
                } else if(scenecoop) {
                    temp = "scenecoop";
                    scenecoop = false;
                } else if(scenehouse) {
                    temp = "scenehouse";
                    scenehouse = false;
                } else if(isBuySell) {
                    temp = "isBuySell";
                    isBuySell = false;
                } else if (scenefield) {
                    temp = "scenefield";
                    scenefield = false;
                }
                sceneinvent = true;
                e.consume();
                break;
            case KeyEvent.VK_S:
		if(scenebarn) {
                    fodderstate = true;
		}
		if(scenecoop) {
                    chickfeed = true;
		}
                e.consume();
                break;
            case KeyEvent.VK_A :
		//Interaksi membuka pintu barn
		if(scenebarn) {
                    if((x>=340 && x<=520 && y+150>=420 && nav == "south")) {
                    scenebarn = false;
                    scenebuilding = true;
                    player.setLocation(105, 300);
                    player.setNavigation("south");
                    }
                }
		//Interaksi membuka pintu coop
		if(scenecoop) {
                    if(x>=325 && x<=435 && y+150>=460 && nav == "south") {
			scenecoop = false;
			scenebuilding = true;
			player.setLocation(670, 300);
			player.setNavigation("south");
                    }
		}
		//Interaksi membuka pintu house
		if(scenehouse) {
                    if(x>=550 && x<=720 && y+100>=430 && nav == "south") {
                    scenehouse = false;
                    scenebuilding = true;
                    player.setLocation(370, 300);
                    player.setNavigation("south");
                    }
		}
		//Interaksi masuk ke dalam building
                if(scenebuilding) {
                    if(nav == "north") {
                        if(y-50>=200 || y+50<310){
                            if (x+25>=115 && x+25<205) {
                                scenebarn = true;
                                scenebuilding = false;
                                player.setLocation(380,390);
                            } else if(x+25>=380 && x+25<450) {
                                scenehouse = true;
                                scenebuilding = false;
                                player.setLocation(420,420);
                            } else if(x+25>=677 && x+25<732) {
                                scenecoop = true;
                                scenebuilding = false;
                                player.setLocation(320,440);
                            }
                        }
                    }
		}
            case KeyEvent.VK_ENTER :
		if(entername) {
                    entername = false;
                    scenefield = true;
		}
                e.consume();
                break;
             case KeyEvent.VK_N:
                if(isBuySell) {
                    if(isTalking){
                        isNextDialog=true;
                        if(isBuy){
                            isNextDialog=true;    
                        }
                    }
                }
                e.consume();
                break;
             case KeyEvent.VK_SPACE :
                //Nonaktifkan layar inventory
		if(sceneinvent) {
                    sceneinvent = false;
                 switch(temp) {
                    case "scenebarn" :
                         scenebarn = true;
                         break;
                    case "scenecoop" :
                          scenecoop = true;
                         break;
                    case "scenehouse" :
                         scenehouse = true;
                         break;
                    case "scenefield" :
                        scenefield = true;
                        break;
                    case "isBuySell" :
                        isBuySell = true;
                        break;
                }
                }
                 e.consume();
                break;
           case KeyEvent.VK_M:
                if(scenebarn) {
                    scenemap = true;
                    scenebarn = false;
                    a = true;
                    //player.setLocation(550, 250);
		}
		if(scenefield) {
                    scenemap = true;
                    scenefield = false;
                    b = true;
                    //player.setLocation(780, 260);
                }
                if(scenecoop) {
                    scenemap = true;
                    scenecoop = false;
                    c = true;
                }
                if(scenehouse) {
                    scenemap = true;
                    scenehouse = false;
                    d = true;
                }
                if(scenebuilding) {
                    scenebuilding = false;
                    scenemap = true;
                    d1 = true;
		}
		if(scenebuysell) {
                    scenebuysell = false;
                    scenemap = true;
                    f = true;
		}
                break;
            case KeyEvent.VK_K:
                if (a) {
                    scenemap = false;
                    scenebarn = true;
                }
                if (b) {
                    scenemap = false;
                    scenefield = true;
                }
                if (c) {
                    scenemap = false;
                    scenecoop = true;
                }
                if (d) {
                    scenemap = false;
                    scenehouse = true;
                }
                if (d1) {
                    scenemap = false;
                    scenebuilding = true;
                }
                if (f) {
                    scenemap = false;
                    scenebuysell = true;
                }
                
            default:
                break;
            }
        repaint();
    }
    
    //keyReleased
    public void keyReleased(KeyEvent e){
        int keyCode = e.getKeyCode();
        isMoving = false;
        e.consume();
        repaint();
    }
    
    //mouse listener interface
    public void mousePressed(MouseEvent e){
        
    }
    public void mouseReleased(MouseEvent e){
        
    }
    public void mouseClicked(MouseEvent e){
        int x = (int)e.getX();
        int y = (int)e.getY();
        if (iscredit) {
            if (x > 0 && x <1280) {
                if (y > 0 && y < 720) {
                    iscredit = false;
                    scenemainmenu = true;
                }
            }
        }
        //main menu
        if(x>100 && x<318){
            if(y>200 && y<268){
                isnew=true;
                repaint();
            }
            if(y>275 && y<343){
                isload=true;
            }
            if(y>350 && y<418){
                iscredit=true;
            }
            if(y>425 && y<493){
                isexit=true;
            }
        }
        //for buy sell
        if(isBuySell){
            if(isTalking){
                if(indexdialog==2){
                    if(x>1100 && x<1200){
                        if(y>340 && y<390){
                            isBuy=true;
                        }
                        if(y>420 && y<470){
                            isSell=true;
                        }
                    }
                }
                if(indexdialog==5){
                    if(x>1100 && x<1200){
                        if(y>180 && y<230){
                            nameindex=0;
                            isNextDialog=true;
                            if(isbuychicken){
                                isbuychickenname=true;
                            }
                            if(isbuycow){
                                isbuycowname=true;
                            }
                            if(isbuysheep){
                                isbuysheepname=true;
                            }
                        }
                        if(y>260 && y<310){
                            nameindex=1;
                            isNextDialog=true;
                            if(isbuychicken){
                                isbuychickenname=true;
                            }
                            if(isbuycow){
                                isbuycowname=true;
                            }
                            if(isbuysheep){
                                isbuysheepname=true;
                            }
                        }
                        if(y>340 && y<390){
                            nameindex=2;
                            isNextDialog=true;
                            if(isbuychicken){
                                isbuychickenname=true;
                            }
                            if(isbuycow){
                                isbuycowname=true;
                            }
                            if(isbuysheep){
                                isbuysheepname=true;
                            }
                        }
                        if(y>420 && y<470){
                            nameindex=3;
                            isNextDialog=true;
                            if(isbuychicken){
                                isbuychickenname=true;
                            }
                            if(isbuycow){
                                isbuycowname=true;
                            }
                            if(isbuysheep){
                                isbuysheepname=true;
                            }
                        }
                    }
                }
                if(indexdialog==6){
                    if(x>1100 && x<1200){
                        if(y>180 && y<230){
                            amountindex=1;
                            isNextDialog=true;
                            if(isbuychickenfeed){
                                isbuychickenfeedamount=true;
                            }
                            if(isbuyfodder){
                                isbuyfodderamount=true;
                            }
                            if(isbuyturnipseed){
                                isbuyturnipseedamount=true;
                            }
                            if(isbuycabbageseed){
                                isbuycabbageseedamount=true;
                            }
                            if(isbuycarrotseed){
                                isbuycarrotseedamount=true;
                            }
                            if(isbuycornseed){
                                isbuycornseedamount=true;
                            }
                            if(isbuytomatoseed){
                                isbuytomatoseedamount=true;
                            }
                            if(isbuygrassseed){
                                isbuygrassseedamount=true;
                            }
                        }
                        if(y>260 && y<310){
                            amountindex=2;
                            isNextDialog=true;
                            if(isbuychickenfeed){
                                isbuychickenfeedamount=true;
                            }
                            if(isbuyfodder){
                                isbuyfodderamount=true;
                            }
                            if(isbuyturnipseed){
                                isbuyturnipseedamount=true;
                            }
                            if(isbuycabbageseed){
                                isbuycabbageseedamount=true;
                            }
                            if(isbuycarrotseed){
                                isbuycarrotseedamount=true;
                            }
                            if(isbuycornseed){
                                isbuycornseedamount=true;
                            }
                            if(isbuytomatoseed){
                                isbuytomatoseedamount=true;
                            }
                            if(isbuygrassseed){
                                isbuygrassseedamount=true;
                            }
                        }
                        if(y>340 && y<390){
                            amountindex=3;
                            isNextDialog=true;
                            if(isbuychickenfeed){
                                isbuychickenfeedamount=true;
                            }
                            if(isbuyfodder){
                                isbuyfodderamount=true;
                            }
                            if(isbuyturnipseed){
                                isbuyturnipseedamount=true;
                            }
                            if(isbuycabbageseed){
                                isbuycabbageseedamount=true;
                            }
                            if(isbuycarrotseed){
                                isbuycarrotseedamount=true;
                            }
                            if(isbuycornseed){
                                isbuycornseedamount=true;
                            }
                            if(isbuytomatoseed){
                                isbuytomatoseedamount=true;
                            }
                            if(isbuygrassseed){
                                isbuygrassseedamount=true;
                            }
                        }
                        if(y>420 && y<470){
                            amountindex=5;
                            isNextDialog=true;
                            if(isbuychickenfeed){
                                isbuychickenfeedamount=true;
                            }
                            if(isbuyfodder){
                                isbuyfodderamount=true;
                            }
                            if(isbuyturnipseed){
                                isbuyturnipseedamount=true;
                            }
                            if(isbuycabbageseed){
                                isbuycabbageseedamount=true;
                            }
                            if(isbuycarrotseed){
                                isbuycarrotseedamount=true;
                            }
                            if(isbuycornseed){
                                isbuycornseedamount=true;
                            }
                            if(isbuytomatoseed){
                                isbuytomatoseedamount=true;
                            }
                            if(isbuygrassseed){
                                isbuygrassseedamount=true;
                            }
                        }
                    }
                }
            }
        }
        if(isBuy){
            if(y>150 && y<300){
                if(x>300 && x<450){
                    isbuychicken=true;
                }
                if(x>470 && x<620){
                    isbuycow=true;
                }
                if(x>640 && x<790){
                    isbuysheep=true;
                }
            }
            if(y>310 && y<460){
                if(x>300 && x<450){
                    isbuychickenfeed=true;
                }
                if(x>470 && x<620){
                    isbuyfodder=true;
                }
            }
            if(y>470 && y<620){
                if(x>300 && x<450){
                    isbuyturnipseed=true;
                }
                if(x>460 && x<610){
                    isbuycabbageseed=true;
                }
                if(x>620 && x<770){
                    isbuycarrotseed=true;
                }
                if(x>780 && x<930){
                    isbuycornseed=true;
                }
                if(x>940 && x<1090){
                    isbuytomatoseed=true;
                }
                if(x>1100 && x<1250){
                    isbuygrassseed=true;
                }
            }
            if(x>1150 && x<1200){
                if(y>50 && y<100){
                    isBuy=false;
                    indexdialog=7;
                }
            }
        }
        if(isSell){
            if(y>150 && y<300){
                if(x>400 && x<550){
                    indexsell=0;
                    isselling=true;
                }
                if(x>570 && x<720){
                    indexsell=1;
                    isselling=true;
                }
                if(x>740 && x<890){
                    indexsell=2;
                    isselling=true;
                }
            }
            if(y>310 && y<460){
                if(x>400 && x<550){
                    indexsell=3;
                    isselling=true;
                }
                if(x>570 && x<720){
                    indexsell=4;
                    isselling=true;
                }
                if(x>740 && x<890){
                    indexsell=5;
                    isselling=true;
                }
            }
            if(y>470 && y<620){
                if(x>570 && x<720){
                    indexsell=6;
                }
            }
            if(x>1150 && x<1200){
                if(y>50 && y<100){
                    isSell=false;
                    indexdialog=7;
                }
            }
        }
        if(sceneinvent) {
            if(x>=955 && x<=1100) {
                if(y>=530 && y<=600) {
                    hoveron=true;
                }
            }
            if(x>=30 && x<=110) {
                if(y>=100 && y<=215) {
                    player.setActive(0);
                }
                if(y>=240 && y<=320) {
                    player.setActive(3);
                }
                if(y>=350 && y<=430) {
                    player.setActive(5);
                }
                if(y>=460 && y<=540) {
                    player.setActive(8);
                }
            }
            if(x >=150 && x <=240) {
                if(y>=100 && y<=215) {
                    player.setActive(1);
                }
                if(y>=240 && y<=320) {
                    player.setActive(4);
                }
                if(y>=350 && y<=430) {
                    player.setActive(7);
                }
                if(y>=460 && y<=540) {
                    player.setActive(10);
                }
            }
            if(x>=280 && x<=370) {
                if(y>=100 && y<=215) {
                    player.setActive(2);
                }
                if(y>=240 && y<=320) {
                    player.setActive(5);
                }
                if(y>=350 && y<=430) {
                    player.setActive(8);
                }
                if(y>=460 && y<=540) {
                    player.setActive(11);
                }
            }
            //Save Game
            if(x>=955 && x<=1120) {
                if(y>=530 && y <=600) {issaving=true;}
            }
        }
        if(entername) {
            if (x>= 50 && x<=120) {
                if (y>=380 && x<= 450) {
                    isA = true;
                }
            }
            if (x>=20 && x<=80) {
                if (y>=460 && y<=530) {
                    isB = true;
                }
                if (y>=550 && y<=620) {
                    isD = true;
                }
                if (y>=640 && y<=700) {
                    isF = true;
                }
            }
            if (x>=100 && x<=160) {
                if  (y>=460 && y<=530) {
                    isC = true;
                }
                if  (y>=550 && y<= 620) {
                    isE = true;
                }
                if (y>640 && y<=700) {
                    isG = true;
                }
            }
            if (y>=640 && x<=700) {
                if  (x>=180 && x<=240) {
                    isH = true;
                }
                if  (x>=260 && x<=310) {
                    isI = true;
                }
                if  (x>=340 && x<=390) {
                    isJ = true;
                }
                if  (x>=410 && x<=470) {
                    isK = true;
                }
                if  (x>=490 && x<=550) {
                    isL = true;
                }
                if  (x>=570 && x<=630) {
                    isM = true;
                }
                if  (x>=660 && x<=710) {
                    isN = true;
                }
                if  (x>=730 && x<=790) {
                    isO = true;
                }
                if  (x>=810 && x<=870) {
                    isP = true;
                }
                if  (x>=890 && x<=960) {
                    isQ = true;
                }
                if  (x>=970 && x<=1030) {
                    isR = true;
                }
                if  (x>=1040 && x<=1100) {
                    isS = true;
                }
            }
        }
    }
    
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
        
    //mouse motion interface
    public void mouseDragged(MouseEvent e){
        
    }
    public void mouseMoved(MouseEvent e){
        int x = (int)e.getX();
        int y = (int)e.getY();
        if(scenemainmenu) {
        if(x>100 && x<318){
            if(y>200 && y<268){
                onbuttonnew=true;
                repaint();
            }
            if(y>275 && y<343){
                onbuttonload=true;
            }
            if(y>350 && y<418){
                onbuttoncredit=true;
            }
            if(y>425 && y<493){
                onbuttonexit=true;
            }
        }
        }
        if(isBuy){
            if(y>150 && y<300){
                if(x>300 && x<450){
                    onbuychicken=true;
                }
                if(x>470 && x<620){
                    onbuycow=true;
                }
                if(x>640 && x<790){
                    onbuysheep=true;
                }
            }
            if(y>310 && y<460){
                if(x>300 && x<450){
                    onbuychickenfeed=true;
                }
                if(x>470 && x<620){
                    onbuyfodder=true;
                }
            }
            if(y>470 && y<620){
                if(x>300 && x<450){
                    onbuyturnipseed=true;
                }
                if(x>460 && x<610){
                    onbuycabbageseed=true;
                }
                if(x>620 && x<770){
                    onbuycarrotseed=true;
                }
                if(x>780 && x<930){
                    onbuycornseed=true;
                }
                if(x>940 && x<1090){
                    onbuytomatoseed=true;
                }
                if(x>1100 && x<1250){
                    onbuygrassseed=true;
                }
            }
        }
        if(isSell){
            if(y>150 && y<300){
                if(x>400 && x<550){
                    onsellitems0=true;
                    indexhover=0;
                }
                if(x>570 && x<720){
                    onsellitems1=true;
                    indexhover=1;
                }
                if(x>740 && x<890){
                    onsellitems2=true;
                    indexhover=2;
                }
            }
            if(y>310 && y<460){
                if(x>400 && x<550){
                    onsellitems3=true;
                    indexhover=3;
                }
                if(x>570 && x<720){
                    onsellitems4=true;
                    indexhover=4;
                }
                if(x>740 && x<890){
                    onsellitems5=true;
                    indexhover=5;
                }
            }
            if(y>470 && y<620){
                if(x>570 && x<720){
                    onsellitems6=true;
                    indexhover=6;
                }
            }
        }
        if(sceneinvent) {
            if(x>=30 && x<=110) {
                if(y>=100 && y<=215) {
                    ischoosen0=true;
                }
                if(y>=240 && y<=320) {
                    ischoosen3 = true;
                }
                if(y>=350 && y<=430) {
                    ischoosen6 = true;
                }
                if(y>=460 && y<=540) {
                    ischoosen9 = true;
                }
            }
            if(x >=150 && x <=240) {
                if(y>=100 && y<=215) {
                    ischoosen1=true;
                }
                if(y>=240 && y<=320) {
                    ischoosen4 = true;
                }
                if(y>=350 && y<=430) {
                    ischoosen7 = true;
                }
                if(y>=460 && y<=540) {
                    ischoosen10 = true;
                }
            }
            if(x>=280 && x<=370) {
                if(y>=100 && y<=215) {
                    ischoosen2=true;
                }
                if(y>=240 && y<=320) {
                    ischoosen5 = true;
                }
                if(y>=350 && y<=430) {
                    ischoosen8 = true;
                }
                if(y>=460 && y<=540) {
                    ischoosen11 = true;
                }
            }
            if(x>=955 && x<=1120) {
                if(y>=530 && y <=600) {
                    hoveron=true;
                }
            }
        }
    }
    
    public void keyTyped(KeyEvent e){
        e.consume();
    }
    
    private String iname;
    //draw active tools
    public void drawActiveTools(Graphics g){
        //hoe
        if(player.checkInventState(0)){
            g.drawImage(hoe, 1150, 570, null);
        }
        //sickle
        if(player.checkInventState(1)){
            g.drawImage(sickle, 1150, 570, null);
        }
        //watering can
        if(player.checkInventState(2)){
            g.drawImage(wateringcan, 1150, 570, null);
        }
        //Milker
        if(player.checkInventState(3)) {
            g.drawImage(milker, 1170, 585, null);
        }
        //Clipper
        if(player.checkInventState(4)) {
            g.drawImage(clipper, 1170, 585, null);
        }
        for(int i=5;i<=player.getnAI();i++) {
            if(player.getInvent(i) != null && player.getInvent(i).getState()==true) {
                iname = player.getInvent(i).getName();
                switch(iname) {
                case "Fodder" : {
                                g.drawImage(fodder, 1150, 570, null);
                                break;
                             }
                case "Turnip" : {
                                g.drawImage(turnip, 1150, 570, null);
                                break;
                             }
                case "Cabbage" :  {
                                g.drawImage(cabbage, 1150, 570, null);
                                break;
                             }
                case "Carrot" :  {
                                g.drawImage(carrot, 1150, 570, null);
                                break;
                             }
                case "Corn" :  {
                                g.drawImage(corn, 1150, 570, null);
                                break;
                             }
                case "Tomato" :  {
                                g.drawImage(tomato, 1150, 570, null);
                                break;
                             }
                case "Turnip seed" : {
                                g.drawImage(turnipseed, 1150, 570, null);
                                break;
                             }
                case "Tomato seed" : {
                                g.drawImage(tomatoseed, 1150, 570, null);
                                break;
                             }
                case "Cabbage seed" : {
                                g.drawImage(cabbageseed, 1150, 570, null);
                                break;
                             }
                case "Corn seed" : {
                                g.drawImage(cornseed, 1150, 570, null);
                                break;
                             }
                case "Grass seed" : {
                                g.drawImage(grassseed, 1150, 570, null);
                                break;
                             }
                case "Milk" : {
                                g.drawImage(milk, 1150, 570, null);
                                break;
                             }
                case "Wool" : {
                                g.drawImage(wool, 1150, 570, null);
                                break;
                             }
                case "Egg" : {
                                g.drawImage(egg, 1150, 570, null);
                                break;
                             }
                default :
                            break;
                }
            }
        }  
    }
    //draw player using tools
    public void drawPlayerTools(Graphics g){
        String nav = player.getNavigation();
        int x= (int)player.getLocation().getX(); 
        int y= (int)player.getLocation().getY();
        if(isUsingTools){
            if(player.checkInventState(2) && x+120>1015 && y>375 && y<720 && nav=="east"){
                takeWaterEast(g);
                wateringcanIndex = 10;
                isUsingTools = false;
            }
            if(player.checkInventState(2) && x+120>1015 && y+50<375 && y<635 && nav=="south"){
                takeWaterSouth(g);
                wateringcanIndex = 10;
                isUsingTools = false;
            }
             for(int ix=0;ix<=99;ix++){
                if(nav=="north"){
                    if(y+50>field.getPoint(ix).getY() && y+50<field.getPoint(ix).getY()+50){
                        if(x+50>field.getPoint(ix).getX() && x+50<field.getPoint(ix).getX()+50){
                            if(player.checkInventState(0) && field.getArrayOfPlots(ix)==false){
                                hoeNorth(g);
                                field.setArrayOfPlots(ix, true);
                                isUsingTools = false;
                            }
                            if(player.checkInventState(1)&& field.getArrayOfPlots(ix) && field.getArrayOfCrops(ix)!=null){
                                sickleNorth(g);
                                field.setArrayOfCrops(ix, null);
				field.setArrayOfPlots(ix, false);
                                field.setnAF(field.getnAF()-1); //Setiap kali mengambil tanaman mati nilai efektif array berkurang satu
                                isUsingTools = false;
                            }
                            if(player.checkInventState(2)){
                                if(wateringcanIndex>0 && field.getArrayOfCrops(ix)!=null){
                                    waterNorth(g);
                                    field.getArrayOfCrops(ix).setState(true);
                                    wateringcanIndex--;
                                    isUsingTools = false;
                                }
                            }
                            for(int inv=5;inv<=11;inv++){
                                if(player.getInvent(inv)!=null && field.getArrayOfPlots(ix) && field.getArrayOfCrops(ix)==null){
                                    if(player.checkInventState(inv) && ((Items) player.getInvent(inv)).getAmount()>0){
                                        if (player.getInvent(inv).getName()=="Turnip seed") {
                                            field.setArrayOfCrops(ix, (new Turnip(field.getPoint(ix))));
                                            player.minusAmount(inv, 1); //Setiap kali tanam benih berkurang 1 
                                            field.setnAF(field.getnAF()+1); //Setiap kali menanam nilai efektif array bertambah satu
                                            isUsingTools = false;                                                                         
                                        }
                                        if (player.getInvent(inv).getName()=="Cabbage seed") {
                                            field.setArrayOfCrops(ix, (new Cabbage(field.getPoint(ix))));
                                            player.minusAmount(inv, 1); //Setiap kali tanam benih berkurang 1 
                                            field.setnAF(field.getnAF()+1); //Setiap kali menanam nilai efektif array bertambah satu
                                            isUsingTools = false;                                                                         
                                        }
                                        if (player.getInvent(inv).getName()=="Carrot seed") {
                                            field.setArrayOfCrops(ix, (new Carrot(field.getPoint(ix))));
                                            player.minusAmount(inv, 1); //Setiap kali tanam benih berkurang 1 
                                            field.setnAF(field.getnAF()+1); //Setiap kali menanam nilai efektif array bertambah satu
                                            isUsingTools = false;                                                                         
                                        }
                                        if (player.getInvent(inv).getName()=="Corn seed") {
                                            field.setArrayOfCrops(ix, (new Corn(field.getPoint(ix))));
                                            player.minusAmount(inv, 1); //Setiap kali tanam benih berkurang 1 
                                            field.setnAF(field.getnAF()+1); //Setiap kali menanam nilai efektif array bertambah satu
                                            isUsingTools = false;                                                                         
                                        }
                                        if (player.getInvent(inv).getName()=="Tomato seed") {
                                            field.setArrayOfCrops(ix, (new Tomato(field.getPoint(ix))));
                                            player.minusAmount(inv, 1); //Setiap kali tanam benih berkurang 1 
                                            field.setnAF(field.getnAF()+1); //Setiap kali menanam nilai efektif array bertambah satu
                                            isUsingTools = false;                                                                         
                                        }
                                        if (player.getInvent(inv).getName()=="Grass seed") {
                                            field.setArrayOfCrops(ix, (new Grass(field.getPoint(ix))));
                                            player.minusAmount(inv, 1); //Setiap kali tanam benih berkurang 1 
                                            field.setnAF(field.getnAF()+1); //Setiap kali menanam nilai efektif array bertambah satu
                                            isUsingTools = false;                                                                         
                                        }
                                    }
                                }
                            }
                            if(field.getArrayOfCrops(ix)!=null && field.getArrayOfCrops(ix).getPhase()=="harvest" && !player.checkInventState(1)){
                                for(int in=5;in<=11;in++){
                                    if(field.getArrayOfCrops(ix) instanceof Turnip){
                                        if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Turnip"){
                                            Items c = ((Turnip) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.plusAmount(in, c.getAmount());
                                            c = null;
                                            isUsingTools = false;
                                        } else if(player.getInvent(in)==null){
                                            Items c = ((Turnip) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.setInventory(in, c);
                                            player.setnAI((player.getnAI()+1));
                                            isUsingTools = false;
                                        } else {
                                            isUsingTools = false;
                                        }
                                    }
                                    if(field.getArrayOfCrops(ix) instanceof Cabbage){
                                        if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Cabbage"){
                                            Items c = ((Cabbage) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.plusAmount(in, c.getAmount());
                                            c = null;
                                            isUsingTools = false;
                                        } else if(player.getInvent(in)==null){
                                            Items c = ((Cabbage) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.setInvent(in, c);
                                            isUsingTools = false;
                                        } else {
                                            isUsingTools = false;
                                        }
                                    }
                                    if(field.getArrayOfCrops(ix) instanceof Carrot){
                                        if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Carrot"){
                                            Items c = ((Carrot) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.plusAmount(in, c.getAmount());
                                            c = null;
                                            isUsingTools = false;
                                        } else if(player.getInvent(in)==null){
                                            Items c = ((Carrot) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.setInvent(in, c);
                                            isUsingTools = false;
                                        } else {
                                            isUsingTools = false;
                                        }
                                    }
                                    if(field.getArrayOfCrops(ix) instanceof Tomato){
                                        if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Tomato"){
                                            Items c = ((Tomato) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.plusAmount(in, c.getAmount());
                                            c = null;
                                            isUsingTools = false;
                                        } else if(player.getInvent(in)==null){
                                            Items c = ((Tomato) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.setInvent(in, c);
                                            isUsingTools = false;
                                        } else {
                                            isUsingTools = false;
                                        }
                                    }
                                    if(field.getArrayOfCrops(ix) instanceof Grass){
                                        if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Fodder"){
                                            Items c = ((Grass) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.plusAmount(in, c.getAmount());
                                            c = null;
                                            isUsingTools = false;
                                        } else if(player.getInvent(in)==null){
                                            Items c = ((Grass) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.setInvent(in, c);
                                            isUsingTools = false;
                                        } else {
                                            isUsingTools = false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if(nav=="south"){
                    if(y+100>field.getPoint(ix).getY() && y+100<field.getPoint(ix).getY()+50){
                        if(x+50>field.getPoint(ix).getX() && x+50<field.getPoint(ix).getX()+50){
                            if(player.checkInventState(0)&& field.getArrayOfPlots(ix)==false){
                                hoeSouth(g);
                                field.setArrayOfPlots(ix, true);
                                isUsingTools = false;
                            }
                            if(player.checkInventState(1)&& field.getArrayOfPlots(ix) && field.getArrayOfCrops(ix)!=null){
                                sickleSouth(g);
                                field.setArrayOfCrops(ix, null);
				field.setArrayOfPlots(ix, false);
                                field.setnAF(field.getnAF()-1); //Setiap kali mengambil tanaman mati nilai efektif array berkurang satu
                                isUsingTools = false;
                            }
                            if(player.checkInventState(2)){
                                if(wateringcanIndex>0 && field.getArrayOfCrops(ix)!=null){
                                    waterSouth(g);
                                    field.getArrayOfCrops(ix).setState(true);
                                    wateringcanIndex--;
                                    isUsingTools = false;
                                }
                            }
                            for(int inv=5;inv<=11;inv++){
                                if(player.getInvent(inv)!=null && field.getArrayOfPlots(ix)  && field.getArrayOfCrops(ix)==null){
                                    if(player.checkInventState(inv) && ((Items) player.getInvent(inv)).getAmount()>0){
                                        if (player.getInvent(inv).getName()=="Turnip seed") {
                                            field.setArrayOfCrops(ix, (new Turnip(field.getPoint(ix))));
                                            player.minusAmount(inv, 1); //Setiap kali tanam benih berkurang 1 
                                            field.setnAF(field.getnAF()+1); //Setiap kali menanam nilai efektif array bertambah satu
                                            isUsingTools = false;                                                                         
                                        }
                                        if (player.getInvent(inv).getName()=="Cabbage seed") {
                                            field.setArrayOfCrops(ix, (new Cabbage(field.getPoint(ix))));
                                            player.minusAmount(inv, 1); //Setiap kali tanam benih berkurang 1 
                                            field.setnAF(field.getnAF()+1); //Setiap kali menanam nilai efektif array bertambah satu
                                            isUsingTools = false;                                                                         
                                        }
                                        if (player.getInvent(inv).getName()=="Carrot seed") {
                                            field.setArrayOfCrops(ix, (new Carrot(field.getPoint(ix))));
                                            player.minusAmount(inv, 1); //Setiap kali tanam benih berkurang 1 
                                            field.setnAF(field.getnAF()+1); //Setiap kali menanam nilai efektif array bertambah satu
                                            isUsingTools = false;                                                                         
                                        }
                                        if (player.getInvent(inv).getName()=="Corn seed") {
                                            field.setArrayOfCrops(ix, (new Corn(field.getPoint(ix))));
                                            player.minusAmount(inv, 1); //Setiap kali tanam benih berkurang 1 
                                            field.setnAF(field.getnAF()+1); //Setiap kali menanam nilai efektif array bertambah satu
                                            isUsingTools = false;                                                                         
                                        }
                                        if (player.getInvent(inv).getName()=="Tomato seed") {
                                            field.setArrayOfCrops(ix, (new Tomato(field.getPoint(ix))));
                                            player.minusAmount(inv, 1); //Setiap kali tanam benih berkurang 1 
                                            field.setnAF(field.getnAF()+1); //Setiap kali menanam nilai efektif array bertambah satu
                                            isUsingTools = false;                                                                         
                                        }
                                        if (player.getInvent(inv).getName()=="Grass seed") {
                                            field.setArrayOfCrops(ix, (new Grass(field.getPoint(ix))));
                                            player.minusAmount(inv, 1); //Setiap kali tanam benih berkurang 1 
                                            field.setnAF(field.getnAF()+1); //Setiap kali menanam nilai efektif array bertambah satu
                                            isUsingTools = false;                                                                         
                                        }
                                    }
                                }
                            }
                            if(field.getArrayOfCrops(ix)!=null && field.getArrayOfCrops(ix).getPhase()=="harvest" && !player.checkInventState(1)){
                                for(int in=5;in<=11;in++){
                                    if(field.getArrayOfCrops(ix) instanceof Turnip){
                                        if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Turnip"){
                                            Items c = ((Turnip) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.plusAmount(in, c.getAmount());
                                            c = null;
                                            isUsingTools = false;
                                        } else if(player.getInvent(in)==null){
                                            Items c = ((Turnip) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.setInvent(in, c);
                                            isUsingTools = false;
                                        } else {
                                            isUsingTools = false;
                                        }
                                    }
                                    if(field.getArrayOfCrops(ix) instanceof Cabbage){
                                        if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Cabbage"){
                                            Items c = ((Cabbage) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.plusAmount(in, c.getAmount());
                                            c = null;
                                            isUsingTools = false;
                                        } else if(player.getInvent(in)==null){
                                            Items c = ((Cabbage) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.setInvent(in, c);
                                            isUsingTools = false;
                                        } else {
                                            isUsingTools = false;
                                        }
                                    }
                                    if(field.getArrayOfCrops(ix) instanceof Carrot){
                                        if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Carrot"){
                                            Items c = ((Carrot) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.plusAmount(in, c.getAmount());
                                            c = null;
                                            isUsingTools = false;
                                        } else if(player.getInvent(in)==null){
                                            Items c = ((Carrot) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.setInvent(in, c);
                                            isUsingTools = false;
                                        } else {
                                            isUsingTools = false;
                                        }
                                    }
                                    if(field.getArrayOfCrops(ix) instanceof Tomato){
                                        if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Tomato"){
                                            Items c = ((Tomato) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.plusAmount(in, c.getAmount());
                                            c = null;
                                            isUsingTools = false;
                                        } else if(player.getInvent(in)==null){
                                            Items c = ((Tomato) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.setInvent(in, c);
                                            isUsingTools = false;
                                        } else {
                                            isUsingTools = false;
                                        }
                                    }
                                    if(field.getArrayOfCrops(ix) instanceof Grass){
                                        if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Fodder"){
                                            Items c = ((Grass) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.plusAmount(in, c.getAmount());
                                            c = null;
                                            isUsingTools = false;
                                        } else if(player.getInvent(in)==null){
                                            Items c = ((Grass) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.setInvent(in, c);
                                            isUsingTools = false;
                                        } else {
                                            isUsingTools = false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if(nav=="west"){
                    if(y+75>field.getPoint(ix).getY() && y+75<field.getPoint(ix).getY()+50){
                        if(x-20>field.getPoint(ix).getX() && x-20<field.getPoint(ix).getX()+50){
                            if(player.checkInventState(0)&& field.getArrayOfPlots(ix)==false){
                                hoeWest(g);
                                field.setArrayOfPlots(ix, true);
                                isUsingTools = false;
                            }
                            if(player.checkInventState(1)&& field.getArrayOfPlots(ix) && field.getArrayOfCrops(ix)!=null){
                                sickleWest(g);
                                field.setArrayOfCrops(ix, null);
				field.setArrayOfPlots(ix, false);
                                field.setnAF(field.getnAF()-1); //Setiap kali mengambil tanaman mati nilai efektif array berkurang satu
                                isUsingTools = false;
                            }
                            if(player.checkInventState(2)){
                                if(wateringcanIndex>0 && field.getArrayOfCrops(ix)!=null){
                                    waterWest(g);
                                    field.getArrayOfCrops(ix).setState(true);
                                    wateringcanIndex--;
                                    isUsingTools = false;
                                }
                            }
                            for(int inv=5;inv<=11;inv++){
                                if(player.getInvent(inv)!=null && field.getArrayOfPlots(ix) && field.getArrayOfCrops(ix)==null){
                                    if(player.checkInventState(inv) && ((Items) player.getInvent(inv)).getAmount()>0){
                                        if (player.getInvent(inv).getName()=="Turnip seed") {
                                            field.setArrayOfCrops(ix, (new Turnip(field.getPoint(ix))));
                                            player.minusAmount(inv, 1); //Setiap kali tanam benih berkurang 1 
                                            field.setnAF(field.getnAF()+1); //Setiap kali menanam nilai efektif array bertambah satu
                                            isUsingTools = false;                                                                         
                                        }
                                        if (player.getInvent(inv).getName()=="Cabbage seed") {
                                            field.setArrayOfCrops(ix, (new Cabbage(field.getPoint(ix))));
                                            player.minusAmount(inv, 1); //Setiap kali tanam benih berkurang 1 
                                            field.setnAF(field.getnAF()+1); //Setiap kali menanam nilai efektif array bertambah satu
                                            isUsingTools = false;                                                                         
                                        }
                                        if (player.getInvent(inv).getName()=="Carrot seed") {
                                            field.setArrayOfCrops(ix, (new Carrot(field.getPoint(ix))));
                                            player.minusAmount(inv, 1); //Setiap kali tanam benih berkurang 1 
                                            field.setnAF(field.getnAF()+1); //Setiap kali menanam nilai efektif array bertambah satu
                                            isUsingTools = false;                                                                         
                                        }
                                        if (player.getInvent(inv).getName()=="Corn seed") {
                                            field.setArrayOfCrops(ix, (new Corn(field.getPoint(ix))));
                                            player.minusAmount(inv, 1); //Setiap kali tanam benih berkurang 1 
                                            field.setnAF(field.getnAF()+1); //Setiap kali menanam nilai efektif array bertambah satu
                                            isUsingTools = false;                                                                         
                                        }
                                        if (player.getInvent(inv).getName()=="Tomato seed") {
                                            field.setArrayOfCrops(ix, (new Tomato(field.getPoint(ix))));
                                            player.minusAmount(inv, 1); //Setiap kali tanam benih berkurang 1 
                                            field.setnAF(field.getnAF()+1); //Setiap kali menanam nilai efektif array bertambah satu
                                            isUsingTools = false;                                                                         
                                        }
                                        if (player.getInvent(inv).getName()=="Grass seed") {
                                            field.setArrayOfCrops(ix, (new Grass(field.getPoint(ix))));
                                            player.minusAmount(inv, 1); //Setiap kali tanam benih berkurang 1 
                                            field.setnAF(field.getnAF()+1); //Setiap kali menanam nilai efektif array bertambah satu
                                            isUsingTools = false;                                                                         
                                        }
                                    }
                                }
                            }
                            if(field.getArrayOfCrops(ix)!=null && field.getArrayOfCrops(ix).getPhase()=="harvest" && !player.checkInventState(1)){
                                for(int in=5;in<=11;in++){
                                    if(field.getArrayOfCrops(ix) instanceof Turnip){
                                        if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Turnip"){
                                            Items c = ((Turnip) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.plusAmount(in, c.getAmount());
                                            c = null;
                                            isUsingTools = false;
                                        } else if(player.getInvent(in)==null){
                                            Items c = ((Turnip) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.setInvent(in, c);
                                            isUsingTools = false;
                                        } else {
                                            isUsingTools = false;
                                        }
                                    }
                                    if(field.getArrayOfCrops(ix) instanceof Cabbage){
                                        if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Cabbage"){
                                            Items c = ((Cabbage) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.plusAmount(in, c.getAmount());
                                            c = null;
                                            isUsingTools = false;
                                        } else if(player.getInvent(in)==null){
                                            Items c = ((Cabbage) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.setInvent(in, c);
                                            isUsingTools = false;
                                        } else {
                                            isUsingTools = false;
                                        }
                                    }
                                    if(field.getArrayOfCrops(ix) instanceof Carrot){
                                        if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Carrot"){
                                            Items c = ((Carrot) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.plusAmount(in, c.getAmount());
                                            c = null;
                                            isUsingTools = false;
                                        } else if(player.getInvent(in)==null){
                                            Items c = ((Carrot) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.setInvent(in, c);
                                            isUsingTools = false;
                                        } else {
                                            isUsingTools = false;
                                        }
                                    }
                                    if(field.getArrayOfCrops(ix) instanceof Tomato){
                                        if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Tomato"){
                                            Items c = ((Tomato) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.plusAmount(in, c.getAmount());
                                            c = null;
                                            isUsingTools = false;
                                        } else if(player.getInvent(in)==null){
                                            Items c = ((Tomato) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.setInvent(in, c);
                                            isUsingTools = false;
                                        } else {
                                            isUsingTools = false;
                                        }
                                    }
                                    if(field.getArrayOfCrops(ix) instanceof Grass){
                                        if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Fodder"){
                                            Items c = ((Grass) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.plusAmount(in, c.getAmount());
                                            c = null;
                                            isUsingTools = false;
                                        } else if(player.getInvent(in)==null){
                                            Items c = ((Grass) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.setInvent(in, c);
                                            isUsingTools = false;
                                        } else {
                                            isUsingTools = false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if(nav=="east"){
                    if(y+75>field.getPoint(ix).getY() && y+75<field.getPoint(ix).getY()+50){
                        if(x+100>field.getPoint(ix).getX() && x+100<field.getPoint(ix).getX()+50){
                            if(player.checkInventState(0)&& field.getArrayOfPlots(ix)==false){
                                hoeEast(g);
                                field.setArrayOfPlots(ix, true);
                                isUsingTools = false;
                            }
                            if(player.checkInventState(1)&& field.getArrayOfPlots(ix) && field.getArrayOfCrops(ix)!=null){
                                sickleEast(g);
                                field.setArrayOfCrops(ix, null);
				field.setArrayOfPlots(ix, false);
                                field.setnAF(field.getnAF()-1); //Setiap kali mengambil tanaman mati nilai efektif array berkurang satu
                                isUsingTools = false;
                            }
                            if(player.checkInventState(2)){
                                if(wateringcanIndex>0 && field.getArrayOfCrops(ix)!=null){
                                    waterEast(g);
                                    field.getArrayOfCrops(ix).setState(true);
                                    wateringcanIndex--;
                                    isUsingTools = false;
                                }
                            }
                            for(int inv=5;inv<=11;inv++){
                                if(player.getInvent(inv)!=null && field.getArrayOfPlots(ix) && field.getArrayOfCrops(ix)==null){
                                    if(player.checkInventState(inv) && ((Items) player.getInvent(inv)).getAmount()>0){
                                        if (player.getInvent(inv).getName()=="Turnip seed") {
                                            field.setArrayOfCrops(ix, (new Turnip(field.getPoint(ix))));
                                            player.minusAmount(inv, 1); //Setiap kali tanam benih berkurang 1 
                                            field.setnAF(field.getnAF()+1); //Setiap kali menanam nilai efektif array bertambah satu
                                            isUsingTools = false;                                                                         
                                        }
                                        if (player.getInvent(inv).getName()=="Cabbage seed") {
                                            field.setArrayOfCrops(ix, (new Cabbage(field.getPoint(ix))));
                                            player.minusAmount(inv, 1); //Setiap kali tanam benih berkurang 1 
                                            field.setnAF(field.getnAF()+1); //Setiap kali menanam nilai efektif array bertambah satu
                                            isUsingTools = false;                                                                         
                                        }
                                        if (player.getInvent(inv).getName()=="Carrot seed") {
                                            field.setArrayOfCrops(ix, (new Carrot(field.getPoint(ix))));
                                            player.minusAmount(inv, 1); //Setiap kali tanam benih berkurang 1 
                                            field.setnAF(field.getnAF()+1); //Setiap kali menanam nilai efektif array bertambah satu
                                            isUsingTools = false;                                                                         
                                        }
                                        if (player.getInvent(inv).getName()=="Corn seed") {
                                            field.setArrayOfCrops(ix, (new Corn(field.getPoint(ix))));
                                            player.minusAmount(inv, 1); //Setiap kali tanam benih berkurang 1 
                                            field.setnAF(field.getnAF()+1); //Setiap kali menanam nilai efektif array bertambah satu
                                            isUsingTools = false;                                                                         
                                        }
                                        if (player.getInvent(inv).getName()=="Tomato seed") {
                                            field.setArrayOfCrops(ix, (new Tomato(field.getPoint(ix))));
                                            player.minusAmount(inv, 1); //Setiap kali tanam benih berkurang 1 
                                            field.setnAF(field.getnAF()+1); //Setiap kali menanam nilai efektif array bertambah satu
                                            isUsingTools = false;                                                                         
                                        }
                                        if (player.getInvent(inv).getName()=="Grass seed") {
                                            field.setArrayOfCrops(ix, (new Grass(field.getPoint(ix))));
                                            player.minusAmount(inv, 1); //Setiap kali tanam benih berkurang 1 
                                            field.setnAF(field.getnAF()+1); //Setiap kali menanam nilai efektif array bertambah satu
                                            isUsingTools = false;                                                                         
                                        }
                                    }
                                }
                            }
                            if(field.getArrayOfCrops(ix)!=null && field.getArrayOfCrops(ix).getPhase()=="harvest" && !player.checkInventState(1)){
                                for(int in=5;in<=11;in++){
                                    if(field.getArrayOfCrops(ix) instanceof Turnip){
                                        if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Turnip"){
                                            Items c = ((Turnip) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.plusAmount(in, c.getAmount());
                                            c = null;
                                            isUsingTools = false;
                                        } else if(player.getInvent(in)==null){
                                            Items c = ((Turnip) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.setInvent(in, c);
                                            isUsingTools = false;
                                        } else {
                                            isUsingTools = false;
                                        }
                                    }
                                    if(field.getArrayOfCrops(ix) instanceof Cabbage){
                                        if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Cabbage"){
                                            Items c = ((Cabbage) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.plusAmount(in, c.getAmount());
                                            c = null;
                                            isUsingTools = false;
                                        } else if(player.getInvent(in)==null){
                                            Items c = ((Cabbage) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.setInvent(in, c);
                                            isUsingTools = false;
                                        } else {
                                            isUsingTools = false;
                                        }
                                    }
                                    if(field.getArrayOfCrops(ix) instanceof Carrot){
                                        if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Carrot"){
                                            Items c = ((Carrot) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.plusAmount(in, c.getAmount());
                                            c = null;
                                            isUsingTools = false;
                                        } else if(player.getInvent(in)==null){
                                            Items c = ((Carrot) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.setInvent(in, c);
                                            isUsingTools = false;
                                        } else {
                                            isUsingTools = false;
                                        }
                                    }
                                    if(field.getArrayOfCrops(ix) instanceof Tomato){
                                        if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Tomato"){
                                            Items c = ((Tomato) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.plusAmount(in, c.getAmount());
                                            c = null;
                                            isUsingTools = false;
                                        } else if(player.getInvent(in)==null){
                                            Items c = ((Tomato) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.setInvent(in, c);
                                            isUsingTools = false;
                                        } else {
                                            isUsingTools = false;
                                        }
                                    }
                                    if(field.getArrayOfCrops(ix) instanceof Grass){
                                        if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Fodder"){
                                            Items c = ((Grass) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.plusAmount(in, c.getAmount());
                                            c = null;
                                            isUsingTools = false;
                                        } else if(player.getInvent(in)==null){
                                            Items c = ((Grass) field.getArrayOfCrops(ix)).harvestCrops();
                                            player.setInvent(in, c);
                                            isUsingTools = false;
                                        } else {
                                            isUsingTools = false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
   
    //draw
    public void drawPlayerMoving(Graphics g){
        String nav= player.getNavigation();
        int x= (int)player.getLocation().getX(); 
        int y= (int)player.getLocation().getY();
        if(isMoving){
            if(null != nav)switch (nav) {
                case "north":
                    moveNorth();
                    g.drawImage(nm.getImage(), x, y, null);
                    break;
                case "south":
                    moveSouth();
                    g.drawImage(sm.getImage(), x, y, null);
                    break;
                case "west":
                    moveWest();
                    g.drawImage(wm.getImage(), x, y, null);
                    break;
                case "east":
                    moveEast();
                    g.drawImage(em.getImage(), x, y, null);
                    break;
                default:
                    break;
            }
        }else{
            if(null != nav)switch (nav) {
                case "north":
                    g.drawImage(playerIconNorth, x, y, null);
                    break;
                case "south":
                    g.drawImage(playerIconSouth, x, y, null);
                    break;
                case "west":
                    g.drawImage(playerIconWest, x, y, null);
                    break;
                case "east":
                    g.drawImage(playerIconEast, x, y, null);
                    break;
                default:
                    break;
            }
        }
    }
    
    //draw
       public void drawPlot(Graphics g, int i){
            if(field.getArrayOfPlots(i)== true){
                int x = (int)field.getPoint(i).getX();
                int y = (int)field.getPoint(i).getY();
                g.drawImage(plot, x, y, null);
                if(field.getArrayOfCrops(i) != null){
                    if(field.getArrayOfCrops(i).getState() == true){
                        g.drawImage(plotwatered, x, y, null);
                    }
                    if(field.getArrayOfCrops(i) instanceof Turnip){
                        String phase = field.getArrayOfCrops(i).getPhase();
                        if(phase=="seed"){
                            g.drawImage(plotseed, x, y, null);
                        }
                        if(phase=="mature"){
                            g.drawImage(turnipmature, x, y, null);
                        }
                        if(phase=="harvest"){
                            g.drawImage(turnipharvest, x, y, null);
                        }
                        if(phase=="withered"){
                            g.drawImage(turnipwithered, x, y, null);
                        }
                    }
                    if(field.getArrayOfCrops(i) instanceof Corn){
                        String phase = field.getArrayOfCrops(i).getPhase();
                        if(phase=="seed"){
                            g.drawImage(plotseed, x, y, null);
                        }
                        if(phase=="mature"){
                            g.drawImage(cornmature, x, y, null);
                        }
                        if(phase=="harvest"){
                            g.drawImage(cornharvest, x, y, null);
                        }
                        if(phase=="withered"){
                            g.drawImage(cornwithered, x, y, null);
                        }
                    }
                    if(field.getArrayOfCrops(i) instanceof Cabbage){
                        String phase = field.getArrayOfCrops(i).getPhase();
                        if(phase=="seed"){
                            g.drawImage(plotseed, x, y, null);
                        }
                        if(phase=="mature"){
                            g.drawImage(cabbagemature, x, y, null);
                        }
                        if(phase=="harvest"){
                            g.drawImage(cabbageharvest, x, y, null);
                        }
                        if(phase=="withered"){
                            g.drawImage(cabbagewithered, x, y, null);
                        }
                    }
                    if(field.getArrayOfCrops(i) instanceof Carrot){
                        String phase = field.getArrayOfCrops(i).getPhase();
                        if(phase=="seed"){
                            g.drawImage(plotseed, x, y, null);
                        }
                        if(phase=="mature"){
                            g.drawImage(carrotmature, x, y, null);
                        }
                        if(phase=="harvest"){
                            g.drawImage(carrotharvest, x, y, null);
                        }
                        if(phase=="withered"){
                            g.drawImage(carrotwithered, x, y, null);
                        }
                    }
                    if(field.getArrayOfCrops(i) instanceof Tomato){
                        String phase = field.getArrayOfCrops(i).getPhase();
                        if(phase=="seed"){
                            g.drawImage(plotseed, x, y, null);
                        }
                        if(phase=="mature"){
                            g.drawImage(tomatomature, x, y, null);
                        }
                        if(phase=="harvest"){
                            g.drawImage(tomatoharvest, x, y, null);
                        }
                        if(phase=="withered"){
                            g.drawImage(tomatowithered, x, y, null);
                        }
                    }
                    if(field.getArrayOfCrops(i) instanceof Grass){
                        String phase = field.getArrayOfCrops(i).getPhase();
                        if(phase=="seed"){
                            g.drawImage(plotseed, x, y, null);
                        }
                        if(phase=="mature"){
                            g.drawImage(grassharvest, x, y, null);
                        }
                        if(phase=="harvest"){
                            g.drawImage(grassharvest, x, y, null);
                        }
                        if(phase=="withered"){
                            g.drawImage(grasswithered, x, y, null);
                        }
                    }
                }
            }
    }
       
    public void drawLivestock(Graphics g){
        for(int i =0;i<=barn.getnAL();i++) {    
        if(barn.getLivestock(i)!= null){
            int x = (int)barn.getPoint(i).getX();
            int y = (int)barn.getPoint(i).getY();
            if(barn.getLivestock(i) instanceof Cow) {
                g.drawImage(cow, x, y, null);
                if((x == 40 && y == 250) || (x == 720 && y == 250)){
                    g.drawImage(cowb, x, y, null);
                } 
            }
            if(barn.getLivestock(i) instanceof Sheep) {
                g.drawImage(sheep, x, y, null);
                if((x == 40 && y == 250) || (x == 720 && y == 250)){
                    g.drawImage(cow, x, y, null);
                } 
            }
        }
    }
    }
    
    //Animasi player memegang milker
    public void milkerWest(Graphics g){
        wmk = new Animation();
        //add scene
        wmk.addScene(milkerwest, 10000);
        int x= (int)player.getLocation().getX(); 
        int y= (int)player.getLocation().getY();
        long startingTime = System.currentTimeMillis();
        long cumTime = startingTime;
        while(cumTime - startingTime<2000){
            long timePassed = System.currentTimeMillis() - cumTime;
            cumTime += timePassed;
            wmk.update(timePassed);
            g.drawImage(wmk.getImage(), x, y, null);
            try{
                Thread.sleep(20);
            }catch(Exception ex){}
        }
    }
    
    public void milkerEast(Graphics g){
        emk = new Animation();
        //add scene
        emk.addScene(milkereast, 1000);
        int x= (int)player.getLocation().getX(); 
        int y= (int)player.getLocation().getY();
        long startingTime = System.currentTimeMillis();
        long cumTime = startingTime;
        while(cumTime - startingTime<2000){
            long timePassed = System.currentTimeMillis() - cumTime;
            cumTime += timePassed;
            emk.update(timePassed);
            g.drawImage(emk.getImage(), x, y, null);
            try{
                Thread.sleep(20);
            }catch(Exception ex){}
        }
    }
    
    public void clipperWest(Graphics g){
        wcl = new Animation();
        //add scene
        wcl.addScene(clipperwest, 1000);
        int x= (int)player.getLocation().getX(); 
        int y= (int)player.getLocation().getY();
        long startingTime = System.currentTimeMillis();
        long cumTime = startingTime;
        while(cumTime - startingTime<2000){
            long timePassed = System.currentTimeMillis() - cumTime;
            cumTime += timePassed;
            wcl.update(timePassed);
            g.drawImage(wcl.getImage(), x, y, null);
            try{
                Thread.sleep(20);
            }catch(Exception ex){}
        }
    }
    
    public void clipperEast(Graphics g){
        ecl = new Animation();
        //add scene
        ecl.addScene(clippereast, 1000);
        int x= (int)player.getLocation().getX(); 
        int y= (int)player.getLocation().getY();
        long startingTime = System.currentTimeMillis();
        long cumTime = startingTime;
        while(cumTime - startingTime<2000){
            long timePassed = System.currentTimeMillis() - cumTime;
            cumTime += timePassed;
            ecl.update(timePassed);
            g.drawImage(ecl.getImage(), x, y, null);
            try{
                Thread.sleep(20);
            }catch(Exception ex){}
        }
    }
    
    //Method untuk player mengambil produk hewan
    public void drawGetProduct(Graphics g) {
        String nav= player.getNavigation();
        int x = (int)player.getLocation().getX(); 
        int y = (int)player.getLocation().getY();
        if(isUsingTools){
          if(scenebarn) {
             for(int ix=0;ix<=player.getnAI();ix++){
                if(nav=="west"){
                    if(y+75>barn.getPoint(ix).getY() && y+75<barn.getPoint(ix).getY()+50){
                        if(x-20>barn.getPoint(ix).getX() && x-20<barn.getPoint(ix).getX()+50){
                            if(player.checkInventState(3)&& barn.getLivestock(ix) != null && barn.getLivestock(ix).getReady()==true){
                                milkerWest(g);
                                barn.getLivestock(ix).changeReady(false);
                                for(int in=5;in<=player.getnAI();in++){
                                    if(barn.getLivestock(ix) instanceof Cow){
                                        if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Milk"){
                                            Items c = barn.getLivestock(ix).getProduct();
                                            player.plusAmount(in, c.getAmount());
                                            c = null;
                                            isUsingTools = false;
                                        } else if(player.getInvent(in)==null){
                                            Items c = barn.getLivestock(ix).getProduct();
                                            player.setInvent(in, c);
                                            isUsingTools = false;
                                        } else {
                                            isUsingTools = false;
                                        }
                                    }
                                }
                                isUsingTools = false;
                            }
                            if(player.checkInventState(4)&& barn.getLivestock(ix) != null && barn.getLivestock(ix).getReady()==true){
                                clipperWest(g);
                                barn.getLivestock(ix).changeReady(false);
                                for(int in=5;in<=11;in++){
                                    if(barn.getLivestock(ix) instanceof Sheep){
                                        if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Wool"){
                                            Items c = barn.getLivestock(ix).getProduct();
                                            player.plusAmount(in, c.getAmount());
                                            c = null;
                                            isUsingTools = false;
                                        } else if(player.getInvent(in)==null){
                                            Items c = barn.getLivestock(ix).getProduct();
                                            player.setInvent(in, c);
                                            isUsingTools = false;
                                        } else {
                                            isUsingTools = false;
                                        }
                                    }
                                }
                                isUsingTools = false;
                            }
                        }
                    }
                }
                if (nav == "east") {
                    if(y+75>field.getPoint(ix).getY() && y+75<field.getPoint(ix).getY()+50){
                        if(x+100>field.getPoint(ix).getX() && x+100<field.getPoint(ix).getX()+50){
                            if(player.checkInventState(3)&& barn.getLivestock(ix) != null && barn.getLivestock(ix).getReady()==true){
                                milkerEast(g);
                                barn.getLivestock(ix).changeReady(false);
                                for(int in=5;in<=11;in++){
                                    if(barn.getLivestock(ix) instanceof Cow){
                                        if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Milk"){
                                            Items c = barn.getLivestock(ix).getProduct();
                                            player.plusAmount(in, c.getAmount());
                                            c = null;
                                            isUsingTools = false;
                                        } else if(player.getInvent(in)==null){
                                            Items c = barn.getLivestock(ix).getProduct();
                                            player.setInvent(in, c);
                                            isUsingTools = false;
                                        } else {
                                            isUsingTools = false;
                                        }
                                    }
                                }
                                isUsingTools = false;
                            }
                            if(player.checkInventState(4)&& barn.getLivestock(ix) != null && barn.getLivestock(ix).getReady()==true){
                                clipperEast(g);
                                barn.getLivestock(ix).changeReady(false);
                                for(int in=5;in<=11;in++){
                                    if(barn.getLivestock(ix) instanceof Sheep){
                                        if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Wool"){
                                            Items c = barn.getLivestock(ix).getProduct();
                                            player.plusAmount(in, c.getAmount());
                                            c = null;
                                            isUsingTools = false;
                                        } else if(player.getInvent(in)==null){
                                            Items c = barn.getLivestock(ix).getProduct();
                                            player.setInvent(in, c);
                                            isUsingTools = false;
                                        } else {
                                            isUsingTools = false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
             }
          }
          if(scenecoop) {
              
          }
       }
    }
    
    public void drawFodder(Graphics g) {
        String nav = player.getNavigation();
        int x = (int)player.getLocation().getX();
        int y = (int)player.getLocation().getY();
        if(fodderstate) {
            for(int ix=0;ix<=11;ix++){
                if(nav=="north"){
                    if(y-25>=240 && y-25<=345){
                        if(x+50>210 && x-50<600){
                            for(int in=5;in<=player.getnAI();in++){
                                if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Fodder"){
                                    if(((Items)player.getInvent(in)).getAmount() >= barn.getnAL()) {
                                        for (int a = 0;a<=barn.getnAL();a++) {
                                        g.drawImage(fodderimg, (int)barn.getArrayFeeder(a).getX(), (int)barn.getArrayFeeder(a).getY(), null);
                                        fodderstate = false;
                                        }
                                        player.minusAmount(in, barn.getnAL());
                                        for(int ff=0;ff<=barn.getnAL();ff++){
                                            barn.getLivestock(ff).setState("alive");  
                                        }
                                        g.drawString("Livestock has eaten.",100,100);
                                    }
                                }
                            }
                        }
                    }
                }
                if(nav == "south") {
                    if(y+150>240 && y+150<345){
                        if(x+50>210 && x+50<600){
                            for(int in=5;in<=player.getnAI();in++){
                                if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Fodder"){
                                    if(((Items)player.getInvent(in)).getAmount() >= barn.getnAL()) {
                                        for (int a = 0;a<=barn.getnAL();a++) {
                                        g.drawImage(fodderimg, (int)barn.getArrayFeeder(a).getX(), (int)barn.getArrayFeeder(a).getY(), null);
                                        fodderstate = false;
                                        }
                                        player.minusAmount(in, barn.getnAL());
                                        for(int ff=0;ff<=barn.getnAL();ff++){
                                            barn.getLivestock(ff).setState("alive");
                                        }
                                        g.drawString("Livestock has eaten.",100,100);
                                    }
                                }
                            }
                        }
                    }
                }
                if(nav == "west") {
                    if(y+50>240 && y+50<345){
                        if(x+50>210 && x+50<600){
                            for(int in=5;in<=player.getnAI();in++){
                                if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Fodder"){
                                    if(((Items)player.getInvent(in)).getAmount() >= barn.getnAL()) {
                                        for (int a = 0;a<=barn.getnAL();a++) {
                                        g.drawImage(fodderimg, (int)barn.getArrayFeeder(a).getX(), (int)barn.getArrayFeeder(a).getY(), null);
                                        fodderstate = false;
                                        }
                                        player.minusAmount(in, barn.getnAL());
                                        for(int ff=0;ff<=barn.getnAL();ff++){
                                            barn.getLivestock(ff).setState("alive");
                                        }
                                        g.drawString("Livestock has eaten.",100,100);
                                    }
                                }
                            }
                        }
                    }
                }
                if(nav == "west") {
                    if(y+50>240 && y+50<345){
                        if(x-50>210 && x-50<600){
                            for(int in=5;in<=player.getnAI();in++){
                                if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Fodder"){
                                    if(((Items)player.getInvent(in)).getAmount() >= barn.getnAL()) {
                                        for (int a = 0;a<=barn.getnAL();a++) {
                                        g.drawImage(fodderimg, (int)barn.getArrayFeeder(a).getX(), (int)barn.getArrayFeeder(a).getY(), null);
                                        fodderstate = false;
                                        }
                                        player.minusAmount(in, barn.getnAL());
                                        for(int ff=0;ff<=barn.getnAL();ff++){
                                            barn.getLivestock(ff).setState("alive");
                                        }
                                        g.drawString("Livestock has eaten.",100,100);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    //Method untuk Scene Coop
    public void drawChicken(Graphics g){
        for(int i =0;i<=coop.getnAC();i++) {    
        if(coop.getChicken(i)!= null){
            int x = (int)coop.getPoint(i).getX();
            int y = (int)coop.getPoint(i).getY();
            g.drawImage(chicken, x, y, null);
        }
        }
    }
    
    //Method memberi makan ayam
    public void drawChickenFeed(Graphics g) {
        String nav = player.getNavigation();
        int x = (int)player.getLocation().getX();
        int y = (int)player.getLocation().getY();
        if(chickfeed) {
            for(int ix=0;ix<=11;ix++){
                if(nav=="north"){
                    if(y-25>=240 && y-25<=345){
                        if(x+50>210 && x-50<600){
                            for(int in=5;in<=player.getnAI();in++){
                                if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Chicken Feed"){
                                    if(((Items)player.getInvent(in)).getAmount() >= coop.getnAC()) {
                                        for (int a = 0;a<=coop.getnAC();a++) {
                                        g.drawImage(chickfeedimg, (int)coop.getArrayFeeder(a).getX(), (int)coop.getArrayFeeder(a).getY(), null);
                                        chickfeed = false;
                                        }
                                        player.minusAmount(in, coop.getnAC());
                                        for(int ff=0;ff<=coop.getnAC();ff++){
                                            coop.getChicken(ff).setState("alive");
                                        }
                                        g.drawString("Chicken has eaten.",400,300);
                                    }
                                }
                            }
                        }
                    }
                }
                if(nav == "south") {
                    if(y+150>240 && y+150<345){
                        if(x+50>210 && x+50<600){
                            for(int in=5;in<=player.getnAI();in++){
                                if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Chicken Feed"){
                                    if(((Items)player.getInvent(in)).getAmount() >= coop.getnAC()) {
                                        for (int a = 0;a<=coop.getnAC();a++) {
                                        g.drawImage(chickfeedimg, (int)coop.getArrayFeeder(a).getX(), (int)coop.getArrayFeeder(a).getY(), null);
                                        chickfeed = false;
                                        }
                                        player.minusAmount(in, coop.getnAC());
                                        for(int ff=0;ff<=coop.getnAC();ff++){
                                            coop.getChicken(ff).setState("alive");
                                        }
                                        g.drawString("Chicken has eaten.",400,300);
                                    }
                                }
                            }
                        }
                    }
                }
                if(nav == "west") {
                    if(y+50>240 && y+50<345){
                        if(x+50>210 && x+50<600){
                            for(int in=5;in<=player.getnAI();in++){
                                if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Chicken Feed"){
                                    if(((Items)player.getInvent(in)).getAmount() >= coop.getnAC()) {
                                        for (int a = 0;a<=coop.getnAC();a++) {
                                        g.drawImage(chickfeedimg, (int)coop.getArrayFeeder(a).getX(), (int)coop.getArrayFeeder(a).getY(), null);
                                        chickfeed = false;
                                        }
                                        player.minusAmount(in, coop.getnAC());
                                        for(int ff=0;ff<=coop.getnAC();ff++){
                                            coop.getChicken(ff).setState("alive");
                                        }
                                        g.drawString("Chicken has eaten.",400,300);
                                    }
                                }
                            }
                        }
                    }
                }
                if(nav == "west") {
                    if(y+50>240 && y+50<345){
                        if(x-50>210 && x-50<600){
                            for(int in=5;in<=player.getnAI();in++){
                                if(player.getInvent(in)!=null && player.getInvent(in).getName()=="Chicken Feed"){
                                    if(((Items)player.getInvent(in)).getAmount() >= coop.getnAC()) {
                                        for (int a = 0;a<=coop.getnAC();a++) {
                                        g.drawImage(chickfeedimg, (int)coop.getArrayFeeder(a).getX(), (int)coop.getArrayFeeder(a).getY(), null);
                                        chickfeed = false;
                                        }
                                        player.minusAmount(in, coop.getnAC());
                                        for(int ff=0;ff<=coop.getnAC();ff++){
                                            coop.getChicken(ff).setState("alive");
                                        }
                                        g.drawString("Chicken has eaten.",400,300);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    //Hover untuk set active inventory
    private Image inventhover = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\invent_square.png").getImage();
    private Image savehover = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\inventsave.png").getImage();
    private boolean ischoosen0;
    private boolean ischoosen1;
    private boolean ischoosen2;
    private boolean ischoosen3;
    private boolean ischoosen4;
    private boolean ischoosen5;
    private boolean ischoosen6;
    private boolean ischoosen7;
    private boolean ischoosen8;
    private boolean ischoosen9;
    private boolean ischoosen10;
    private boolean ischoosen11;
    private boolean hoveron; 
    
//Method untuk scene inventory
    public void drawInvent(Graphics g) {
        for(int i=0;i<=player.getnAI();i++) {
            String in = player.getInvent(i).getName();
            switch(in){
                case "Hoe" : {
                                g.drawImage(hoe, (int)player.getPoint(i).getX(), (int)player.getPoint(i).getY(), null);
                                break;
                             }
                case "Sickle" : {
                                g.drawImage(sickle, (int)player.getPoint(i).getX(), (int)player.getPoint(i).getY(), null);
                                break;
                                }
                case "Watering Can" : {
                                g.drawImage(wateringcan, (int)player.getPoint(i).getX(), (int)player.getPoint(i).getY(), null);
                                break;
                             }
                case "Milker" : {
                                g.drawImage(milker, (int)player.getPoint(i).getX(), (int)player.getPoint(i).getY(), null);
                                break;
                             }
                case "Clipper" : {
                                g.drawImage(clipper, (int)player.getPoint(i).getX(), (int)player.getPoint(i).getY(), null);
                                break;
                             }
                case "Fodder" : {
                                g.drawImage(fodder, (int)player.getPoint(i).getX(), (int)player.getPoint(i).getY(), null);
                                break;
                             }
                case "Turnip" : {
                                g.drawImage(turnip, (int)player.getPoint(i).getX(), (int)player.getPoint(i).getY(), null);
                                break;
                             }
                case "Cabbage" :  {
                                g.drawImage(cabbage, (int)player.getPoint(i).getX(), (int)player.getPoint(i).getY(), null);
                                break;
                             }
                case "Carrot" :  {
                                g.drawImage(carrot, (int)player.getPoint(i).getX(), (int)player.getPoint(i).getY(), null);
                                break;
                             }
                case "Corn" :  {
                                g.drawImage(corn, (int)player.getPoint(i).getX(), (int)player.getPoint(i).getY(), null);
                                break;
                             }
                case "Tomato" :  {
                                g.drawImage(tomato, (int)player.getPoint(i).getX(), (int)player.getPoint(i).getY(), null);
                                break;
                             }
                case "Turnip seed" : {
                                g.drawImage(turnipseed, (int)player.getPoint(i).getX(), (int)player.getPoint(i).getY(), null);
                                break;
                             }
                case "Tomato seed" : {
                                g.drawImage(tomatoseed, (int)player.getPoint(i).getX(), (int)player.getPoint(i).getY(), null);
                                break;
                             }
                case "Cabbage seed" : {
                                g.drawImage(cabbageseed, (int)player.getPoint(i).getX(), (int)player.getPoint(i).getY(), null);
                                break;
                             }
                case "Corn seed" : {
                                g.drawImage(cornseed, (int)player.getPoint(i).getX(), (int)player.getPoint(i).getY(), null);
                                break;
                             }
                case "Carrot Seed" : {
                                g.drawImage(cornseed, (int)player.getPoint(i).getX(), (int)player.getPoint(i).getY(), null);
                                      break;
                               }
                case "Grass seed" : {
                                g.drawImage(grassseed, (int)player.getPoint(i).getX(), (int)player.getPoint(i).getY(), null);
                                break;
                             }
                case "Milk" : {
                                g.drawImage(milk, (int)player.getPoint(i).getX(), (int)player.getPoint(i).getY(), null);
                                break;
                             }
                case "Wool" : {
                                g.drawImage(wool, (int)player.getPoint(i).getX(), (int)player.getPoint(i).getY(), null);
                                break;
                             }
                case "Egg" : {
                                g.drawImage(egg, (int)player.getPoint(i).getX(), (int)player.getPoint(i).getY(), null);
                                break;
                             }
                default :
                            break;
            }         
        }
        Font courier = new Font("Courier New", Font.BOLD, 20);
        g.setColor(Color.BLACK);
        g.setFont(courier);
        if(ischoosen0) {
            g.drawImage(inventhover, 25,125, null);
            printInventDetails(g,0);
            ischoosen0 = false;
        }
        if(ischoosen1) {
            g.drawImage(inventhover, 145,125, null);
            printInventDetails(g,1);
            ischoosen1= false;
        }
        if(ischoosen2) {
            g.drawImage(inventhover, 275,125, null);
            printInventDetails(g,2);
            ischoosen2= false;
        }
        if(ischoosen3) {
            g.drawImage(inventhover, 25,230, null);
            printInventDetails(g,3);
            ischoosen3= false;
        }
        if(ischoosen4) {
            g.drawImage(inventhover, 145,230, null);
            printInventDetails(g,4);
            ischoosen4= false;
        }
        if(ischoosen5) {
            g.drawImage(inventhover, 275,230, null);
            printInventDetails(g,5);
            ischoosen5= false;
        }
        if(ischoosen6) {
            g.drawImage(inventhover, 25,340, null);
            printInventDetails(g,6);
            ischoosen6= false;
        }
        if(ischoosen7) {
            g.drawImage(inventhover, 145,340, null);
            printInventDetails(g,7);
            ischoosen7= false;
        }
        if(ischoosen8) {
            g.drawImage(inventhover, 275,340, null);
            printInventDetails(g,8);
            ischoosen8= false;
        }
        if(ischoosen9) {
            g.drawImage(inventhover, 20,450, null);
            printInventDetails(g,9);
            ischoosen9= false;
        }
        if(ischoosen10) {
            g.drawImage(inventhover, 145,450, null);
            printInventDetails(g,10);
            ischoosen10= false;
        }
        if(ischoosen11) {
            g.drawImage(inventhover, 275,450, null);
            printInventDetails(g,11);
            ischoosen11= false;
        }    
        if(hoveron) {
            g.drawImage(savehover, 950, 525, null);
            hoveron = false;
        }
    }
    
    public void printInventDetails(Graphics g, int i) {
        if(player.getInvent(i) != null) {
            g.drawString(player.getInvent(i).getName(), 30, 580);
            boolean cek = player.getInvent(i).getState();
            if(cek == true) {
                g.drawString("Active", 30, 620);
            } else {
                g.drawString("Not Active", 30, 620);
            }
            if(player.getInvent(i) instanceof Items) {
                g.drawString("Amount : " + ((Items)player.getInvent(i)).getAmount(),30,650);
            }
        }
    }
    public void drawState(Graphics g) {
        int x = 420;
        int y = 130;
        g.setColor(Color.DARK_GRAY);
        for(int i =0;i<=barn.getnAL();i++) {
            if(barn.getLivestock(i) != null) {
            g.drawRoundRect(x, y, 170, 50, 5, 5);
            Font myFont = new Font ("OCR A Std", 1, 20);
            g.setFont(myFont);
            if(barn.getLivestock(i) instanceof Cow) {
                g.drawImage(cowic, x+100, y-20, null);
            } else if(barn.getLivestock(i) instanceof Sheep) {
                g.drawImage(sheepic, x+100, y-20, null);
            }
            g.drawString(barn.getLivestock(i).getName(), x+10, y+20);
            y+=20;
            String s = barn.getLivestock(i).getState();
            g.drawString(s, x+10, y+20);
            
            //g.setFont(tanya there);
            //g.drawImage(cowicon, 565, 150 , null);
            
            y += 40;
            }
        }
        x = 620;
        y = 130;
        for(int i =0;i<=coop.getnAC();i++) {
            if(coop.getChicken(i) != null) {
            g.drawRoundRect(x, y, 170, 50, 5, 5);
            Font myFont = new Font ("OCR A Std", 1, 20);
            g.setFont(myFont);
            g.drawImage(chickenic, x+100, y-20, null);
            g.drawString(coop.getChicken(i).getName(), x+10, y+20);
            y+=20;
            String s = coop.getChicken(i).getState();
            g.drawString(s, x+10, y+20);
            y += 40;
            }
        }
        //Status player
        Font f = new Font ("OCR A Std", 1, 30);
        g.setFont(f);
        g.drawString(player.getName(),930,300);
        g.drawImage(gold, 930, 325,null);
        g.drawString(String.valueOf(player.getGold()), 960, 350);
        String loc = String.valueOf(player.getLocation().getX()) + "," + String.valueOf(player.getLocation().getY()); 
        g.drawString(loc, 930, 400);
        g.drawImage(playerIconSouth, 990, 160, null);
    }
    
    //Method untuk dalam rumah
    public void Sleep(Graphics g) {
        if(sleeping) {
            sl = new Animation();
            //Masukin gambar 
            //Jack Sleeping & Wake up
            Image sleepbub1 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\JackSleep1.png").getImage();
            Image sleepbub2 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\JackSleep2.png").getImage();
            Image sleepbub3 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\JackSleep3.png").getImage();
            Image sleepbub4 = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\JackSleep4.png").getImage();
            Image jacksleep = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\JackBangun1a").getImage();
            Image jackwakeup = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\JackJackBangun1b.png").getImage();
            //panggil method animation addscene
            sl.addScene(sleepbub1, 100);
            sl.addScene(sleepbub2, 100);
            sl.addScene(sleepbub3, 100);
            sl.addScene(sleepbub4, 100);
            sl.addScene(jacksleep, 100);
            sl.addScene(jackwakeup, 100);
            long startingTime = System.currentTimeMillis();
            long cumTime = startingTime;
            while(cumTime - startingTime<500){
                long timePassed = System.currentTimeMillis() - cumTime;
                cumTime += timePassed;
                sl.update(timePassed);
                g.drawImage(sl.getImage(), 50, 120, null);
                try{
                    Thread.sleep(20);
                }catch(Exception ex){}
            }
            maintime.newDays=true;
            saveGame(g);
            for(int isave=0;isave<=99;isave++) {
		if( field.getArrayOfCrops(isave) != null) {
		field.getArrayOfCrops(isave).countDays(maintime.getTime());
		field.getArrayOfCrops(isave).changePhase();
		field.getArrayOfCrops(isave).changeState(false);
		}
            }
            for(int isa=0;isa<=coop.getnAC();isa++) {
		if(coop.getChicken(isa) != null) {
		coop.getChicken(isa).countDays(maintime.getTime());
		coop.getChicken(isa).condition();
		if(coop.getChicken(isa).getState()=="dead") {
                    coop.setDead(isa);
		}
		}
            }
            for(int isl=0;isl<=barn.getnAL();isl++) { 
                if(barn.getLivestock(isl) != null) {
		barn.getLivestock(isl).countDays(maintime.getTime());
		barn.getLivestock(isl).condition();
		if(barn.getLivestock(isl).getState()=="dead") {
                    barn.setDead(isl);
                }
            }			}
            maintime.getTime().setNewDay(false);
            sleeping = false;
        }
    }
    
    //draw Main Menu
    private Image backgroundmainmenu = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Background1.png").getImage();
    private Image buttoncredit = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\button_credit.png").getImage();
    private Image buttoncredithover = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\button_credit-hover.png").getImage();
    private Image buttonnew = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\button_new.png").getImage();
    private Image buttonnewhover = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\button_new-hover.png").getImage();
    private Image buttonload = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\button_load.png").getImage();
    private Image buttonloadhover = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\button_load-hover.png").getImage();
    private Image buttonexit = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\button_exit.png").getImage();
    private Image buttonexithover = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\button_exit-hover.png").getImage();
    //Boolean button
    private boolean onbuttonnew;
    private boolean onbuttonload;
    private boolean onbuttoncredit;
    private boolean onbuttonexit;
    
    private boolean isnew;
    private boolean isload;
    private boolean iscredit;
    private boolean isexit;
    
    public void drawMainMenu(Graphics g){
        g.drawImage(backgroundmainmenu, 0, 0, null);
        g.drawImage(buttonnew, 100, 200, null);
        g.drawImage(buttonload, 100, 275, null);
        g.drawImage(buttoncredit,100,350, null);
        g.drawImage(buttonexit,100, 425, null);
        if(onbuttonnew){
            g.drawImage(buttonnewhover, 100, 200, null);
            onbuttonnew=false;
        }
        if(onbuttonload){
            g.drawImage(buttonloadhover, 100, 275, null);
            onbuttonload=false;
        }
        if(onbuttoncredit){
            g.drawImage(buttoncredithover, 100, 350, null);
            onbuttoncredit=false;
        }
        if(onbuttonexit){
            g.drawImage(buttonexithover, 100, 425, null);
            onbuttonexit=false;
        }
    }
    boolean isloaddone; //Bernilai benar jika file selesai di load
    public void loadGame(Graphics g) throws FileNotFoundException {
        Scanner read = new Scanner(new FileReader("savedGame.txt"));
        Font courier = new Font("Courier New", Font.BOLD, 24);
        g.setColor(Color.BLACK);
        g.setFont(courier);
        try {
            while(read.hasNext()) {
            //Load player
            String namap = read.nextLine();
            long go = Long.parseLong(read.nextLine());
            double x = Double.parseDouble(read.nextLine());
            double y = Double.parseDouble(read.nextLine());
            String navp = read.nextLine();
            player = new Player(namap, go, navp);                        
            player.setLocation(x,y);
            g.drawString("Load player success", 600,20);

            //Load data inventory
            player.setnAI(Integer.parseInt(read.nextLine()));
            for(int i=5;i<=player.getnAI();i++) {
		String nme = read.nextLine();
                cek = read.nextLine();
                if(null != cek) switch (cek) {
                    case "active":
                        player.getInvent(i).setState(true);
                        break;
                    case "not-active":
                        player.getInvent(i).setState(false);
                        break;
                }
                int amo = Integer.parseInt(read.nextLine());
                long pr = Long.parseLong(read.nextLine());
                player.setInvent(i, new Items(nme,amo,pr));
            }
            //g.drawString("Load items success", 600,20);
            
            //Load data fields
            field = new Field();
            int naf = Integer.parseInt(read.nextLine());
            field.setnAF(naf);
            for (int cr=0;cr<field.getnAF();cr++) {
		String s = read.nextLine();
		String phase = read.nextLine();
		String variety = read.nextLine();
                double xi = Double.parseDouble(read.nextLine());
                double yi = Double.parseDouble(read.nextLine());
                switch(s) {
                    case "Turnip" :
                        field.setArrayOfCrops(cr, new Turnip(new Point(x,y)));
                        break;
                    case "Tomato" :
			field.setArrayOfCrops(cr, new Tomato(new Point(x,y)));
			break;
                    case "Cabbage" :
			field.setArrayOfCrops(cr, new Cabbage(new Point(x,y)));
                	break;
                    case "Carrot" :
			field.setArrayOfCrops(cr, new Carrot(new Point(x,y)));
			break;
                    case "Corn" :
                        field.setArrayOfCrops(cr, new Corn(new Point(x,y)));
			break;
                    case "Grass" :
			field.setArrayOfCrops(cr, new Grass(new Point(x,y)));
                	break;
                }						
            }
            //g.drawString("Load field success", 600,20);

            //Load ArrayOfPlots
            for (int pl=0;pl<=99;pl++) {
                if("true".equals(read.nextLine())) {
                field.setArrayOfPlots(pl, true);
            } else {
                field.setArrayOfPlots(pl,false);
            }
                System.out.println("Load plots success");
            }
            g.drawString("Load plots success", 600,20);

            //Load array Livestock
            barn = new Barn();
            barn.setnAL(Integer.parseInt(read.nextLine()));
            for (int xx=0;xx<=barn.getnAL();xx++) {
		//barn.getLivestock(xx).getLocation().setX(Double.parseDouble(read.nextLine()));
		//barn.getLivestock(xx).getLocation().setY(Double.parseDouble(read.nextLine()));
                String kind = read.nextLine();
                String namec = read.nextLine();
                switch(kind) {
                    case "Cow" : barn.setLivestock(xx, new Cow(namec, barn.getPoint(xx)));
                                 break;
                    case "Sheep" : barn.setLivestock(xx, new Sheep(namec, barn.getPoint(xx)));
                        break;
                }
                barn.getLivestock(xx).setState(read.nextLine());
		if (null != read.nextLine()) switch (read.nextLine()) {
                    case "ready":
                        barn.getLivestock(xx).changeReady(true);
                        break;
                    case "not-ready":
                        barn.getLivestock(xx).changeReady(false);
                        break;
                }
            System.out.println("Load livestock success");//, 600,20);
            }

            //Load array Chicken
            coop = new Coop();
            coop.setnAC(Integer.parseInt(read.nextLine()));
            for (int xx=0;xx<=coop.getnAC();xx++) {
                String namechi = read.nextLine();
                coop.setChicken(xx, new Chicken(namechi, coop.getPoint(xx)));
                //coop.getChicken(xx).getLocation().setX(Double.parseDouble(read.nextLine()));
                //coop.getChicken(xx).getLocation().setY(Double.parseDouble(read.nextLine()));
                coop.getChicken(xx).setState(read.nextLine());
                //coop.getChicken(xx).setKind(read.nextLine());
                if (null != read.nextLine()) switch (read.nextLine()) {
                    case "ready":
                        coop.getChicken(xx).changeReady(true);
                        break;
                    case "not-ready":
                        coop.getChicken(xx).changeReady(false);
                        break;
                }
            System.out.println("Load chicken success");//, 600,20);
            }					

            //Load Timer
            int hours = (Integer.parseInt(read.nextLine()));
            int days = (Integer.parseInt(read.nextLine()));
            int minutes = (Integer.parseInt(read.nextLine()));
            int dayidx = Integer.parseInt(read.nextLine());
            int months = (Integer.parseInt(read.nextLine()));
            int years = (Integer.parseInt(read.nextLine()));
            Time t = new Time(hours,minutes,days,dayidx,months,years);
            maintime = new MainTime(t,player);
            System.out.println("Load time success");//, 600,20);
            isloaddone = true;
            }
        } catch (Exception e) { g.drawString("File crashed!", 600,20);}
    }
    
    public void saveGame(Graphics g) {
        if(issaving) {
        try {
	Formatter out = new Formatter(new File("savedGame.txt"));
	//Menyimpan informasi Player
	out.format(player.getName());
	out.format("%n%s%n", player.getGold());
	out.format("%.2f%n", player.location.getX());
	out.format("%.2f%n", player.location.getY());
	out.format("%s%n",player.getNavigation());
							
	//Menyimpan Items
	out.format("%d%n", (player.getnAI()));
	for (int xx=5;xx<=(player.getnAI());xx++) {
            if(player.getInvent(xx) != null) {
            out.format("%s%n",(player.getInvent(xx)).getName());
            if (player.getInvent(xx).getState() == true) {
            out.format("active%n");
            } else {
                out.format("not-active%n");
            }
            out.format("%d%n", ((Items)player.arrayInventory[xx]).getAmount());
            out.format("%d%n", ((Items)player.arrayInventory[xx]).getPrice());
            } else {
            System.out.println("Cannot save inventory data.");
            }
        }
							
	//Menyimpan array Fields
	out.format("%s%n",field.getnAF());
	if(field != null) {
	for (int cr=0;cr<=99;cr++) {
            if(field.getArrayOfCrops(cr) != null) {
                out.format("%s%n",field.getArrayOfCrops(cr).getName());
                out.format("%s%n",field.getArrayOfCrops(cr).getPhase());
                out.format("%s%n",field.getArrayOfCrops(cr).getVariety());
                out.format("%.2f%n", field.getArrayOfCrops(cr).getLocation().getX());
                out.format("%.2f%n", field.getArrayOfCrops(cr).getLocation().getY());						
                } 	
            }
	}
							
	//Simpan arrayOfPlots
	for (int pl=0;pl<=99;pl++) {
            if(field.getArrayOfPlots(pl) == true) {
                out.format("true%n");
            } else {
		out.format("false%n");
            }
	}
							
	//Menyimpan array Livestock
	out.format("%s%n", barn.getnAL());
	for (int xx=0;xx<=barn.getnAL();xx++) {
            if(barn.getLivestock(xx) != null) {
                out.format("%s%n", barn.getLivestock(xx).getKind());
		out.format("%s%n",barn.getLivestock(xx).getName());
		//out.format("%.2f%n", barn.getLivestock(xx).getLocation().getX());
		//out.format("%.2f%n", barn.getLivestock(xx).getLocation().getY());
		out.format("%s%n", barn.getLivestock(xx).getState());
		if (barn.getLivestock(xx).checkReady() == true) {
                    out.format("ready%n");
            	} else {
                    out.format("not-ready%n");
		}
            } else {
		System.out.println("Error saving Livestock");
            }
	}
							
	//Menyimpan array Chicken
	out.format("%s%n", coop.getnAC());
	for (int yy=0;yy<=coop.getnAC();yy++) {
            if(coop.getChicken(yy) != null) {
                out.format("%s%n", coop.getChicken(yy).getName());
		//out.format("%.2f%n", coop.getChicken(yy).getLocation().getX());
		//out.format("%.2f%n", coop.getChicken(yy).getLocation().getY());
		out.format("%s%n", coop.getChicken(yy).getState());
		//out.format("%s%n", coop.getChicken(yy).getKind());
		if (coop.getChicken(yy).checkReady() == true) {
                    out.format("ready%n");
		} else {
                    out.format("not-ready%n");
		}
            } else {
		System.out.println("Error saving chicken");
            }
	}
							
	//Menyimpan informasi Timer
	if(maintime != null) {
            out.format("%s%n", maintime.getTime().getHours());
            out.format("%s%n", maintime.getTime().getDays());
            out.format("%s%n", maintime.getTime().getMinutes());
            out.format("%s%n", maintime.getTime().getDayIndex());
            out.format("%s%n", maintime.getTime().getMonths());
            out.format("%s%n", maintime.getTime().getYears());
	} else {
            System.out.println("Time cannot be saved.");
	}
															
	out.close();                        // Close the file
        Font courier = new Font("Courier New", Font.BOLD, 24);
            g.setColor(Color.BLACK);
            g.setFont(courier);
            g.drawString("DONE SAVING!", 900, 630); // Print to console
	} catch (FileNotFoundException ex) {
		g.drawString("Game not saved.", 900,630);
        }
    }
    }
    
    //Boolean untuk alfabet
    boolean isA;
    boolean isB;
    boolean isC;
    boolean isD;
    boolean isE;
    boolean isF;
    boolean isG;
    boolean isH;
    boolean isI;
    boolean isJ;
    boolean isK;
    boolean isL;
    boolean isM;
    boolean isN;
    boolean isO;
    boolean isP;
    boolean isQ;
    boolean isR;
    boolean isS;
    boolean isT;
    boolean isU;
    boolean isV;
    boolean isW;
    boolean isX;
    boolean isY;
    boolean isZ;
    String namatemp = " ";
    //Method untuk memasukkan nama pemain
    private Image entname = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\enteryourname.png").getImage();
    public void drawEnterName(Graphics g) {
        /*JTextField jt = new JTextField("Your name", 30);    
        add(jt); */
        g.drawImage(entname, 0, 0, null);
        Font courier = new Font("Courier New", Font.BOLD, 24);
        g.setColor(Color.BLACK);
        g.setFont(courier);
        int x = 370;
        int y = 340;
        for(int ent=1;ent<=5;ent++) {
            if(isA) {
                //g.drawString("A", x,y);
                namatemp = namatemp +"A";
                isA=false;
            }
            if(isB) {
                //g.drawString("B", x,y);
                namatemp = namatemp +"B";
                isB=false;
            }
            if(isC) {
                //g.drawString("C", x,y);
                namatemp = namatemp +"C";
                isC=false;
            }
            if(isD) {
                //g.drawString("D", x,y);
                namatemp = namatemp +"D";
                isD=false;
            }
            if(isE) {
                //g.drawString("E", x,y);
                namatemp = namatemp +"E";
                isE=false;
            }
            if(isF) {
                namatemp = namatemp +"F";
                isF=false;
            }
            if(isG) {
                namatemp = namatemp +"G";
                isG=false;
            }
            if(isH) {
                namatemp = namatemp +"H";
                isH=false;
            }
            if(isI) {
                namatemp = namatemp +"I";
                isI=false;
            }
            if(isJ) {
                namatemp = namatemp +"J";
                isJ=false;
            }
            if(isK) {
                namatemp = namatemp +"K";
                isK=false;
            }
            if(isL) {
                namatemp = namatemp +"L";
                isL=false;
            }
            if(isM) {
                namatemp = namatemp +"M";
                isM=false;
            }
            if(isN) {
                namatemp = namatemp +"N";
                isN=false;
            }
            if(isO) {
                namatemp = namatemp +"O";
                isO=false;
            }
            if(isP) {
                namatemp = namatemp +"P";
                isP=false;
            }
            if(isQ) {
                namatemp = namatemp +"Q";
                isQ=false;
            }
            if(isR) {
                namatemp = namatemp +"R";
                isR=false;
            }
            if(isS) {
                namatemp = namatemp +"S";
                isS=false;
            }
            //x += 20;   
        }
        player.setName(namatemp);
        g.drawString(namatemp,x,y);
    }
    
   
    private Image credit = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\credit.png").getImage();
    public void drawAfterMenu(Graphics g) throws FileNotFoundException{
        if(isnew){
            //Instansiasi atribut
            player= new Player("Jack", 15000,"south");
            player.setInvent(player.getnAI(),new Items("Turnip seed", 3, 210));
            player.setInvent(player.getnAI(),new Items("Fodder", 10, 120));
            field = new Field();
            time = new Time();
            maintime = new MainTime(time,player);
            barn = new Barn();
            barn.setLivestock(0, new Cow("Marie",barn.getPoint(0)));
            barn.setLivestock(1, new Sheep("Shaun",barn.getPoint(1)));
            coop = new Coop();
            coop.setChicken(0, new Chicken("Siwon",coop.getPoint(0)));
            house = new Rumah();
            field.setArrayOfPlots(10, true);
            field.setArrayOfCrops(10, new Turnip(field.getPoint(10)));
            field.getArrayOfCrops(10).setPhase("harvest");
            scenemainmenu= false;
            entername = true;
        }
        if(isload){
            loadGame(g);
            if(isloaddone) {
                scenefield=true;
                scenemainmenu = false;
            }
        }
        if(isexit){
            setVisible(false);
            dispose();
            System.exit(0);
        }
    }
    
    //Buy Sell
    //Dialog
    String[] sellerdialogs;
    private int indexdialog=0;
    //Boolean
    private boolean isBuySell;
    private boolean isTalking;
    private boolean isNextDialog;
    private boolean isBuy;
    private boolean isSell;
    //Image Buy Sell
    private Image backgroundbuysell = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Backgroundbuysell.png").getImage();
    private Image seller= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Seller.png").getImage();
    private Image sellerdialog = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Seller_dialog.png").getImage();
    private Image carriage = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Carriage.png").getImage();
    private Image selleranimal= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Seller_animal.png").getImage();
    private Image buybutton= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\buybutton.png").getImage();
    private Image sellbutton= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sellbutton.png").getImage();
    private Image buybackground= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Buybackground.png").getImage();
    private Image sellbackground= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\Sellbackground.png").getImage();
    private Image closebuttonbuy= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\closebuttonbuy.png").getImage();
    private Image closebuttonsell= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\closebuttonsell.png").getImage();
    //Image choices
    private Image chickenname1= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\chickenname1.png").getImage();
    private Image chickenname2= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\chickenname2.png").getImage();
    private Image chickenname3= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\chickenname3.png").getImage();
    private Image chickenname4= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\chickenname4.png").getImage();
    private Image cowname1= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\cowname1.png").getImage();
    private Image cowname2= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\cowname2.png").getImage();
    private Image cowname3= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\cowname3.png").getImage();
    private Image cowname4= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\cowname4.png").getImage();
    private Image sheepname1= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sheepname1.png").getImage();
    private Image sheepname2= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sheepname2.png").getImage();
    private Image sheepname3= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sheepname3.png").getImage();
    private Image sheepname4= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sheepname4.png").getImage();
    private Image amount1= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\amount1.png").getImage();
    private Image amount2= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\amount2.png").getImage();
    private Image amount3= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\amount3.png").getImage();
    private Image amount4= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\amount4.png").getImage();
    //choices
    private String[] arraynamechicken = new String[4];
    private String[] arraynamecow = new String[4];
    private String[] arraynamesheep = new String[4];
    private int nameindex;
    private int amountindex;
    
    //draw
    public void drawBuySell(Graphics g){
        
        g.drawImage(backgroundbuysell, 0, 0, null);
        g.drawImage(selleranimal, 600, 350, null);
        g.drawImage(seller, 900, 350, null);
        g.drawImage(carriage, 900, 500, null);
        
        sellerdialogs = new String[10];
        sellerdialogs[0]="";
        sellerdialogs[1]="Welcome.";
        sellerdialogs[2]="Buy or Sell?";
        sellerdialogs[3]="Choose an item";
        sellerdialogs[4]="You don't have enough G";
        sellerdialogs[5]="Pick a name";
        sellerdialogs[6]="Enter amount";
        sellerdialogs[7]="Thank you.";
        sellerdialogs[8]="";
        
        arraynamechicken[0]="Quinn";
        arraynamechicken[1]="Zatanna";
        arraynamechicken[2]="Talia";
        arraynamechicken[3]="Ivy";
        
        arraynamecow[0]="Lois";
        arraynamecow[1]="Selina";
        arraynamecow[2]="Diana";
        arraynamecow[3]="Iris";
        
        arraynamesheep[0]="Clark";
        arraynamesheep[1]="Bruce";
        arraynamesheep[2]="Barry";
        arraynamesheep[3]="Oliver";
        
        if(isTalking){
            g.drawImage(sellerdialog, 0, 150, null);
            g.drawString(sellerdialogs[indexdialog], 50, 600);
            if(isNextDialog){
                if(indexdialog==4){
                    indexdialog+=2;
                }
                if(indexdialog==5){
                    indexdialog++;
                }
                
                indexdialog++;
                g.drawString(sellerdialogs[indexdialog], 50, 600);
                
                isNextDialog=false;
                
                if(indexdialog==8){
                    indexdialog=0;
                    isTalking=false;
                }
            }
            if(indexdialog==2){
                    g.drawImage(buybutton, 1100, 320, null);
                    g.drawImage(sellbutton, 1100, 400, null);
                 
            }
            if(indexdialog==5){
                if(isbuychicken){
                    g.drawImage(chickenname1, 1100, 160, null);
                    g.drawImage(chickenname2, 1100, 240, null);
                    g.drawImage(chickenname3, 1100, 320, null);
                    g.drawImage(chickenname4, 1100, 400, null);
                }
                if(isbuycow){
                    g.drawImage(cowname1, 1100, 160, null);
                    g.drawImage(cowname2, 1100, 240, null);
                    g.drawImage(cowname3, 1100, 320, null);
                    g.drawImage(cowname4, 1100, 400, null);
                }
                if(isbuysheep){
                    g.drawImage(sheepname1, 1100, 160, null);
                    g.drawImage(sheepname2, 1100, 240, null);
                    g.drawImage(sheepname3, 1100, 320, null);
                    g.drawImage(sheepname4, 1100, 400, null);
                }
            }
            if(indexdialog==6){
                g.drawImage(amount1, 1100, 160, null);
                g.drawImage(amount2, 1100, 240, null);
                g.drawImage(amount3, 1100, 320, null);
                g.drawImage(amount4, 1100, 400, null);
            }
            
            //buying 
            if(isbuychicken){
                if(player.getGold()<5000){
                    g.drawImage(sellerdialog, 0, 150, null);
                    indexdialog=4;
                    g.drawString(sellerdialogs[indexdialog], 50, 600);
                    isbuychicken=false;
                    isBuy=false;
                } else {
                    isBuy=false;
                    g.drawImage(sellerdialog, 0, 150, null);
                    indexdialog=5;
                    g.drawString(sellerdialogs[indexdialog], 50, 600);
                    if(isbuychickenname){
                        String chickenname = arraynamechicken[nameindex];
                        Chicken ch = new Chicken(chickenname, coop.getLocation());
                        coop.setChicken(coop.getnAC()+1, ch);
                        player.setGold(player.getGold()-5000);
                        isbuychickenname=false;
                        isbuychicken=false;
                    }
                }
            }
            if(isbuycow){
                if(player.getGold()<10000){
                    g.drawImage(sellerdialog, 0, 150, null);
                    indexdialog=4;
                    g.drawString(sellerdialogs[indexdialog], 50, 600);
                    isbuycow=false;
                    isBuy=false;
                } else{
                    isBuy=false;
                    g.drawImage(sellerdialog, 0, 150, null);
                    indexdialog=5;
                    g.drawString(sellerdialogs[indexdialog], 50, 600);
                    if(isbuycowname){
                        String cowname = arraynamecow[nameindex];
                        Cow c = new Cow(cowname, barn.getLocation());
                        barn.setLivestock(barn.getnAL()+1, c);
                        player.setGold(player.getGold()-10000);
                        isbuycowname=false;
                        isbuycow=false;
                    }
                }
            }
            if(isbuysheep){
                if(player.getGold()<7000){
                    g.drawImage(sellerdialog, 0, 150, null);
                    indexdialog=4;
                    g.drawString(sellerdialogs[indexdialog], 50, 600);
                    isbuysheep=false;
                    isBuy=false;
                } else{
                    isBuy=false;
                    g.drawImage(sellerdialog, 0, 150, null);
                    indexdialog=5;
                    g.drawString(sellerdialogs[indexdialog], 50, 600);
                    if(isbuysheepname){
                        String sheepname = arraynamesheep[nameindex];
                        Sheep s = new Sheep(sheepname, barn.getLocation());
                        barn.setLivestock(barn.getnAL()+1, s);
                        player.setGold(player.getGold()-7000);
                        isbuysheepname=false;
                        isbuysheep=false;
                    }
                }
            }
            if(isbuychickenfeed){
                isBuy=false;
                g.drawImage(sellerdialog, 0, 150, null);
                indexdialog=6;
                g.drawString(sellerdialogs[indexdialog], 50, 600);
                if(isbuychickenfeedamount){
                    if(player.getGold()<(140*amountindex)){
                        g.drawImage(sellerdialog, 0, 150, null);
                        indexdialog=4;
                        g.drawString(sellerdialogs[indexdialog], 50, 600);
                        isbuychickenfeed=false;
                        isbuychickenfeedamount=false;
                    }else{
                        boolean found=false;
                        for(int i=5; i<=11;i++){
                            if(player.getInvent(i)!=null){
                                if(player.getInvent(i).getName()=="Chicken feed"){
                                    player.plusAmount(i, amountindex);
                                    player.setGold(player.getGold()-(140*amountindex));
                                    isbuychickenfeedamount=false;
                                    isbuychickenfeed=false;
                                    found=true;
                                }
                            }
                        }
                        if(!found){
                            if(player.getnAI()<11){
                                player.setInvent(player.getnAI(), new Items("Chicken feed", amountindex, 140));
                                player.setGold(player.getGold()-(140*amountindex));
                            }
                            isbuychickenfeedamount=false;
                            isbuychickenfeed=false;
                        }
                    }
                }
            }
            if(isbuyfodder){
                isBuy=false;
                g.drawImage(sellerdialog, 0, 150, null);
                indexdialog=6;
                g.drawString(sellerdialogs[indexdialog], 50, 600);
                if(isbuyfodderamount){
                    if(player.getGold()<(110*amountindex)){
                        g.drawImage(sellerdialog, 0, 150, null);
                        indexdialog=4;
                        g.drawString(sellerdialogs[indexdialog], 50, 600);
                        isbuyfodder=false;
                        isbuyfodderamount=false;
                    }else{
                        boolean found=false;
                        for(int i=5; i<=11;i++){
                            if(player.getInvent(i)!=null){
                                if(player.getInvent(i).getName()=="Fodder"){
                                    player.plusAmount(i, amountindex);
                                    player.setGold(player.getGold()-(110*amountindex));
                                    isbuyfodderamount=false;
                                    isbuyfodder=false;
                                    found=true;
                                }
                            }
                        }
                        if(!found){
                            if(player.getnAI()<11){
                                player.setInvent(player.getnAI(), new Items("Fodder", amountindex, 110));
                                player.setGold(player.getGold()-(110*amountindex));
                            }
                            isbuyfodderamount=false;
                            isbuyfodder=false;
                        }
                    }
                }
            }
            if(isbuyturnipseed){
                isBuy=false;
                g.drawImage(sellerdialog, 0, 150, null);
                indexdialog=6;
                g.drawString(sellerdialogs[indexdialog], 50, 600);
                if(isbuyturnipseedamount){
                    if(player.getGold()<(210*amountindex)){
                        g.drawImage(sellerdialog, 0, 150, null);
                        indexdialog=4;
                        g.drawString(sellerdialogs[indexdialog], 50, 600);
                        isbuyturnipseed=false;
                        isbuyturnipseedamount=false;
                    }else{
                        boolean found=false;
                        for(int i=5; i<=11;i++){
                            if(player.getInvent(i)!=null){
                                if(player.getInvent(i).getName()=="Turnip seed"){
                                    player.plusAmount(i, amountindex);
                                    player.setGold(player.getGold()-(210*amountindex));
                                    isbuyturnipseedamount=false;
                                    isbuyturnipseed=false;
                                    found=true;
                                }
                            }
                        }
                        if(!found){
                            if(player.getnAI()<11){
                                player.setInvent(player.getnAI(), new Items("Turnip seed", amountindex, 210));
                                player.setGold(player.getGold()-(210*amountindex));
                            }
                            isbuyturnipseedamount=false;
                            isbuyturnipseed=false;
                        }
                    }
                }
            }
            if(isbuycabbageseed){
                isBuy=false;
                g.drawImage(sellerdialog, 0, 150, null);
                indexdialog=6;
                g.drawString(sellerdialogs[indexdialog], 50, 600);
                if(isbuycabbageseedamount){
                    if(player.getGold()<(510*amountindex)){
                        g.drawImage(sellerdialog, 0, 150, null);
                        indexdialog=4;
                        g.drawString(sellerdialogs[indexdialog], 50, 600);
                        isbuycabbageseed=false;
                        isbuycabbageseedamount=false;
                    }else{
                        boolean found=false;
                        for(int i=5; i<=11;i++){
                            if(player.getInvent(i)!=null){
                                if(player.getInvent(i).getName()=="Cabbage seed"){
                                    player.plusAmount(i, amountindex);
                                    player.setGold(player.getGold()-(510*amountindex));
                                    isbuycabbageseedamount=false;
                                    isbuycabbageseed=false;
                                    found=true;
                                }
                            }
                        }
                        if(!found){
                            if(player.getnAI()<11){
                                player.setInvent(player.getnAI(), new Items("Cabbage seed", amountindex, 510));
                                player.setGold(player.getGold()-(510*amountindex));
                            }
                            isbuycabbageseedamount=false;
                            isbuycabbageseed=false;
                        }
                    }
                }
            }
            if(isbuycarrotseed){
                isBuy=false;
                g.drawImage(sellerdialog, 0, 150, null);
                indexdialog=6;
                g.drawString(sellerdialogs[indexdialog], 50, 600);
                if(isbuycarrotseedamount){
                    if(player.getGold()<(260*amountindex)){
                        g.drawImage(sellerdialog, 0, 150, null);
                        indexdialog=4;
                        g.drawString(sellerdialogs[indexdialog], 50, 600);
                        isbuycarrotseed=false;
                        isbuycarrotseedamount=false;
                    }else{
                        boolean found=false;
                        for(int i=5; i<=11;i++){
                            if(player.getInvent(i)!=null){
                                if(player.getInvent(i).getName()=="Carrot seed"){
                                    player.plusAmount(i, amountindex);
                                    player.setGold(player.getGold()-(260*amountindex));
                                    isbuycarrotseedamount=false;
                                    isbuycarrotseed=false;
                                    found=true;
                                }
                            }
                        }
                        if(!found){
                            if(player.getnAI()<11){
                                player.setInvent(player.getnAI(), new Items("Carrot seed", amountindex, 260));
                                player.setGold(player.getGold()-(260*amountindex));
                            }
                            isbuycarrotseedamount=false;
                            isbuycarrotseed=false;
                        }
                    }
                }
            }
            if(isbuycornseed){
                isBuy=false;
                g.drawImage(sellerdialog, 0, 150, null);
                indexdialog=6;
                g.drawString(sellerdialogs[indexdialog], 50, 600);
                if(isbuycornseedamount){
                    if(player.getGold()<(760*amountindex)){
                        g.drawImage(sellerdialog, 0, 150, null);
                        indexdialog=4;
                        g.drawString(sellerdialogs[indexdialog], 50, 600);
                        isbuycornseed=false;
                        isbuycornseedamount=false;
                    }else{
                        boolean found=false;
                        for(int i=5; i<=11;i++){
                            if(player.getInvent(i)!=null){
                                if(player.getInvent(i).getName()=="Corn seed"){
                                    player.plusAmount(i, amountindex);
                                    player.setGold(player.getGold()-(760*amountindex));
                                    isbuycornseedamount=false;
                                    isbuycornseed=false;
                                    found=true;
                                }
                            }
                        }
                        if(!found){
                            if(player.getnAI()<11){
                                player.setInvent(player.getnAI(), new Items("Corn seed", amountindex, 760));
                                player.setGold(player.getGold()-(760*amountindex));
                            }
                            isbuycornseedamount=false;
                            isbuycornseed=false;
                        }
                    }
                }
            }
            if(isbuytomatoseed){
                isBuy=false;
                g.drawImage(sellerdialog, 0, 150, null);
                indexdialog=6;
                g.drawString(sellerdialogs[indexdialog], 50, 600);
                if(isbuytomatoseedamount){
                    if(player.getGold()<(210*amountindex)){
                        g.drawImage(sellerdialog, 0, 150, null);
                        indexdialog=4;
                        g.drawString(sellerdialogs[indexdialog], 50, 600);
                        isbuytomatoseed=false;
                        isbuytomatoseedamount=false;
                    }else{
                        boolean found=false;
                        for(int i=5; i<=11;i++){
                            if(player.getInvent(i)!=null){
                                if(player.getInvent(i).getName()=="Tomato seed"){
                                    player.plusAmount(i, amountindex);
                                    player.setGold(player.getGold()-(210*amountindex));
                                    isbuytomatoseedamount=false;
                                    isbuytomatoseed=false;
                                    found=true;
                                }
                            }
                        }
                        if(!found){
                            if(player.getnAI()<11){
                                player.setInvent(player.getnAI(), new Items("Tomato seed", amountindex, 210));
                                player.setGold(player.getGold()-(210*amountindex));
                            }
                            isbuytomatoseedamount=false;
                            isbuytomatoseed=false;
                        }
                    }
                }
            }
            if(isbuygrassseed){
                isBuy=false;
                g.drawImage(sellerdialog, 0, 150, null);
                indexdialog=6;
                g.drawString(sellerdialogs[indexdialog], 50, 600);
                if(isbuygrassseedamount){
                    if(player.getGold()<(20*amountindex)){
                        g.drawImage(sellerdialog, 0, 150, null);
                        indexdialog=4;
                        g.drawString(sellerdialogs[indexdialog], 50, 600);
                        isbuygrassseed=false;
                        isbuygrassseedamount=false;
                    }else{
                        boolean found=false;
                        for(int i=5; i<=11;i++){
                            if(player.getInvent(i)!=null){
                                if(player.getInvent(i).getName()=="Grass seed"){
                                    player.plusAmount(i, amountindex);
                                    player.setGold(player.getGold()-(20*amountindex));
                                    isbuygrassseedamount=false;
                                    isbuygrassseed=false;
                                    found=true;
                                }
                            }
                        }
                        if(!found){
                            if(player.getnAI()<11){
                                player.setInvent(player.getnAI(), new Items("Grass seed", amountindex, 20));
                                player.setGold(player.getGold()-(20*amountindex));
                            }
                            isbuygrassseedamount=false;
                            isbuygrassseed=false;
                        }
                    }
                }
            }
        }
    }
    
    //draw Buy
    //Image
    private Image buychicken = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\buychicken.png").getImage();
    private Image buychickenhover = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\buychickenhover.png").getImage();
    private Image buycow= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\buycow.png").getImage();
    private Image buycowhover= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\buycowhover.png").getImage();
    private Image buysheep= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\buysheep.png").getImage();
    private Image buysheephover= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\buysheephover.png").getImage();
    private Image buychickenfeed= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\buychickenfeed.png").getImage();
    private Image buychickenfeedhover= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\buychickenfeedhover.png").getImage();
    private Image buyfodder= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\buyfodder.png").getImage();
    private Image buyfodderhover= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\buyfodderhover.png").getImage();
    private Image buyturnipseed= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\buyturnipseed.png").getImage();
    private Image buyturnipseedhover= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\buyturnipseedhover.png").getImage();
    private Image buycabbageseed= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\buycabbageseed.png").getImage();
    private Image buycabbageseedhover= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\buycabbageseedhover.png").getImage();
    private Image buycarrotseed= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\buycarrotseed.png").getImage();
    private Image buycarrotseedhover= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\buycarrotseedhover.png").getImage();
    private Image buycornseed= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\buycornseed.png").getImage();
    private Image buycornseedhover= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\buycornseedhover.png").getImage();
    private Image buytomatoseed= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\buytomatoseed.png").getImage();
    private Image buytomatoseedhover= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\buytomatoseedhover.png").getImage();
    private Image buygrassseed= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\buygrassseed.png").getImage();
    private Image buygrassseedhover= new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\buygrassseedhover.png").getImage();
    //boolean
    //hover
    private boolean onbuychicken;
    private boolean onbuycow;
    private boolean onbuysheep;
    private boolean onbuychickenfeed;
    private boolean onbuyfodder;
    private boolean onbuyturnipseed;
    private boolean onbuycabbageseed;
    private boolean onbuycarrotseed;
    private boolean onbuycornseed;
    private boolean onbuytomatoseed;
    private boolean onbuygrassseed;
    //buy
    private boolean isbuychicken;
    private boolean isbuychickenname;
    private boolean isbuycow;
    private boolean isbuycowname;
    private boolean isbuysheep;
    private boolean isbuysheepname;
    private boolean isbuychickenfeed;
    private boolean isbuychickenfeedamount;
    private boolean isbuyfodder;
    private boolean isbuyfodderamount;
    private boolean isbuyturnipseed;
    private boolean isbuyturnipseedamount;
    private boolean isbuycabbageseed;
    private boolean isbuycabbageseedamount;
    private boolean isbuycarrotseed;
    private boolean isbuycarrotseedamount;
    private boolean isbuycornseed;
    private boolean isbuycornseedamount;
    private boolean isbuytomatoseed;
    private boolean isbuytomatoseedamount;
    private boolean isbuygrassseed;
    private boolean isbuygrassseedamount;
    
    public void drawBuy(Graphics g){
        g.drawImage(buybackground, 0, 0, null);
        g.drawImage(closebuttonbuy, 1150, 30, null);
        g.drawImage(buychicken, 300, 150, null);
        g.drawImage(buycow, 470, 150, null);
        g.drawImage(buysheep, 640, 150, null);
        g.drawImage(buychickenfeed, 300, 310, null);
        g.drawImage(buyfodder, 470, 310, null);
        g.drawImage(buyturnipseed, 300, 470, null);
        g.drawImage(buycabbageseed, 460, 470, null);
        g.drawImage(buycarrotseed, 620, 470, null);
        g.drawImage(buycornseed, 780, 470, null);
        g.drawImage(buytomatoseed, 940, 470, null);
        g.drawImage(buygrassseed, 1100, 470, null);
        if(onbuychicken){
            g.drawImage(buychickenhover, 300, 150, null);
            onbuychicken=false;
        }
        if(onbuycow){
            g.drawImage(buycowhover, 470, 150, null);
            onbuycow=false;
        }
        if(onbuysheep){
            g.drawImage(buysheephover, 640, 150, null);
            onbuysheep=false;
        }
        if(onbuychickenfeed){
            g.drawImage(buychickenfeedhover, 300, 310, null);
            onbuychickenfeed=false;
        }
        if(onbuyfodder){
            g.drawImage(buyfodderhover, 470, 310, null);
            onbuyfodder=false;
        }
        if(onbuyturnipseed){
            g.drawImage(buyturnipseedhover, 300, 470, null);
            onbuyturnipseed=false;
        }
        if(onbuycabbageseed){
            g.drawImage(buycabbageseedhover, 460, 470, null);
            onbuycabbageseed=false;
        }
        if(onbuycarrotseed){
            g.drawImage(buycarrotseedhover, 620, 470, null);
            onbuycarrotseed=false;
        }
        if(onbuycornseed){
            g.drawImage(buycornseedhover, 780, 470, null);
            onbuycornseed=false;
        }
        if(onbuytomatoseed){
            g.drawImage(buytomatoseedhover, 940, 470, null);
            onbuytomatoseed=false;
        }
        if(onbuygrassseed){
            g.drawImage(buygrassseedhover, 1100, 470, null);
            onbuygrassseed=false;
        }
    }
    
    //draw sell
    //Image
    private Image sellchickenfeed = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sellchickenfeed.png").getImage();
    private Image sellchickenfeedhover = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sellchickenfeedhover.png").getImage();
    private Image sellfodder = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sellfodder.png").getImage();
    private Image sellfodderhover = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sellfodderhover.png").getImage();
    private Image sellturnipseed = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sellturnipseed.png").getImage();
    private Image sellturnipseedhover = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sellturnipseedhover.png").getImage();
    private Image sellturnip = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sellturnip.png").getImage();
    private Image sellturniphover = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sellturniphover.png").getImage();
    private Image sellcabbageseed = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sellcabbageseed.png").getImage();
    private Image sellcabbageseedhover = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sellcabbageseedhover.png").getImage();
    private Image sellcabbage = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sellcabbage.png").getImage();
    private Image sellcabbagehover = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sellcabbagehover.png").getImage();
    private Image sellcarrotseed = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sellcarrotseed.png").getImage();
    private Image sellcarrotseedhover = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sellcarrotseedhover.png").getImage();
    private Image sellcarrot = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sellcarrot.png").getImage();
    private Image sellcarrothover = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sellcarrothover.png").getImage();
    private Image sellcornseed = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sellcornseed.png").getImage();
    private Image sellcornseedhover = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sellcornseedhover.png").getImage();
    private Image sellcorn = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sellcorn.png").getImage();
    private Image sellcornhover = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sellcornhover.png").getImage();
    private Image selltomatoseed = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\selltomatoseed.png").getImage();
    private Image selltomatoseedhover = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\selltomatoseedhover.png").getImage();
    private Image selltomato = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\selltomato.png").getImage();
    private Image selltomatohover = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\selltomatohover.png").getImage();
    private Image sellgrassseed = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sellgrassseed.png").getImage();
    private Image sellgrassseedhover = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sellgrassseedhover.png").getImage();
    private Image sellmilk = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sellmilk.png").getImage();
    private Image sellmilkhover = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sellmilkhover.png").getImage();
    private Image sellegg = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sellegg.png").getImage();
    private Image sellegghover = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sellegghover.png").getImage();
    private Image sellwool = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sellwool.png").getImage();
    private Image sellwoolhover = new ImageIcon("C:\\Users\\acer\\Documents\\NetBeansProjects\\HarvestValley\\src\\images\\sellwoolhover.png").getImage();
    //boolean
    private boolean isselling;
    //hover
    private boolean onsellitems0;
    private boolean onsellitems1;
    private boolean onsellitems2;
    private boolean onsellitems3;
    private boolean onsellitems4;
    private boolean onsellitems5;
    private boolean onsellitems6;
    //array
    private Image[] arrayimagesell = new Image[7];
    private Image[] arrayhoversell = new Image[7];
    private Items[] arrayitemssell = new Items[7];
    private int indexsell;
    private int indexhover;
    
    public void drawSell(Graphics g){
        g.drawImage(sellbackground, 0, 0, null);
        g.drawImage(closebuttonsell, 1150, 30, null);
        
        //isi array
        int ix=0;
        for(int i=5;i<=11;i++){
            if(player.getInvent(i)!=null && player.getInvent(i) instanceof Items){
                if(player.getInvent(i).getName()=="Chicken feed"){
                    arrayimagesell[ix]=sellchickenfeed;
                    arrayhoversell[ix]=sellchickenfeedhover;
                    arrayitemssell[ix]=(Items)player.getInvent(i);
                    ix++;
                }
                if(player.getInvent(i).getName()=="Fodder"){
                    arrayimagesell[ix]=sellfodder;
                    arrayhoversell[ix]=sellfodderhover;
                    arrayitemssell[ix]=(Items)player.getInvent(i);
                    ix++;
                }
                if(player.getInvent(i).getName()=="Turnip seed"){
                    arrayimagesell[ix]=sellturnipseed;
                    arrayhoversell[ix]=sellturnipseedhover;
                    arrayitemssell[ix]=(Items)player.getInvent(i);
                    ix++;
                }
                if(player.getInvent(i).getName()=="Turnip"){
                    arrayimagesell[ix]=sellturnip;
                    arrayhoversell[ix]=sellturniphover;
                    arrayitemssell[ix]=(Items)player.getInvent(i);
                    ix++;
                }
                if(player.getInvent(i).getName()=="Cabbage seed"){
                    arrayimagesell[ix]=sellcabbageseed;
                    arrayhoversell[ix]=sellcabbageseedhover;
                    arrayitemssell[ix]=(Items)player.getInvent(i);
                    ix++;
                }
                if(player.getInvent(i).getName()=="Cabbage"){
                    arrayimagesell[ix]=sellcabbage;
                    arrayhoversell[ix]=sellcabbagehover;
                    arrayitemssell[ix]=(Items)player.getInvent(i);
                    ix++;
                }
                if(player.getInvent(i).getName()=="Carrot seed"){
                    arrayimagesell[ix]=sellcarrotseed;
                    arrayhoversell[ix]=sellcarrotseedhover;
                    arrayitemssell[ix]=(Items)player.getInvent(i);
                    ix++;
                }
                if(player.getInvent(i).getName()=="Carrot"){
                    arrayimagesell[ix]=sellcarrot;
                    arrayhoversell[ix]=sellcarrothover;
                    arrayitemssell[ix]=(Items)player.getInvent(i);
                    ix++;
                }
                if(player.getInvent(i).getName()=="Corn seed"){
                    arrayimagesell[ix]=sellcornseed;
                    arrayhoversell[ix]=sellcornseedhover;
                    arrayitemssell[ix]=(Items)player.getInvent(i);
                    ix++;
                }
                if(player.getInvent(i).getName()=="Corn"){
                    arrayimagesell[ix]=sellcorn;
                    arrayhoversell[ix]=sellcornhover;
                    arrayitemssell[ix]=(Items)player.getInvent(i);
                    ix++;
                }
                if(player.getInvent(i).getName()=="Tomato seed"){
                    arrayimagesell[ix]=selltomatoseed;
                    arrayhoversell[ix]=selltomatoseedhover;
                    arrayitemssell[ix]=(Items)player.getInvent(i);
                    ix++;
                }
                if(player.getInvent(i).getName()=="Tomato"){
                    arrayimagesell[ix]=selltomato;
                    arrayhoversell[ix]=selltomatohover;
                    arrayitemssell[ix]=(Items)player.getInvent(i);
                    ix++;
                }
                if(player.getInvent(i).getName()=="Grass seed"){
                    arrayimagesell[ix]=sellgrassseed;
                    arrayhoversell[ix]=sellgrassseedhover;
                    arrayitemssell[ix]=(Items)player.getInvent(i);
                    ix++;
                }
                if(player.getInvent(i).getName()=="Milk"){
                    arrayimagesell[ix]=sellmilk;
                    arrayhoversell[ix]=sellmilkhover;
                    arrayitemssell[ix]=(Items)player.getInvent(i);
                    ix++;
                }
                if(player.getInvent(i).getName()=="Egg"){
                    arrayimagesell[ix]=sellegg;
                    arrayhoversell[ix]=sellegghover;
                    arrayitemssell[ix]=(Items)player.getInvent(i);
                    ix++;
                }
                if(player.getInvent(i).getName()=="Wool"){
                    arrayimagesell[ix]=sellwool;
                    arrayhoversell[ix]=sellwoolhover;
                    arrayitemssell[ix]=(Items)player.getInvent(i);
                    ix++;
                }
            }
        }
        //draw on screen
        for(int iy=0;iy<=6;iy++){
            if(arrayimagesell[iy]!=null && arrayhoversell[iy]!=null && arrayitemssell[iy]!=null){
                if(iy==0){
                    g.drawImage(arrayimagesell[iy], 400, 150, null);
                }
                if(iy==1){
                    g.drawImage(arrayimagesell[iy], 570, 150, null);
                }
                if(iy==2){
                    g.drawImage(arrayimagesell[iy], 740, 150, null);
                }
                if(iy==3){
                    g.drawImage(arrayimagesell[iy], 400, 310, null);
                }
                if(iy==4){
                    g.drawImage(arrayimagesell[iy], 570, 310, null);
                }
                if(iy==5){
                    g.drawImage(arrayimagesell[iy], 740, 310, null);
                }
                if(iy==6){
                    g.drawImage(arrayimagesell[iy], 570, 470, null);
                }
            }
            //hover
            if(onsellitems0){
                if(arrayhoversell[0]!=null){
                    g.drawImage(arrayhoversell[0], 400, 150, null);
                }
                onsellitems0=false;
            }
            if(onsellitems1){
                if(arrayhoversell[1]!=null){
                    g.drawImage(arrayhoversell[1], 570, 150, null);
                }
                onsellitems1=false;
            }
            if(onsellitems2){
                if(arrayhoversell[2]!=null){
                    g.drawImage(arrayhoversell[2], 740, 150, null);
                }
                onsellitems2=false;
            }
            if(onsellitems3){
                if(arrayhoversell[3]!=null){
                    g.drawImage(arrayhoversell[3], 400, 310, null);
                }
                onsellitems3=false;
            }
            if(onsellitems4){
                if(arrayhoversell[4]!=null){
                    g.drawImage(arrayhoversell[4], 570, 310, null);
                }
                onsellitems4=false;
            }
            if(onsellitems5){
                if(arrayhoversell[5]!=null){
                    g.drawImage(arrayhoversell[5], 740, 310, null);
                }
                onsellitems5=false;
            }
            if(onsellitems6){
                if(arrayhoversell[6]!=null){
                    g.drawImage(arrayhoversell[6], 570, 470, null);
                }
                onsellitems6=false;
            }
            Font courier = new Font("Courier New", Font.BOLD, 24);
            g.setColor(Color.BLACK);
            g.setFont(courier);
            if(arrayitemssell[indexhover]!=null){
                g.drawString("Amount :" + arrayitemssell[indexhover].getAmount(), 400, 650);
            }
        }
        //selling
        if(isselling){
            if(arrayitemssell[indexsell]!=null){
                player.setGold(player.getGold()+(arrayitemssell[indexsell].getPrice()*arrayitemssell[indexsell].getAmount()));
                arrayitemssell[indexsell]=null;
                arrayimagesell[indexsell]=null;
                arrayhoversell[indexsell]=null;
                player.setInvent(indexsell+5, null);
                
                g.drawImage(sellerdialog, 0, 150, null);
                indexdialog=7;
                g.drawString(sellerdialogs[indexdialog], 50, 600);
                isselling=false;
                isSell=false;
            }
            isselling=false;
        }
    }
    
    
    //Method drawScene
    public void drawSceneField(Graphics g) {
        g.drawImage(fieldbackground, 0, 0, null);
        for(int i=0;i<=99;i++){
            drawPlot(g,i);
        }
        drawPlayerTools(g);
        drawPlayerMoving(g);
    }
    
    public void drawSceneBarn(Graphics g) {
        //player.setLocation(400, 400);
        //player.setNavigation("south");
        g.drawImage(barnbg, 0, 0, null);
        drawLivestock(g);
        drawPlayerMoving(g);
        drawGetProduct(g);
        drawFodder(g);
    }
    
    public void drawSceneCoop(Graphics g) {
        g.drawImage(coopbg, 0,0, null);
        drawChicken(g);
        drawPlayerMoving(g);
        //drawGetEgg(g);
    }
    
    public void drawSceneHouse(Graphics g) {
        //player.setLocation(50,350);
        g.drawImage(housebg, 0, 0, null);
        g.drawImage(bed, 30, 100, null);
        g.drawImage(cupboard, 220,80, null);
        g.drawImage(tv, 320, 80, null);
        g.drawImage(bookshelf, 420, 80, null);
        g.drawImage(box, 540, 90, null);
        drawPlayerMoving(g);
        Sleep(g);
    }
    
    public void drawSceneBuilding(Graphics g) {
        g.drawImage(buildingbg, 0, 0, null);
        g.drawImage(barnb, 35, 70, null);
        g.drawImage(houseb, 320,70, null);
        g.drawImage(coopb, 617, 70, null);
        drawPlayerMoving(g);
    }
    
    public void drawSceneInvent(Graphics g) {
        g.drawImage(inventbg, 0, 0, null);
        drawInvent(g);
        drawState(g);
    }
    
    public void drawSceneMap(Graphics g) {
        g.drawImage(mapbackground, 0, 0, null);
    }
    
    public void drawJackHead (Graphics g) {
        g.drawImage(jackhead, 0, 0, null);
    }

	public static void main(String args [])
	{	      
	  new GUITest();		
	}

	GUITest ()
	{
            //Testing
                //for(int ix=0;ix<=99;ix++){
                //    field.setArrayOfPlots(ix, true);
                //}
                //field.setArrayOfCrops(50, new Turnip(field.getPoint(50)));
                //field.getArrayOfCrops(50).setPhase("harvest"); 
                //player.setActive(1);
                //barn.getLivestock(0).changeReady(true);
                //barn.getLivestock(1).changeReady(true);
                scenemainmenu = true;
            //Testing end here
            Container container = getContentPane();
	    PanelGUI panel = new PanelGUI();
	    container.add(panel);
            /*if(entername) {
                panel.add(jt);
                jt.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String input = jt.getText();
                        player.setName(input);
                        entername = false;
                        scenebuilding = true;
                    }
                });
            }*/
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setSize(ScreenWidth,ScreenHeight);
	    setTitle("Harvest Valley");
	    setVisible(true);
            addKeyListener(this);
            addMouseListener(this);
            addMouseMotionListener(this);
	}
}
