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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		
		PnlDrawing pnlDrawing = new PnlDrawing();
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
					   sh = new Point(e.getX(), e.getY(), dialogPoint.getColor());
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
						sh = new Line(new Point(sparePoint.getX(), sparePoint.getY()), new Point(clickPoint.getX(), clickPoint.getY()), dialogLine.getColor());
						pnlDrawing.addShape(sh);
						}
						firstClickPoint = true;
					}
				}
				
				if(tglbtnRectangle.isSelected())
				{
					DlgRectangle dialogRectangle = new DlgRectangle();
					int width = Integer.parseInt(dialogRectangle.getTxtWidth().getText());
					int height = Integer.parseInt(dialogRectangle.getTxtHeight().getText());
					sh= new Rectangle(new Point(e.getX(),e.getY()), width, height);
					//drawing.addShape(sh);
				}
				
				
				if(tglbtnCircle.isSelected())
				{
					DlgCircle dialogCircle = new DlgCircle();
					int radius = Integer.parseInt(dialogCircle.getTxtRadius().getText());
					sh = new Circle(new Point(e.getX(),e.getY()), radius);
				}
				
				if(tglbtnDonut.isSelected())
				{
					DlgDonut dialogDonut = new DlgDonut();
   					int donutRadius = Integer.parseInt(dialogDonut.getTxtRadius().getText());
					int donutInnerRadius = Integer.parseInt(dialogDonut.getTxtInnerRadius().getText());
					
					sh = new Donut(new Point(e.getX(),e.getY()), donutRadius, donutInnerRadius, true);
					
				}
				
				
			}
		});
		contentPane.add(pnlDrawing, BorderLayout.CENTER);
		
		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlSouth = new GridBagLayout();
		gbl_pnlSouth.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlSouth.rowHeights = new int[]{0, 0};
		gbl_pnlSouth.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlSouth.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlSouth.setLayout(gbl_pnlSouth);
		
		JButton btnSelect = new JButton("Select");
		GridBagConstraints gbc_btnSelect = new GridBagConstraints();
		gbc_btnSelect.insets = new Insets(0, 0, 0, 5);
		gbc_btnSelect.gridx = 4;
		gbc_btnSelect.gridy = 0;
		pnlSouth.add(btnSelect, gbc_btnSelect);
		
		JButton btnModify = new JButton("Modify");
		GridBagConstraints gbc_btnModify = new GridBagConstraints();
		gbc_btnModify.insets = new Insets(0, 0, 0, 5);
		gbc_btnModify.gridx = 6;
		gbc_btnModify.gridy = 0;
		pnlSouth.add(btnModify, gbc_btnModify);
		
		JButton btnDelete = new JButton("Delete");
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.gridx = 8;
		gbc_btnDelete.gridy = 0;
		pnlSouth.add(btnDelete, gbc_btnDelete);
	}

}
