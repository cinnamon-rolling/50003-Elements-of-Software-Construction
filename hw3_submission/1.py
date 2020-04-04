import unittest
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.chrome.options import Options
import time


class Search(unittest.TestCase):

    def setUp(self):
        option = Options()
        option.headless = False
        self.driver = webdriver.Chrome(chrome_options=option)

    # normal testing
    def test_1(self):
        driver = self.driver
        driver.get("https://istd.sutd.edu.sg/")

        elems = driver.find_elements_by_xpath("//a[@href]")

        for elem in elems:
            print(elem)
            my_href = elem.get_attribute("href")
            # open in new window
            driver.execute_script("window.open('" + my_href + "');")
            time.sleep(10)  # sleep for 10s else open window too fast

    def tearDown(self):
        self.driver.close()


if __name__ == "__main__":
    unittest.main()
