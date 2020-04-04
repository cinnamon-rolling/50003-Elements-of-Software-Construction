import unittest
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.chrome.options import Options


class Search(unittest.TestCase):

    def setUp(self):
        option = Options()
        option.headless = True
        self.driver = webdriver.Chrome(chrome_options=option)

    def test_1(self):
        driver = self.driver
        driver.get("https://statcounter.com/login/")
        try:
            title = driver.title
            return True
        except:
            return False

    def test_1(self):
        driver = self.driver
        driver.get("https://")  # fill in wepage URL
        try:
            title = driver.title
            return True
        except:
            return False

    def tearDown(self):
        self.driver.close()


if __name__ == "__main__":
    unittest.main()
