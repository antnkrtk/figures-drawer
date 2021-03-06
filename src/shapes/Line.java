package shapes;

import asbtract.Shape;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import interfaces.Editable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

@XStreamAlias("line")
public class Line extends Shape implements Editable {

    public Line() {}

    public Line(Point startPoint, Point endPoint) {
        addPoint(startPoint);
        addPoint(endPoint);
    }

    @Override
    public void setColor(Color color) {
        borderColor = color;
    }

    @Override
    public void setLineWidth(int width) {
        lineWidth = width;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(borderColor);
        gc.setLineWidth(lineWidth);
        gc.strokeLine(points.get(0).x, points.get(0).y, points.get(1).x, points.get(1).y);
    }

    @Override
    public void drawBorder(GraphicsContext gc) {
        gc.setStroke(Color.RED);
        gc.setLineWidth(3);
        gc.strokeLine(points.get(0).x, points.get(0).y, points.get(1).x, points.get(1).y);
    }

    @Override
    public void refreshFigure(Point point) {
        if (points.size() > 1) {
            points.remove(points.size() - 1);
            addPoint(point);
        } else {
            addPoint(point);
        }
    }
}
