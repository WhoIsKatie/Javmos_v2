package main.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.LinkedList;
import main.JavmosGUI;
import main.components.JavmosComponent;
import main.components.Point;
import main.enums.RootType;

public class PointClickListener implements MouseListener {

    private final JavmosGUI gui;
    private final HashSet<Point> points;

    public PointClickListener(JavmosGUI gui) {
        this.gui = gui;
        this.points = new HashSet<>();
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        if (points != null) {
            for (Point point : points) {
                if (point.getPoint().contains(event.getX(), event.getY())) {
                    gui.setPointLabel(point.toString(), point.getRootType());
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent event) {
        // Not needed!
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        // Not needed!
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        // Not needed!
    }

    @Override
    public void mouseExited(MouseEvent event) {
        // Not needed!
    }

    public void setPoints(Point point) {
        if (points != null) {
            points.add(point);
        } else {
            this.points.clear();
        }
    }

    public void removePoints() {
        points.clear();
    }
}