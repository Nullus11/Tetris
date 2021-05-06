import java.util.Random;

public class Shapes
{
    public static int x;
    public static int y;

    public static int randomPiece()
    {
        Random r = new Random();
        int x = Math.abs(r.nextInt()) % 7 ;
        Shap[] values = Shap.values();
        return x;
    }

    public enum Shap{
        ZPiece(x,y), SPiece(x,y), IPiece(x,y),
        TPiece(x,y), OPiece(x,y), LPiece(x,y), MirroredLPiece(x,y);

        Shap(int xs, int ys)
        {
            x = xs;
            y = ys;
        }


    };
}


