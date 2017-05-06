package ru.olenevody.model;

import org.springframework.stereotype.Service;
import ru.olenevody.Code;

import java.util.ArrayList;
import java.util.List;

@Service
public class Levels {

    private List<Level> levelList = new ArrayList<>();

    public Levels() {

        Level level1 = new Level(1);
        level1.setDescription("У Вас есть 30 минут чтобы переместиться в эту точку: 59.872526, 30.439131<br/>Код закрытия 555");
        level1.setTech(true);
        level1.setImgName("Vru5YuhgYv_s.png");
        level1.setDuration(1800L);
        level1.addCode(new Code("555", Code.KO.KO_NULL));
        levelList.add(level1);

        Level level2 = new Level(2);
        level2.setDescription("" +
                "<ul>" +
                "   <li>Хоть это и пешеходка, а научиться управлять автомобилем стоит</li>" +
                "   <li>Не знаменитая Триумфальная, но все же она</li>" +
                "   <li>Вот крыльцо охрана скат, справа спрятали мы клад</li>" +
                "</ul>");
        level2.setImgName("SIlwBKtcJg_1.png");
        level2.setDuration(420L);
        level2.addCode(new Code("5533", Code.KO.KO_1));
        level2.addCode(new Code("3695", Code.KO.KO_1));
        level2.addCode(new Code("1364", Code.KO.KO_1));
        levelList.add(level2);

        Level level3 = new Level(3);
        level3.setDescription("" +
                "<ul>" +
                "   <li>Транспорт волшебника, который показывает кино и дарит \"Эскимо\"</li>" +
                "   <li>Коль пошли мы по достопримечательностям, то и на колонны надо посмотреть</li>" +
                "   <li>Вот дом, построил его гном, табличка \"Ивановская 24А\", попортили угол в нем</li>" +
                "</ul>");
        level3.setImgName("1SULs1DFvF_2.png");
        level3.setDuration(300L);
        level3.addCode(new Code("5113", Code.KO.KO_1));
        level3.addCode(new Code("3355", Code.KO.KO_1));
        level3.addCode(new Code("4713", Code.KO.KO_1));
        levelList.add(level3);

        Level level4 = new Level(4);
        level4.setDescription("" +
                "<ul>" +
                "   <li>Где \"Сбываются мечты\" (с)</li>" +
                "   <li>Круглый желтый дом, код где-то на нем</li>" +
                "   <li>Вот же щииит… распределительный</li>" +
                "</ul>");
        level4.setImgName("Pi1QBBKF6n_3.png");
        level4.setDuration(300L);
        level4.addCode(new Code("3881", Code.KO.KO_1));
        level4.addCode(new Code("7791", Code.KO.KO_1));
        level4.addCode(new Code("6666", Code.KO.KO_1));
        levelList.add(level4);

        Level level5 = new Level(5);
        level5.setDescription("" +
                "<ul>" +
                "   <li>Если вы подходите к двери, а за ней гудят, то либо там гудят без вас, либо это ОНО!</li>" +
                "   <li>На углу у дома 3 на трубе ты код ищи</li>" +
                "   <li>Я на лавочке сижу, на песочницу гляжу</li>" +
                "</ul>");
        level5.setImgName("rkDUHTs8Ut_4.png");
        level5.setDuration(420L);
        level5.addCode(new Code("7893", Code.KO.KO_1));
        level5.addCode(new Code("3474", Code.KO.KO_1));
        level5.addCode(new Code("1146", Code.KO.KO_1));
        levelList.add(level5);

        Level level6 = new Level(6);
        level6.setDescription("" +
                "<ul>" +
                "   <li>Сдам в ремонт я летние сандали, нужно, чтоб они легко дышали</li>" +
                "   <li>У первых красных зорь я газ себе провел</li>" +
                "   <li>Вот кто-то с горочки спустился... чего же мелкая ты такая</li>" +
                "</ul>");
        level6.setImgName("TJPgUMIzwu_5.png");
        level6.setDuration(360L);
        level6.addCode(new Code("8424", Code.KO.KO_1));
        level6.addCode(new Code("6576", Code.KO.KO_1));
        level6.addCode(new Code("1748", Code.KO.KO_1));
        levelList.add(level6);

        Level level7 = new Level(7);
        level7.setDescription("Перерыв<br/>Код закрытия 777");
        level7.setTech(true);
        level7.setImgName("LrDtuzweyn_p.png");
        level7.setDuration(300L);
        level7.addCode(new Code("777", Code.KO.KO_NULL));
        levelList.add(level7);

        Level level8 = new Level(8);
        level8.setDescription("" +
                "<ul>" +
                "   <li>Не послать бы нам гонца за бутылочкой… в общем к табличке \"ПРОДУКТЫ 24 ЧАСА\"</li>" +
                "   <li>Звезды, крестики, круги на стенах площадки мы нашли</li>" +
                "   <li>А качели не простые, мы из Лего их собрали</li>" +
                "</ul>");
        level8.setImgName("xp4x9tskfm_6.png");
        level8.setDuration(420L);
        level8.addCode(new Code("8111", Code.KO.KO_1));
        level8.addCode(new Code("4321", Code.KO.KO_1));
        level8.addCode(new Code("8884", Code.KO.KO_1));
        levelList.add(level8);

        Level level9 = new Level(9);
        level9.setDescription("" +
                "<ul>" +
                "   <li>В гаражах с братвой бухали, утку желтую видали</li>" +
                "   <li>Белеет ЧТО-ТО одинокий в тумане моря голубом</li>" +
                "   <li>Взмывая выше ели, не ведая преград крылатые качели летят, летят, летят</li>" +
                "</ul>");
        level9.setImgName("i6hokz50bq_7.png");
        level9.setDuration(330L);
        level9.addCode(new Code("2379", Code.KO.KO_1));
        level9.addCode(new Code("3386", Code.KO.KO_1));
        level9.addCode(new Code("2052", Code.KO.KO_1));
        levelList.add(level9);

        Level level10 = new Level(10);
        level10.setDescription("" +
                "<ul>" +
                "   <li>Снова вечер, водка, алкаши, но гараж другой нашли</li>" +
                "   <li>Раз, два, три, четыре, пять, я иду считать</li>" +
                "   <li>Все на субботник, выкинем весь хлам на помойку!</li>" +
                "</ul>");
        level10.setImgName("C5JrVHrlpZ_8.png");
        level10.setDuration(360L);
        level10.addCode(new Code("4127", Code.KO.KO_1));
        level10.addCode(new Code("1248", Code.KO.KO_1));
        level10.addCode(new Code("3442", Code.KO.KO_1));
        levelList.add(level10);

        Level level11 = new Level(11);
        level11.setDescription("" +
                "<ul>" +
                "   <li>Мы у дома 83 щит распределительный нашли</li>" +
                "   <li>Я в корзину попадаю, трехочковый забиваю</li>" +
                "   <li>Даешь газовую трубу!</li>" +
                "</ul>");
        level11.setImgName("3UvzKX4v7v_9.png");
        level11.setDuration(330L);
        level11.addCode(new Code("5521", Code.KO.KO_1));
        level11.addCode(new Code("3125", Code.KO.KO_1));
        level11.addCode(new Code("2716", Code.KO.KO_1));
        levelList.add(level11);

        Level level12 = new Level(12);
        level12.setDescription("" +
                "<ul>" +
                "   <li>Учиться, учиться и учиться, но лучше с горки скатиться</li>" +
                "   <li>Помните, где гудели без нас? На этот раз давайте гедуть вместе</li>" +
                "   <li>Повторение - мать учения: Учиться, учиться и учиться, но лучше с горки скатиться</li>" +
                "</ul>");
        level12.setImgName("RIXqkh42CU_10.png");
        level12.setDuration(360L);
        level12.addCode(new Code("4957", Code.KO.KO_1));
        level12.addCode(new Code("9247", Code.KO.KO_1));
        level12.addCode(new Code("4477", Code.KO.KO_1));
        levelList.add(level12);
    }

    public Level getLevel(int i) {
        return new Level(levelList.get(i));
    }

    public Level getNextLevel(int curLevel) {
        if (levelList.size() <= curLevel) {
            return null;
        }
        return getLevel(curLevel);
    }

    public Level getNextLevel(Level curLevel) {
        return getNextLevel(curLevel.getNumber());
    }

    public int getLevelsCount() {
        return levelList.size();
    }

}
