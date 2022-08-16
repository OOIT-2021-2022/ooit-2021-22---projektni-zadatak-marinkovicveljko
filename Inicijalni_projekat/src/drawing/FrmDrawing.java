package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

import javax.swing.JToggleButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FrmDrawing extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Point sparePoint;
	private boolean firstClickPoint = true;
	private Shape selectedShape;
	private PnlDrawing pnlDrawing;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDrawing frame = new FrmDrawing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmDrawing() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 300);
		pnlDrawing = new PnlDrawing();
		pnlDrawing.setBackground(Color.WHITE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlNorth = new JPanel();
		contentPane.add(pnlNorth, BorderLayout.NORTH);
		GridBagLayout gbl_pnlNorth = new GridBagLayout();
		gbl_pnlNorth.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_pnlNorth.rowHeights = new int[]{0, 0};
		gbl_pnlNorth.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlNorth.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlNorth.setLayout(gbl_pnlNorth);
		
		JToggleButton tglbtnPoint = new JToggleButton("Point");
		
		buttonGroup.add(tglbtnPoint);
		GridBagConstraints gbc_tglbtnPoint = new GridBagConstraints();
		gbc_tglbtnPoint.weightx = 80.0;
		gbc_tglbtnPoint.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnPoint.gridx = 0;
		gbc_tglbtnPoint.gridy = 0;
		pnlNorth.add(tglbtnPoint, gbc_tglbtnPoint);
		
		JToggleButton tglbtnLine = new JToggleButton("Line");
		tglbtnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstClickPoint = true;
			}
		});
		
		buttonGroup.add(tglbtnLine);
		GridBagConstraints gbc_tglbtnLine = new GridBagConstraints();
		gbc_tglbtnLine.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnLine.gridx = 1;
		gbc_tglbtnLine.gridy = 0;
		pnlNorth.add(tglbtnLine, gbc_tglbtnLine);
		
		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		
		buttonGroup.add(tglbtnRectangle);
		GridBagConstraints gbc_tglbtnRectangle = new GridBagConstraints();
		gbc_tglbtnRectangle.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnRectangle.gridx = 2;
		gbc_tglbtnRectangle.gridy = 0;
		pnlNorth.add(tglbtnRectangle, gbc_tglbtnRectangle);
		
		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		
		buttonGroup.add(tglbtnCircle);
		GridBagConstraints gbc_tglbtnCircle = new GridBagConstraints();
		gbc_tglbtnCircle.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnCircle.gridx = 3;
		gbc_tglbtnCircle.gridy = 0;
		pnlNorth.add(tglbtnCircle, gbc_tglbtnCircle);
		
		JToggleButton tglbtnDonut = new JToggleButton("Donut");
		
		buttonGroup.add(tglbtnDonut);
		GridBagConstraints gbc_tglbtnDonut = new GridBagConstraints();
		gbc_tglbtnDonut.gridx = 4;
		gbc_tglbtnDonut.gridy = 0;
		pnlNorth.add(tglbtnDonut, gbc_tglbtnDonut);
		
		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlSouth = new GridBagLayout();
		gbl_pnlSouth.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlSouth.rowHeights = new int[]{0, 0};
		gbl_pnlSouth.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlSouth.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlSouth.setLayout(gbl_pnlSouth);
		
		JToggleButton tglbtnSelect = new JToggleButton("Select");
		buttonGroup.add(tglbtnSelect);
		GridBagConstraints gbc_tglbtnSelect = new GridBagConstraints();
		gbc_tglbtnSelect.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnSelect.gridx = 3;
		gbc_tglbtnSelect.gridy = 0;
		pnlSouth.add(tglbtnSelect, gbc_tglbtnSelect);
		
		JToggleButton tglbtnModify = new JToggleButton("Modify");
		tglbtnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pnlDrawing.getSelectedShape() != null) {
					pnlDrawing.modify();
					pnlDrawing.setSelect(false);
					repaint();
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Please select shape!");
				}
				pnlDrawing.setSelectedShape(null);
			}
		});
		buttonGroup.add(tglbtnModify);
		GridBagConstraints gbc_tglbtnModify = new GridBagConstraints();
		gbc_tglbtnModify.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnModify.gridx = 5;
		gbc_tglbtnModify.gridy = 0;
		pnlSouth.add(tglbtnModify, gbc_tglbtnModify);
		
		JToggleButton tglbtnDelete = new JToggleButton("Delete");
		tglbtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlDrawing.delete();
			}
		});
		buttonGroup.add(tglbtnDelete);
		GridBagConstraints gbc_tglbtnDelete = new GridBagConstraints();
		gbc_tglbtnDelete.gridx = 8;
		gbc_tglbtnDelete.gridy = 0;
		pnlSouth.add(tglbtnDelete, gbc_tglbtnDelete);
		
		pnlDrawing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Shape sh;
				Point clickPoint = new Point(e.getX(), e.getY());
				
				if(tglbtnPoint.isSelected())
				{
					DlgPoint dialogPoint = new DlgPoint();
					dialogPoint.getTxtXCoordinate().setText(Integer.toString(e.getX()));
					dialogPoint.getTxtXCoordinate().setEditable(false);
					dialogPoint.getTxtYCoordinate().setText(Integer.toString(e.getY()));
					dialogPoint.getTxtYCoordinate().setEditable(false);
					dialogPoint.setVisible(true);
					
					if(dialogPoint.isOkay())
					{
						// Color colorPoint = new Color();
					   sh = new Point(e.getX(), e.getY(), dialogPoint.getBtnBorderColor().getBackground());
					   pnlDrawing.addShape(sh);
					}
					
				}
				
				if(tglbtnLine.isSelected())
				{
					if(firstClickPoint)
					{
						sparePoint=clickPoint;
						firstClickPoint=false;		
					}
					else
					{
						DlgLine dialogLine = new DlgLine();
						dialogLine.getTxtXStart().setText(Integer.toString(sparePoint.getX()));
						dialogLine.getTxtXStart().setEditable(false);
						dialogLine.getTxtYStart().setText(Integer.toString(sparePoint.getY()));
						dialogLine.getTxtYStart().setEditable(false);
						dialogLine.getTxtXEnd().setText(Integer.toString(clickPoint.getX()));
						dialogLine.getTxtXEnd().setEditable(false);
						dialogLine.getTxtYEnd().setText(Integer.toString(clickPoint.getY()));
						dialogLine.getTxtYEnd().setEditable(false);
						dialogLine.setVisible(true);
						if(dialogLine.isOkay())
						{
						//Color colorLine = dialogLine.getColor();
						sh = new Line(new Point(sparePoint.getX(), sparePoint.getY()), new Point(clickPoint.getX(), clickPoint.getY()), dialogLine.getBtnBorderColor().getBackground());
						pnlDrawing.addShape(sh);
						}
						firstClickPoint = true;
					}
				}
				
				if(tglbtnRectangle.isSelected())
				{
					DlgRectangle dialogRectangle = new DlgRectangle();
					dialogRectangle.getTxtXCoordinate().setText(Integer.toString(clickPoint.getX()));
					dialogRectangle.getTxtXCoordinate().setEditable(false);
					dialogRectangle.getTxtYCoordinate().setText(Integer.toString(clickPoint.getY()));
					dialogRectangle.getTxtYCoordinate().setEditable(false);
					dialogRectangle.setVisible(true);
					int width = Integer.parseInt(dialogRectangle.getTxtWidth().getText());
					int height = Integer.parseInt(dialogRectangle.getTxtHeight().getText());
					if(dialogRectangle.isOkay())
					{
					sh= new Rectangle(new Point(clickPoint.getX(),clickPoint.getY()), width, height ,dialogRectangle.getBtnBorderColor().getBackground(), dialogRectangle.getBtnInnerColor().getBackground());
					pnlDrawing.addShape(sh);
					}
				}
				
				
				if(tglbtnCircle.isSelected())
				{
					DlgCircle dialogCircle = new DlgCircle();
					dialogCircle.getTxtCenterX().setText(Integer.toString(clickPoint.getX()));
					dialogCircle.getTxtCenterX().setEditable(false);
					dialogCircle.getTxtCenterY().setText(Integer.toString(clickPoint.getY()));
					dialogCircle.getTxtCenterY().setEditable(false);
					dialogCircle.setVisible(true);
					int radius = Integer.parseInt(dialogCircle.getTxtRadius().getText());
					if(dialogCircle.isOkay())
					{
	                sh = new Circle(new Point(e.getX(),e.getY()), radius, dialogCircle.getBtnBorderColor().getBackground(), dialogCircle.getBtnInnerColor().getBackground());
					pnlDrawing.addShape(sh);
					}
				}
				
				if(tglbtnDonut.isSelected())
				{
					DlgDonut dialogDonut = new DlgDonut();
					dialogDonut.getTxtCenterX().setText(Integer.toString(clickPoint.getX()));
					dialogDonut.getTxtCenterX().setEditable(false);
					dialogDonut.getTxtYCentre().setText(Integer.toString(clickPoint.getY()));
					dialogDonut.getTxtYCentre().setEditable(false);
					dialogDonut.setVisible(true);
   					int donutRadius = Integer.parseInt(dialogDonut.getTxtRadius().getText());
					int donutInnerRadius = Integer.parseInt(dialogDonut.getTxtInnerRadius().getText());
					if(dialogDonut.isOkay())
					{
					sh = new Donut(new Point(clickPoint.getX(),clickPoint.getY()), donutRadius, donutInnerRadius, dialogDonut.getBtnBorderColor().getBackground(), dialogDonut.getBtnInnerColor().getBackground());
					pnlDrawing.addShape(sh);
					}			
				}
				if(tglbtnSelect.isSelected())
				{
					Point p = new Point (e.getX(), e.getY());
				    pnlDrawing.selected(p.getX(), p.getY());
				}
				
			}
		});
		contentPane.add(pnlDrawing, BorderLayout.CENTER);
		
		
	}

}
