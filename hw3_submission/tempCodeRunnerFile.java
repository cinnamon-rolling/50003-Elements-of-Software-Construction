cal1.setTime(new Date());
		Thread.sleep(1000);
		Calendar cal2 = new CalendarSubclass();
		cal2.setTime(new Date());
		System.out.println(cal2.after(cal1));
		System.out.println(cal1.after(cal2));
		System.out.println(cal1.after(cal1));
		System.out.println(cal2.after(cal2));