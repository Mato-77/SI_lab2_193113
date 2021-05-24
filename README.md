**Втора лабораториска вежба по Софтверско инженерство**


**Мартин Николов, бр. на индекс 193113**


**1. Control Flow Graph**

![alt text](https://github.com/Mato-77/SI_lab2_193113/blob/7fe0ceca417c7423a418f19fe4d36ee8219f8ddf/CSP%20-%20graf.png)

**2. Цикломатска комплексност**
	
	Цикломатска комплексност изнесува 8 и е добиена од формулата P + 1, каде P претставува број  на предикатни јазли,
	што во овој случај P=7.

**3. Тест случаи според критериумите Multiple condition и Every branch**
	
      	3.1 TimeList.add( new Time(-10, 15, 20)) 

	3.2 TimeList.add( new Time(26, 20, 10))

	3.3 TimeList.add( new Time(15,60,10)) 

	3.4 TimeList.add(  new Time(10,-1,15) )

	3.5 timeList.add(new Time(13, 12, 60))

	3.6 timeList.add(new Time(12,20,-10))

	3.7 timeList.add(new Time(24,0,12))

	3.8 timeList.add(new Time(24,12,0))

	3.9 	
		listTime.add(new Time(24 ,0 ,0));
        	listTime.add(new Time(23,15,20) );

**5. Објаснување на напишаните unit tests**

	Дефинирав 2 функции за 2те методи на тестирање и над нив напишав @Test анотација
	 Во методата multipleConditionTest декларирав објект од класата RuntimeException и со помош на assertThrows тестирав дали ќе фрли соодветен исклучок. 
	 Потоа assertEquals проверував дали пораката на фрлениот исклучок е соодветна со пораката која очекуваниот исклучок   треба да  ја испечати, за да се потврди дека фрлениот исклучок е очекуваниот.
	Во методата everyBranchTest го искористив assertEquals за проверка единствениот тест случај во таа метода
	
