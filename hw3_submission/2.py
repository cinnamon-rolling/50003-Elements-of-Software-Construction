import unittest
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.chrome.options import Options


class Search(unittest.TestCase):

    def setUp(self):
        option = Options()
        option.headless = True
        self.driver = webdriver.Chrome(chrome_options=option)

    # normal testing
    def test_1(self):
        driver = self.driver
        driver.get("https://statcounter.com/login/")
        username = driver.find_element_by_id("username")
        password = driver.find_element_by_id("password")

        username.send_keys("YourUsername")
        password.send_keys("Pa55worD")

        driver.find_element_by_class_name("submit").click()

    # test for regex match whether it will return weird value
    def test_2(self):
        driver = self.driver
        driver.get("https://statcounter.com/login/")
        username = driver.find_element_by_id("username")
        password = driver.find_element_by_id("password")

        username.send_keys("^username$")
        password.send_keys("^password$")

        driver.find_element_by_class_name("submit").click()

    # tet for empty username and password
    def test_3(self):
        driver = self.driver
        driver.get("https://statcounter.com/login/")
        username = driver.find_element_by_id("username")
        password = driver.find_element_by_id("password")

        username.send_keys("")
        password.send_keys("")

        driver.find_element_by_class_name("submit").click()

    # test for long strings of username and password
    def test_4(self):
        driver = self.driver
        driver.get("https://statcounter.com/login/")
        username = driver.find_element_by_id("username")
        password = driver.find_element_by_id("password")

        username.send_keys("1"*100)
        password.send_keys("2"*100)

        driver.find_element_by_class_name("submit").click()

    def tearDown(self):
        self.driver.close()


if __name__ == "__main__":
    unittest.main()
