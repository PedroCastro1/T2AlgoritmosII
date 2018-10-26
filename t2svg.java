import java.util.Scanner;
public class t2svg{

  private static Scanner in = new Scanner(System.in);

  public static void svgline (int x1, int y1, int x2, int y2) {
    System.out.printf(" <polyline points=\"%d,%d %d,%d\"/>\n", x1, y1, x2, y2);
  }

  public static void process (int w, int h) {

    int N = 8;
    int L = 4;
    int S = 2;
    int O = 1;

    int l = 0;
    int c = 0;

    while(true) {

      if (!in.hasNext()) return; 
      char t = in.next().charAt(0);

      switch (t) {
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9': t -= '0'; break;
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f': t = (char) (t - 'a' + 10); break;
        default: continue;
      }

      if ((t & N) == N) svgline(c, l , c + 1, l); 
      if ((t & S) == S) svgline(c, l + 1, c + 1, l + 1);
      if ((t & O) == O) svgline(c , l , c , l + 1); 
      if ((t & L) == L) svgline(c + 1, l , c + 1, l + 1);

      c++;
      if (c == w) {
        c = 0;
        l++;
      }
    }
  }

  public static void main (String[] args) {

    int w, h;

    h = in.nextInt();
    w = in.nextInt();

    System.out.println( "<?xml version=\"1.0\" standalone=\"no\"?>" );
    System.out.printf ( "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"%dcm\" height=\"%dcm\" viewBox=\"-0.1 -0.1 %f %f\">", w, h, w+0.2, h+0.2 );
    System.out.println( "<g style=\"stroke-width:.1; stroke:black; stroke-linejoin:miter; stroke-linecap:butt; \">" );

    process(w, h);

  // Ex: gerando circulos no labirinto
    System.out.println("<circle cx=\"11.5\" cy=\"0.5\" r=\"0.2\" stroke=\"red\" fill=\"red\" />");
    System.out.println("<circle cx=\"12.5\" cy=\"0.5\" r=\"0.2\" stroke=\"red\" fill=\"red\" />");
    System.out.println("<circle cx=\"13.5\" cy=\"0.5\" r=\"0.2\" stroke=\"red\" fill=\"red\" />");

  // Finaliza
    System.out.print("</g>");
    System.out.print("</svg>");
  }
} 
