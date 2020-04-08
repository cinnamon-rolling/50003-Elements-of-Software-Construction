int main()
{
    int x;

    /* declare the memory region occupied by 
    * variable "x" to be symbolic */

    /* This means the program will be executed 
    * with uninstantiated, i.e., symbolic 
    * values of x */
    klee_make_symbolic(&x, sizeof(x), "x");

    /* do some computations */
    if (x < 10)
    {
        x++;
        if (x > 5)
        {
            x = x - 1;
            if (x < 3)
            {
                x++;
            }
            else
            {
                x--;
            }
        }
        else
        {
            x--;
        }
    }
    else
    {
        x--;
    }
}
