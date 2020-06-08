interface VisualComponent{
    public void draw();
}

class TextView implements VisualComponent{
    public void draw(){
        System.out.println("draw a TextView");
    }
}

class PdfView implements VisualComponent{
    public void draw(){
        System.out.println("draw a PdfView");
    }
}

abstract class Decorator implements VisualComponent{
    protected VisualComponent vs;

    public Decorator(VisualComponent vs){
        this.vs=vs;
    }
}

class ScrollDecorator extends Decorator{

    public ScrollDecorator(VisualComponent vs){
        super(vs);
    }

    public void draw(){
        this.vs.draw();
        System.out.println("add ascroll decorator");
    }
}

class BorderDecorator extends Decorator{

    public BorderDecorator(VisualComponent vs){
        super(vs);
    }

    public void draw(){
        this.vs.draw();
        System.out.println("add aborder decorator");
    }
}

class ShadowDecorator extends Decorator{
    
    public ShadowDecorator(VisualComponent vs){
        super(vs);
    }

    public void draw(){
        this.vs.draw();
        System.out.println("add shadow decorator");
    }
}

public class DecoratorVisual{
    public static void main(String[] args){
        VisualComponent vs=new ScrollDecorator(new TextView());
        vs.draw();
        vs=new ScrollDecorator(new BorderDecorator(vs));
        vs.draw();
        vs=new ScrollDecorator(new BorderDecorator(new PdfView()));
        vs.draw();
    } 
}