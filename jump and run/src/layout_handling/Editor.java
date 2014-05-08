package layout_handling;

import java.awt.BorderLayout;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

public class Editor implements Handler_Layout {
	public Loader_Layout ll;
	JFrame frame;
	JPanel contentPane;

	public Editor(Loader_Layout ll) {
		this.ll = ll;
		next.set("null");
		frame = new JFrame();
		frame.setTitle("Editor");
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 800, 600);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JButton btnSpeichern = new JButton("Speichern");
		menuBar.add(btnSpeichern);

		JButton btnNeu = new JButton("Neu");
		menuBar.add(btnNeu);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);

		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.WEST);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		toolBar.add(tabbedPane);
		tabbedPane.addTab("Fordergrund", null);
		tabbedPane.addTab("Hintergrund", null);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@Override
	public void update() {

	}

	@Override
	public void draw(Graphics2D g) {

	}
}
