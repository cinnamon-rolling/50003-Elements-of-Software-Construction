class ComplexNumber:
    def __init__(self, input_re=0.0, input_im=0.0):
        self.input_re = input_re
        self.input_im = input_im

    def __str__(self):
        return f"{self.input_re, self.input_im}"

    def __add__(self, other):
        input_re = self.input_re + other.input_re
        input_im = self.input_im + other.input_im
        return ComplexNumber(input_re, input_im)

    def __sub__(self, other):
        input_re = self.input_re - other.input_re
        input_im = self.input_im - other.input_im
        return ComplexNumber(input_re, input_im)

    def __mul__(self, other):
        input_re = (self.input_re * other.input_re) - \
            (self.input_im * other.input_im)
        input_im = (self.input_re * other.input_im) + \
            (self.input_im * other.input_re)
        return ComplexNumber(input_re, input_im)

    def __truediv__(self, other):
        input_re = ((self.input_re * other.input_re) + (self.input_im *
                                                        other.input_im))/((other.input_re**2) + (other.input_im**2))
        input_im = ((self.input_im * other.input_re) - (self.input_re *
                                                        other.input_im))/((other.input_re**2) + (other.input_im**2))
        return ComplexNumber(input_re, input_im)


if __name__ == "__main__":
    c1__re_input = int(input("Please enter input for real part of c1:\n"))
    c1__im_input = int(input("Please enter input for imaginary part of c1:\n"))

    c1 = ComplexNumber(c1__re_input, c1__im_input)

    c2__re_input = int(input("Please enter input for real part of c2:\n"))
    c2__im_input = int(input("Please enter input for imaginary part of c2:\n"))

    c2 = ComplexNumber(c2__re_input, c2__im_input)

    print("Your answer for addition is: ", c1 + c2)
    print("Your answer for subtraction is: ", c1 - c2)
    print("Your answer for multiplication is: ", c1 * c2)
    print("Your answer for division is: ", c1 / c2)
