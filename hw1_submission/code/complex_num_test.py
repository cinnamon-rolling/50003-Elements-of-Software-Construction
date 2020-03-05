import pytest
from complex_num import ComplexNumber


class TestComplexNumber:
    c1 = ComplexNumber(1, 1)
    c2 = ComplexNumber(0, 0)

    def test_addition(self):
        assert str(self.c1 + self.c2) == str(ComplexNumber(1, 1))

    def test_subtraction(self):
        assert str(self.c1 - self.c2) == str(ComplexNumber(1, 1))

    def test_multiplication(self):
        assert str(self.c1 * self.c2) == str(ComplexNumber(0, 0))

    def test_division(self):
        with pytest.raises(ZeroDivisionError):
            self.c1 / self.c2


class TestComplexNumber2:
    c1 = ComplexNumber(5, 10)
    c2 = ComplexNumber(2, -1)

    def test_addition(self):
        assert str(self.c1 + self.c2) == str(ComplexNumber(7, 9))

    def test_subtraction(self):
        assert str(self.c1 - self.c2) == str(ComplexNumber(3, 11))

    def test_multiplication(self):
        assert str(self.c1 * self.c2) == str(ComplexNumber(20, 15))

    def test_division(self):
        assert str(self.c1 / self.c2) == str(ComplexNumber(0.0, 5.0))
