package guiProjekt;

import util.Util;

import javax.swing.*;
import java.awt.*;

public class ArrayPanel extends JPanel{
    private static final String uiClassID = "ArrayPanelProjekt";
    private int[] array;
    private int maxValue;

    public ArrayPanel() {
        this(new int[]{3,214,24,2,2,2,4,4,4,6, 6, 12, 8, 3, 78, 3, 5});
    }

    public ArrayPanel(int[] array) {
        super(true);
        setPreferredSize(new Dimension(200, 200));
        setArray(array);
    }

    public void setArray(int[] array) {
        this.array = array;
        maxValue = array[0];
        for (int e : array) {
            maxValue = Math.max(maxValue, e);
        }

        repaint();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void swap(int i, int j) {
        Util.swap(array, i, j);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Rectangle r = g.getClipBounds();

        double colWidth = r.width / (double) array.length;
        g.setColor(Color.BLUE);

        for (int i = 0; i < array.length; i++) {
            int hoehe;
            if (maxValue != 0) {
                hoehe = array[i] * r.height / maxValue;
            } else {
                hoehe = 0;
            }
            g.fillRect(r.x + (int) Math.round(i * colWidth), r.y + r.height - hoehe, (int) Math.round(colWidth), hoehe);
        }

        g.setColor(Color.BLACK);
        g.drawRect(r.x, r.y, r.width - 1, r.height - 1);
    }
}
