import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.KeyListener;

public class Boards extends JPanel
{
    int[][] table;

    int fall;
    int position = 1;
    Timer timer = new Timer();
    int blockx = 4;
    int blocky = 0;
    int speed = 1000;
    boolean leftedge = false;
    boolean rightedge = false;
    int pr = 0;
    int pl = 0;
    public void start()
    {
        table = new int[10][25];

        //sets a base to build onto
        for(int x=0;x<10;x++)
        {
            table[x][24] = 1;
        }
        newPiece();
        setFocusable(true);

        addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode() == KeyEvent.VK_LEFT && getLeft() != 0)
                {
                        if (rightedge == true)
                            rightedge = false;
                        for (int y = 24; y >= 0; y--)
                        {
                            for (int x = 0; x <= 9; x++)
                            {
                                if (table[x][y] == 2)
                                {

                                        table[x - 1][y] = 2;
                                        table[x][y] = 0;
                                        leftedge = true;

                                }
                            }
                        }
                        blockx--;
                        repaint();

                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT && getRight() !=9)
                {
                        if (leftedge == true)
                            leftedge = false;
                        for (int y = 24; y >= 0; y--)
                        {
                            for (int x = 9; x >= 0; x--)
                            {

                                if (table[x][y] == 2)
                                {

                                        table[x + 1][y] = 2;
                                        table[x][y] = 0;

                                        rightedge = true;

                                }
                            }
                        }
                        blockx++;
                        repaint();

                }
                if(e.getKeyCode() == KeyEvent.VK_UP)
                {
                    for (int y = 24; y >= 0; y--)
                    {
                        for (int x = 9; x >= 0; x--)
                        {

                            if (table[x][y] == 2)
                            {

                                table[x][y] = 0;

                            }
                        }
                    }
                    if (fall == 1)
                    {
                        if (position == 1)
                        {
                            if (table[blockx - 1][blocky] == 0)
                            {
                                table[blockx + 1][blocky] = 2;
                                table[blockx + 2][blocky] = 2;
                                table[blockx + 2][blocky - 1] = 2;
                                table[blockx + 1][blocky + 1] = 2;

                                position = 2;
                            } else if (table[blockx + 1][blocky] == 9)
                            {
                                table[blockx - 1][blocky] = 2;
                                table[blockx][blocky] = 2;
                                table[blockx][blocky - 1] = 2;
                                table[blockx - 1][blocky + 1] = 2;
                                position = 2;
                            } else
                            {
                                table[blockx][blocky] = 2;
                                table[blockx + 1][blocky] = 2;
                                table[blockx + 1][blocky - 1] = 2;
                                table[blockx][blocky + 1] = 2;
                                position = 2;
                            }
                            blocky += 1;

                        } else if (position == 2)
                        {
                            blocky -= 1;
                            table[blockx][blocky] = 2;
                            table[blockx + 1][blocky] = 2;
                            table[blockx - 1][blocky - 1] = 2;
                            table[blockx][blocky - 1] = 2;
                            position = 1;

                        }
                    }
                    else if (fall == 2)
                    {
                        if (position == 1)
                        {
                            if (table[blockx - 1][blocky] == 0)
                            {
                                table[blockx+1][blocky] = 2;
                                table[blockx+1][blocky + 1] = 2;
                                table[blockx ][blocky] = 2;
                                table[blockx ][blocky - 1] = 2;

                                position = 2;
                            } else if (table[blockx + 1][blocky] == 9)
                            {
                                table[blockx-1][blocky] = 2;
                                table[blockx-1][blocky + 1] = 2;
                                table[blockx - 2][blocky] = 2;
                                table[blockx - 2][blocky - 1] = 2;
                                position = 2;
                            } else
                            {
                                if(table[blockx][blocky] == 0)
                                {
                                    table[blockx+1][blocky] = 2;
                                    table[blockx+1][blocky + 1] = 2;
                                    table[blockx][blocky] = 2;
                                    table[blockx][blocky - 1] = 2;
                                    position = 2;
                                }
                                if(table[blockx+1][blocky] == 9)
                                {
                                    table[blockx-1][blocky] = 2;
                                    table[blockx-1][blocky + 1] = 2;
                                    table[blockx - 2][blocky] = 2;
                                    table[blockx - 2][blocky - 1] = 2;
                                    position = 2;
                                }
                                else{
                                table[blockx][blocky] = 2;
                                table[blockx][blocky + 1] = 2;
                                table[blockx - 1][blocky] = 2;
                                table[blockx - 1][blocky - 1] = 2;
                                position = 2;
                            }
                            }
                            blocky += 1;

                        } else if (position == 2)
                        {
                            if(table[blockx - 1][blocky] == 0)
                            {
                                blocky -= 1;
                                table[blockx+1][blocky] = 2;
                                table[blockx + 2][blocky-1] = 2;
                                table[blockx +1][blocky - 1] = 2;
                                table[blockx][blocky ] = 2;
                                position = 1;
                            }
                            if(table[blockx][blocky] == 9)
                            {
                                blocky -= 1;
                                table[blockx-1][blocky] = 2;
                                table[blockx ][blocky-1] = 2;
                                table[blockx -1][blocky - 1] = 2;
                                table[blockx-2][blocky ] = 2;
                                position = 1;
                            }
                            else
                            {
                                blocky -= 1;
                                table[blockx][blocky] = 2;
                                table[blockx + 1][blocky-1] = 2;
                                table[blockx ][blocky - 1] = 2;
                                table[blockx-1][blocky ] = 2;
                                position = 1;
                            }


                        }
                    }
                    else if (fall == 3)
                    {
                        if (position == 1)
                        {
                            if (table[blockx][blocky] == 0)
                            {
                                table[blockx+1][blocky] = 2;
                                table[blockx][blocky] = 2;
                                table[blockx -1][blocky] = 2;
                                table[blockx +2][blocky] = 2;

                                position = 2;
                            } else if (table[blockx][blocky] == 9)
                            {
                                table[blockx-1][blocky] = 2;
                                table[blockx-2][blocky ] = 2;
                                table[blockx - 3][blocky] = 2;
                                table[blockx][blocky] = 2;
                                position = 2;
                            } else
                            {
                                table[blockx][blocky] = 2;
                                table[blockx-1][blocky] = 2;
                                table[blockx - 2][blocky] = 2;
                                table[blockx + 1][blocky ] = 2;
                                position = 2;
                            }
                            blocky += 1;

                        } else if (position == 2)
                        {

                            blocky -= 1;
                            table[blockx][blocky] = 2;
                            table[blockx][blocky - 1] = 2;
                            table[blockx][blocky - 2] = 2;
                            table[blockx][blocky - 3] = 2;
                            position = 1;

                        }
                    }
                    else if (fall == 4)
                    {
                        if (position == 1)
                        {
                            if (table[blockx - 1][blocky] == 0)
                            {
                                table[blockx+1][blocky] = 2;
                                table[blockx+1][blocky + 1] = 2;
                                table[blockx ][blocky] = 2;
                                table[blockx ][blocky - 1] = 2;

                                position = 2;
                            } else if (table[blockx + 1][blocky] == 9)
                            {
                                table[blockx-1][blocky] = 2;
                                table[blockx-1][blocky + 1] = 2;
                                table[blockx - 2][blocky] = 2;
                                table[blockx - 2][blocky - 1] = 2;
                                position = 2;
                            } else
                            {
                                table[blockx][blocky] = 2;
                                table[blockx][blocky + 1] = 2;
                                table[blockx - 1][blocky] = 2;
                                table[blockx - 1][blocky - 1] = 2;
                                position = 2;
                            }
                            blocky += 1;

                        } else if (position == 2)
                        {
                            blocky -= 1;
                            table[blockx][blocky] = 2;
                            table[blockx + 1][blocky-1] = 2;
                            table[blockx ][blocky - 1] = 2;
                            table[blockx-1][blocky ] = 2;
                            position = 1;

                        }
                    }
                    else if (fall == 6)
                    {
                        if (position == 1)
                        {
                            if (table[blockx - 1][blocky] == 0)
                            {
                                table[blockx+1][blocky] = 2;
                                table[blockx+1][blocky + 1] = 2;
                                table[blockx ][blocky] = 2;
                                table[blockx ][blocky - 1] = 2;

                                position = 2;
                            } else if (table[blockx + 1][blocky] == 9)
                            {
                                table[blockx-1][blocky] = 2;
                                table[blockx-1][blocky + 1] = 2;
                                table[blockx - 2][blocky] = 2;
                                table[blockx - 2][blocky - 1] = 2;
                                position = 2;
                            } else
                            {
                                table[blockx][blocky] = 2;
                                table[blockx][blocky + 1] = 2;
                                table[blockx - 1][blocky] = 2;
                                table[blockx - 1][blocky - 1] = 2;
                                position = 2;
                            }
                            blocky += 1;

                        } else if (position == 2)
                        {
                            blocky -= 1;
                            table[blockx][blocky] = 2;
                            table[blockx + 1][blocky-1] = 2;
                            table[blockx ][blocky - 1] = 2;
                            table[blockx-1][blocky ] = 2;
                            position = 1;

                        }
                    }
                    else if (fall == 7)
                    {
                        if (position == 1)
                        {
                            if (table[blockx - 1][blocky] == 0)
                            {
                                table[blockx+1][blocky] = 2;
                                table[blockx+1][blocky + 1] = 2;
                                table[blockx ][blocky] = 2;
                                table[blockx ][blocky - 1] = 2;

                                position = 2;
                            } else if (table[blockx + 1][blocky] == 9)
                            {
                                table[blockx-1][blocky] = 2;
                                table[blockx-1][blocky + 1] = 2;
                                table[blockx - 2][blocky] = 2;
                                table[blockx - 2][blocky - 1] = 2;
                                position = 2;
                            } else
                            {
                                table[blockx][blocky] = 2;
                                table[blockx][blocky + 1] = 2;
                                table[blockx - 1][blocky] = 2;
                                table[blockx - 1][blocky - 1] = 2;
                                position = 2;
                            }
                            blocky += 1;

                        } else if (position == 2)
                        {
                            blocky -= 1;
                            table[blockx][blocky] = 2;
                            table[blockx + 1][blocky-1] = 2;
                            table[blockx ][blocky - 1] = 2;
                            table[blockx-1][blocky ] = 2;
                            position = 1;

                        }
                    }
                }
                repaint();
            }


            public void keyReleased(KeyEvent e) {

            }

            public void keyTyped(KeyEvent e) { /* ... */ }
        });

        timer.schedule(new TimerTask()
        {
            int counter = 0;


            @Override
            public void run()
            {

                    for (int y = 24; y >= 0; y--)
                    {
                        for (int x = 9; x >= 0; x--)
                        {
                            if (table[x][y] == 2)
                            {
                                if(table[x][y+1] == 1)
                                {
                                    for (int a = 24; a >= 0; a--)
                                    {
                                        for (int b = 9; b >= 0; b--)
                                        {
                                            if (table[b][a] == 2)
                                            {
                                                table[b][a] = 1;
                                            }
                                        }
                                    }
                                    blockx=4;
                                    blocky=0;
                                    leftedge=false;
                                    rightedge=false;
                                    newPiece();
                                }
                                else
                                {
                                    table[x][y + 1] = 2;
                                    table[x][y] = 0;
                                }
                            }
                        }
                    }
                    blocky++;



                repaint();
            }
        }, 0, speed);




    }
    public void newPiece()
    {
        fall = 3;//Shapes.randomPiece();
        if(fall ==1 )
        {
            table[blockx][blocky] = 2;
            table[blockx-1][blocky] = 2;
            table[blockx][blocky+1] = 2;
            table[blockx+1][blocky+1] = 2;
            blocky ++;
            blockx--;
            pr = 1;
            pl = 1;
        }
        if(fall ==2 )
        {
            table[blockx][blocky] = 2;
            table[blockx][blocky+1] = 2;
            table[blockx+1][blocky] = 2;
            table[blockx-1][blocky+1] = 2;
            blocky ++;
        }
        if(fall ==3 )
        {
            table[blockx][blocky] = 2;
            table[blockx][blocky+1] = 2;
            table[blockx][blocky+2] = 2;
            table[blockx][blocky+3] = 2;
            blocky += 3;

        }
        if(fall ==4 )
        {
            table[blockx][blocky] = 2;
            table[blockx][blocky+1] = 2;
            table[blockx+1][blocky+1] = 2;
            table[blockx-1][blocky+1] = 2;
            blocky++;
        }
        if(fall ==5 )
        {
            table[blockx][blocky] = 2;
            table[blockx][blocky+1] = 2;
            table[blockx+1][blocky] = 2;
            table[blockx+1][blocky+1] = 2;
            blocky++;
        }
        if(fall ==6 )
        {
            table[blockx][blocky] = 2;
            table[blockx][blocky+1] = 2;
            table[blockx][blocky+2] = 2;
            table[blockx+1][blocky+2] = 2;
            blocky+=2;
        }
        if(fall ==7 )
        {
            table[blockx][blocky] = 2;
            table[blockx][blocky+1] = 2;
            table[blockx][blocky+2] = 2;
            table[blockx-1][blocky+2] = 2;
            blocky+=2;
        }
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        //paints board if its red or grey
        super.paintComponent(g);
        for( int y = 0;y < 24;y++)
        {
            for(int x=0;x<10;x++)
            {
                if(table[x][y] == 1)
                {
                    g.setColor(Color.GRAY);
                    g.fillRect((x+1)*20,(y+1)*20,20,20);

                }
                if(table[x][y] == 2)
                {
                    g.setColor(Color.RED);
                    g.fillRect((x+1)*20,(y+1)*20,20,20);
                }
            }
        }
    }
    public int getLeft()
    {
        int left = 11;
        for (int y = 24; y >= 0; y--)
        {
            for (int x = 9; x >= 0; x--)
            {
                if (table[x][y] == 2 && x < left)
                {

                    left = x;

                }
            }
        }
        return left;
    }public int getRight()
{
    int right = -1;
    for (int y = 24; y >= 0; y--)
    {
        for (int x = 9; x >= 0; x--)
        {
            if (table[x][y] == 2 && x > right)
            {

                right = x;

            }
        }
    }

    return right;
}
}


