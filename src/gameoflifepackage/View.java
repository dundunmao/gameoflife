package gameoflifepackage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class View extends JFrame implements ActionListener, ChangeListener, ItemListener {
  private static final long serialVersionUID = 1L;
  private Grid grid;
  private GameManager gameManager;
  private JButton nextButton, startButton, cellColorButton, gridColorButton;
  private JSlider speedSlider, sizeSlider;
  private JComboBox<String> patternSelectorComboBox;
  private JLabel speedImg, sizeImg, paintImg, backImg;
  private static final String[] names = {
		"Clear",
		"Fill Grid",
		"Lightweight Spaceship",
		"Pulsar",
		"Gosper Glider Gun",
		"Blinker Fuse",
		"COEN 275"
	};

  ImageIcon speedIcon = new ImageIcon("src/resource/speed.jpeg");
  ImageIcon zoomIcon = new ImageIcon("src/resource/zoom.jpeg");
  ImageIcon paintIcon = new ImageIcon("src/resource/paint.jpeg");
  ImageIcon backIcon = new ImageIcon("src/resource/back.png");
  Timer timer = new Timer(1000, this);

  public View(Grid grid, GameManager gameManager) {
	  this.grid = grid;
	  this.gameManager = gameManager;
	
	  setSize(1000, 850);
	  setLayout(null);
	  setVisible(true);
	  setLocationRelativeTo(null);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	  add(grid);
	
	  this.nextButton = new JButton("Next");
	  nextButton.setBounds(150, 700, 80, 25);
	  nextButton.addActionListener(this);
	  add(nextButton);
	
	  this.startButton = new JButton("Start");
	  startButton.setBounds(230, 700, 80, 25);
	  startButton.addActionListener(this);
	  add(startButton);
	
	  this.cellColorButton = new JButton("Cell");
	  cellColorButton.setBounds(750, 728, 80, 25);
	  cellColorButton.addActionListener(this);
	  add(cellColorButton);
	
	  this.gridColorButton = new JButton("Grid");
	  gridColorButton.setBounds(750, 755, 80, 25);
	  gridColorButton.addActionListener(this);
	  add(gridColorButton);
	
	  this.speedSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
	  speedSlider.setBounds(385, 700, 110, 25);
	  speedSlider.addChangeListener(this);
	  add(speedSlider);
	
	  this.sizeSlider = new JSlider(JSlider.HORIZONTAL, 0, 50, 0);
	  sizeSlider.setBounds(535, 700, 110, 25);
	  sizeSlider.addChangeListener(this);
	  add(sizeSlider);
	
	  this.patternSelectorComboBox = new JComboBox<String>(names);
	  patternSelectorComboBox.setBounds(700, 700, 200, 25);
	  patternSelectorComboBox.setMaximumRowCount(5);
	  patternSelectorComboBox.addItemListener(this);
	  add(patternSelectorComboBox);
	
	  this.speedImg = new JLabel(speedIcon);
	  speedImg.setBounds(340, 695, 50, 30);
	  add(speedImg);
	
	  this.sizeImg = new JLabel(zoomIcon);
	  sizeImg.setBounds(492, 700, 50, 30);
	  add(sizeImg);
	
	  this.paintImg = new JLabel(paintIcon);
	  paintImg.setBounds(700, 735, 50, 30);
	  add(paintImg);
	
	  this.backImg = new JLabel(backIcon);
	  backImg.setBounds(0, 0, 1000, 1000);
	  add(backImg);
  }

  public void actionPerformed(ActionEvent event) {
    if (event.getSource() == nextButton) {
      gameManager.nextGeneration();
      repaint();
    } else if (event.getSource() == startButton) {
      if (startButton.getText() == "Start") {
        timer.start();
        startButton.setText("Stop");
      } else if (startButton.getText() == "Stop") {
        startButton.setText("Start");
        timer.stop();
      }
    } else if (event.getSource() == timer) {
      gameManager.nextGeneration();
      repaint();
    } else if(event.getSource() == cellColorButton) {
      Color initialcolor = Color.YELLOW;
      Color color = JColorChooser.showDialog(this, "Select a color", initialcolor);
      grid.setCellColor(color);
      repaint();
    } else if(event.getSource() == gridColorButton) {
      Color initialcolor = Color.GRAY;
      Color color = JColorChooser.showDialog(this, "Select a color", initialcolor);
      grid.setGridColor(color);
      repaint();
    }
  }

  public void stateChanged(ChangeEvent event) {
    if (event.getSource() == sizeSlider) {
      int sizeValue = sizeSlider.getValue();
      this.grid.setCellSize(18 - (sizeValue / 15));
    } else if (event.getSource() == speedSlider) {
      // Speed can range from 1000ms-50ms
      int speedValue = speedSlider.getValue();
      int hertz = 1 + speedValue * 19 / 100;
      timer.setDelay(1000 / hertz);
    }
  }

  @Override
  public void itemStateChanged(ItemEvent e) {
    String item = e.getItem().toString();
    int stateChange = e.getStateChange();
    if (stateChange == ItemEvent.SELECTED) {
      if (item.equals(names[0])){
        grid.clearGrid();
        repaint();
      } else if (item.equals(names[1])) {
        grid.fillGrid();
        repaint();
      } else if (item.equals(names[2])) {
        grid.setSpaceshipPattern();
        repaint();
      } else if (item.equals(names[3])) {
        grid.setPulsarPattern();
        repaint();
      } else if (item.equals(names[4])) {
        grid.setGliderPattern();
        repaint();
      } else if (item.equals(names[5])) {
        grid.setBlinkerPattern();
        repaint();
      } else if (item.equals(names[6])) {
        grid.setCOENPattern();
        repaint();
      }
    }
  }
}