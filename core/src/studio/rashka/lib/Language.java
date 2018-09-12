package studio.rashka.lib;

import java.util.HashMap;
import java.util.Map;

import studio.rashka.MarsGame;

public class Language {

    public Map<String, StringBuilder> textScreen;

    public Language() {
        textScreen = new HashMap<String, StringBuilder>();
        if (MarsGame.getPreference().language().equals("ru")) {
            textScreen.put("loading", new StringBuilder("Загрузка"));
            textScreen.put("touch", new StringBuilder("Нажмите на экран"));
        } else {
            textScreen.put("loading", new StringBuilder("Loading"));
            textScreen.put("touch", new StringBuilder("Tap on the screen"));
        }
    }

    public void story(String mission) {
        //region 1
        if (mission.equals("Missions_1_1")) {
            //region code
            if (MarsGame.getPreference().language().equals("ru")) {
                textScreen.put("Start_1", new StringBuilder("Наконец-таки мы высадились на Марсе. Сегодня прекрасный день, чтобы начать добычу кремария. Мои ищейки обнаружили неподалёку от зоны высадки залежи кремария."));
                textScreen.put("Start_2", new StringBuilder("Человек, твоя миссия - добыть их для меня."));
                textScreen.put("Start_3", new StringBuilder("Стой!!! Мои локаторы обнаружили какие-то движения, и они направляются к моей базе."));
                textScreen.put("Start_4", new StringBuilder("Это марсианские твари??? Походу они настроены враждебно."));
                textScreen.put("Start_5", new StringBuilder("Человек, твоя новая миссия - не дать им разрушить мою базу."));
                textScreen.put("Start_6", new StringBuilder("Я уже выслал за тобой шаттл. Он прибудет через 7:00 минут. За это время ты обязан продержаться. А пока ты там, добудь как можно больше кремария."));
                textScreen.put("Start_7", new StringBuilder("1. Я понял.\n2. Не бросай меня тут!\n3. Я всех порву.\n4. Не сознавайся, я тут главный."));
                textScreen.put("Finish_1", new StringBuilder("Человек, ты отлично поработал и проявил себя. Я разрешаю тебе ходить по моей орбитальной станции \"Надежда\". Как вы там говорите - чувствуй себя как дома."));
                textScreen.put("Finish_2", new StringBuilder("Не забудь заглянуть в арсенальную. Там тебя ждёт новое вооружение. Оно должно помочь эффективнее справляться с этими вредителями."));
                textScreen.put("Finish_3", new StringBuilder("1. Спасибо.\n2. *Выдох*... Я выжил.\n3. Отлично, новое вооружение.\n4. Р-7, это не твоя станция!"));
            } else {
                textScreen.put("Start_1", new StringBuilder("Finally we landed on Mars. Today is a great day to start harvesting a cremaria. My bloodhounds found near the landing zone of the cremaria."));
                textScreen.put("Start_2", new StringBuilder("Man, your mission: to get a cremaria for me."));
                textScreen.put("Start_3", new StringBuilder("Stop!!! My locators found some movement, and they are directed to my base."));
                textScreen.put("Start_4", new StringBuilder("This is a Martian creature??? They look very hostile."));
                textScreen.put("Start_5", new StringBuilder("Man, your new mission: do not let them destroy my base."));
                textScreen.put("Start_6", new StringBuilder("I already sent a shuttle for you. He will arrive in 7:00 minutes. Hold on and do not die. While you are there, get a cremaria."));
                textScreen.put("Start_7", new StringBuilder("1. I understand you.\n2. Do not leave me here!\n3. I will tear all.\n4. R-7, I'm the boss here."));
                textScreen.put("Finish_1", new StringBuilder("Man, you did a great job and showed yourself. I authorize you to walk on my orbital station \"Hope\". As you say, feel at home."));
                textScreen.put("Finish_2", new StringBuilder("Do not forget to look into the arsenal. There you will find new weapons. It should help to cope more effectively with these pests."));
                textScreen.put("Finish_3", new StringBuilder("1. Thank you.\n2. *Exhale*... I survived.\n3. Excellent, new weapons.\n4. R-7, this is not your station!"));
            }
            //endregion
        } else if (mission.equals("Missions_1_2")) {
            //region code
            if (MarsGame.getPreference().language().equals("ru")) {
                textScreen.put("Start_1", new StringBuilder("Как так вышло. Ведь было доказано, что на Марсе нет жизни. Откуда они повылазили?"));
                textScreen.put("Start_2", new StringBuilder("Чтобы не случилось, мы останемся на Марсе и продолжим добывать кремарий. Он необходим для выживания землян, да и платят за него щедро."));
                textScreen.put("Start_3", new StringBuilder("Мои ищейки нашли много кремария, но есть одна проблема - инкубаторы. Они способны выращивать большие колонии монстров за короткое время."));
                textScreen.put("Start_4", new StringBuilder("Человек, сооружай оборонительные башни, используй химическое оружие. Не подпускай их к базе и собирай кремарий. За тобой прилетит шаттл через 8:00 минут."));
                textScreen.put("Start_5", new StringBuilder("Чтоооо?! Эти твари мутируют. Я обнаружил у некоторых особей иммунитет к нашему химическому оружию. Смотри, у них на тельце появляется оттенок к чему у них иммунитет. Если он красный, то огонь не причинит ему вреда."));
                textScreen.put("Start_6", new StringBuilder("1. Есть добывать кремарий.\n2. Почему я должен это делать?\n3. О да, я всех испепелю.\n4. Р-7, может ты этим займёшься?"));
                textScreen.put("Finish_1", new StringBuilder("Эти твари не понимают на кого они нарвались. Их стало слишком много. Пора мне нанести ответный удар."));
                textScreen.put("Finish_2", new StringBuilder("Тебе доступно новое вооружение."));
                textScreen.put("Finish_3", new StringBuilder("1. В атаку, так в атаку.\n2. Может ну их?\n3. Ну, наконец, идём в атаку.\n4. Не одного тебя они достали."));
            } else {
                textScreen.put("Start_1", new StringBuilder("How did it happen. Everyone said that there is no life on Mars. Where did they come from?"));
                textScreen.put("Start_2", new StringBuilder("In order not to happen, we will stay on Mars and continue to get the cremaria. It is necessary for the survival of earthlings, and they pay generously for it."));
                textScreen.put("Start_3", new StringBuilder("My bloodhounds found a lot of cremaria, but it is surrounded by incubators. They are able to grow large colonies of monsters in a short time."));
                textScreen.put("Start_4", new StringBuilder("Man, build defensive towers, use chemical weapons. Do not let them get to the base and get a cremaria. The shuttle arrives in 8:00 minutes."));
                textScreen.put("Start_5", new StringBuilder("What?! These creatures mutate. I found some individuals immune to our chemical weapons. Look, they have a shade on the body to what they have immunity. If it is red, then the fire will not harm it."));
                textScreen.put("Start_6", new StringBuilder("1. I go to get a cremaria.\n2. Why should I do this?\n3. Oh yeah, I'll burn it all.\n4. R-7, can you do it?"));
                textScreen.put("Finish_1", new StringBuilder("These creatures do not understand who they attacked. There were too many of them. It's time for me to strike back."));
                textScreen.put("Finish_2", new StringBuilder("You have new weapons available."));
                textScreen.put("Finish_3", new StringBuilder("1. We go to the attack.\n2. Can not go anywhere?\n3. Take everything and go to the attack.\n4. They got me too."));
            }
            //endregion
        } else if (mission.equals("Missions_1_3")) {
            //region code
            if (MarsGame.getPreference().language().equals("ru")) {
                textScreen.put("Start_1", new StringBuilder("Мы прибыли в зону, откуда начнём нашу атаку. Человек, по моим данным здесь находится их логово. Исследуй его и полностью зачисть. Будь осторожен, ищейки сообщают о крупных особях в этой области."));
                textScreen.put("Start_2", new StringBuilder("Их сложнее пробить, целься в уязвимые места, старайся не трать патроны в пустую. Они больше, но медленнее. Этим нужно воспользоваться."));
                textScreen.put("Start_3", new StringBuilder("Смотри не взорви мою базу!"));
                textScreen.put("Start_4", new StringBuilder("Неподалёку от их логова находится кремарий. Пока будешь зачищать их логово, не забудь добывать кремарий."));
                textScreen.put("Start_5", new StringBuilder("1. Начинаю зачистку периметра.\n2. Опять я, опять на грани смерти.\n3. Никто лучше меня не разнесёт их логово.\n4. Моя база, хочу и взрываю!"));
                textScreen.put("Finish_1", new StringBuilder("Я проанализировал некоторые данные об этих монстрах, и вот что получил. Их агрессия вызвана нашей добычей кремария. Я полагаю, что это их пища, и они не намерены ей делиться."));
                textScreen.put("Finish_2", new StringBuilder("Мне нужны ещё трупы и больше времени для анализа. Мы должны их изучить."));
                textScreen.put("Finish_3", new StringBuilder("Ах да, загляни в арсенальную."));
                textScreen.put("Finish_4", new StringBuilder("1. Спасибо за информацию.\n2. Давай не будем трогать их пищу, пока сами ей не стали.\n3. Я принесу тебе столько трупов, сколько захочешь.\n4. Неужели, Р-7, ты на что-то способен."));
            } else {
                textScreen.put("Start_1", new StringBuilder("We arrived in the zone from where we begin our attack. Man, according to my information here is their lair. Explore it and completely clean it. Be careful, bloodhounds report large specimens in this area."));
                textScreen.put("Start_2", new StringBuilder("They are harder to pierce, aim at vulnerable places, try not to waste ammo in the empty. They are bigger, but slower. This should be used."));
                textScreen.put("Start_3", new StringBuilder("Do not blow my base!"));
                textScreen.put("Start_4", new StringBuilder("Next to their lair is a cremaria. While you are cleaning their lair, do not forget to get a cremaria."));
                textScreen.put("Start_5", new StringBuilder("1. Begin cleaning of the perimeter.\n2. Again I, again on the verge of death.\n3. No one will blow lair better than me.\n4. My base, I want and blast!"));
                textScreen.put("Finish_1", new StringBuilder("I analyzed some data about these monsters, and that's what I got. Their aggression is caused by our prey cremaria. I believe that this is their food, and they do not intend to share it."));
                textScreen.put("Finish_2", new StringBuilder("I need more corpses and more time for analysis. We must learn them."));
                textScreen.put("Finish_3", new StringBuilder("Be sure to look into the arsenal."));
                textScreen.put("Finish_4", new StringBuilder("1. Thank you for the information.\n2. Let's not touch their food, otherwise they will eat us.\n3. I will bring you as many corpses as you want.\n4. Wow, R-7, you are capable of something."));
            }
            //endregion
        } else if (mission.equals("Missions_1_4")) {
            //region code
            if (MarsGame.getPreference().language().equals("ru")) {
                textScreen.put("Start_1", new StringBuilder("Хорошо я их в прошлый раз поджарил. Теперь они запомнят этот урок надолго и умерят свой пыл. Будут знать, кого трогать."));
                textScreen.put("Start_2", new StringBuilder("Человек, теперь можешь расслабиться и давай приступай к добыче кремария. Теперь эти твари будут долго приходить в себя после моей сокрушительной атаки."));
                textScreen.put("Start_3", new StringBuilder("Я указал зону высадки, где находятся залежи кремария. Давай не ленись, как в прошлые разы, и работай добросовестно."));
                textScreen.put("Start_4", new StringBuilder("Так, а мне надо подзарядиться и немного отдохнуть."));
                textScreen.put("Start_5", new StringBuilder("1. Да, классно ты их.\n2. Да я чуть не обделался.\n3. Было просто офигенно.\n4. Насколько я помню, это я их поджарил."));
                textScreen.put("Finish_1", new StringBuilder("Отличная работа. Я отправил собранные останки новых видов нашим учёным. Мы должны лучше их изучить и выявить слабые места. Иначе нам их не одолеть."));
                textScreen.put("Finish_2", new StringBuilder("Пока ты был на Марсе и занимался не понятно чем, прибыл танкер с ценным грузом. Советую тебе зайти в арсенальную."));
                textScreen.put("Finish_3", new StringBuilder("1. Интересно, что там привезли.\n2. Как они могли улететь без меня.\n3. Неужели привезли здоровенные пушки.\n4. Пока ты прохлаждался, я воевал."));
            } else {
                textScreen.put("Start_1", new StringBuilder("As I last fried them. Now they will remember this lesson for a long time and will moderate their ardor. They will know who to touch."));
                textScreen.put("Start_2", new StringBuilder("Man, now you can relax and let's get down to get a cremaria. Now these creatures will recover for a long time after my crushing attack."));
                textScreen.put("Start_3", new StringBuilder("I indicated the landing zone where a cremaria deposits are located. Let's not be lazy, as in the previous times, and work in good faith."));
                textScreen.put("Start_4", new StringBuilder("So, I need to recharge and relax a little."));
                textScreen.put("Start_5", new StringBuilder("1. Yes, you are awesome.\n2. I almost crap.\n3. It was just awesome.\n4. As far as I can remember, I fried them."));
                textScreen.put("Finish_1", new StringBuilder("Great job. I sent the collected remains of new species to our scientists. We should better study them and identify weaknesses. Otherwise we will not defeat them."));
                textScreen.put("Finish_2", new StringBuilder("While you were on Mars and was engaged in nonsense, a tanker arrived with a valuable cargo. I advise you to go into the arsenal."));
                textScreen.put("Finish_3", new StringBuilder("1. I wonder what's the cargo.\n2. How could they fly without me.\n3. Really brought a huge gun.\n4. While you were relaxing, I was at war."));
            }
            //endregion
        } else if (mission.equals("Missions_1_5")) {
            //region code
            if (MarsGame.getPreference().language().equals("ru")) {
                textScreen.put("Start_1", new StringBuilder("Как это пекло достало. Мои микросхемы плавятся от такой жары, но пока исследована только эта местность. Здесь хорошие залежи кремария. В этой области не было зафиксировано особой активности монстров, а значит можно спокойно заняться добычей."));
                textScreen.put("Start_2", new StringBuilder("Надо моих ищеек отправить на поиски кремария в более прохладные местности."));
                textScreen.put("Start_3", new StringBuilder("Прибыли на зону высадки. Прекрасно, вижу много кремария. Вперёд мой человек на добычу!"));
                textScreen.put("Start_4", new StringBuilder("1. Начнём заполнять склады.\n2. Неужели этот день будет без приключений.\n3. Как не будет мясорубки?!\n4. Хватит ныть и помогай с добычей."));
                textScreen.put("Finish_1", new StringBuilder("Кто мог подумать, что наше бурение так их оживит. Нам нужно больше времени, чтобы понять, как они устроены. Такой промашки больше нельзя допускать."));
                textScreen.put("Finish_2", new StringBuilder("Человек, у меня для тебя отличная весть. В арсенале пополнение."));
                textScreen.put("Finish_3", new StringBuilder("1. Было неожиданно.\n2. Твоя оплошность чуть не лишила меня жизни.\n3. Согласен, надо их расчленять.\n4. У нас нет времени, давай ускоряйся."));
            } else {
                textScreen.put("Start_1", new StringBuilder("I'm tired of this unbearable heat. My chips are melted by this heat, but so far only investigated this area. There are good deposits of cremaria here. In this area, there was no fixed activity of the monsters, so you can safely do prey."));
                textScreen.put("Start_2", new StringBuilder("It is necessary to send my bloodhounds to search for cremaria in cooler terrains."));
                textScreen.put("Start_3", new StringBuilder("Arrivals to the landing zone. Fine, I see a lot of cremaria. My man go to the prey!"));
                textScreen.put("Start_4", new StringBuilder("1. I begin to fill the warehouses.\n2. Is this the day will be without incident.\n3. How will there not be meat grinders?!\n4. Stop whining and help with the prey."));
                textScreen.put("Finish_1", new StringBuilder("Who could have thought that our drilling would bring them back to life? We need more time to understand how they are arranged. Such blunders can no longer be tolerated."));
                textScreen.put("Finish_2", new StringBuilder("Man, I have great news for you. In the arsenal of replenishment."));
                textScreen.put("Finish_3", new StringBuilder("1. It was unexpected.\n2. Your mistake nearly killed me.\n3. I agree, we must dismember them.\n4. We do not have time, let's speed up."));
            }
            //endregion
        } else if (mission.equals("Missions_1_6")) {
            //region code
            if (MarsGame.getPreference().language().equals("ru")) {
                textScreen.put("Start_1", new StringBuilder("Какой сегодня жаркий день. Эта лава сегодня очень сильно бурлит. К чему бы это..."));
                textScreen.put("Start_2", new StringBuilder("Так, мы на Марсе не для изучения погодных условий. Нам нужно ускорить темпы по добыче кремария. От землян пришли запросы на большие поставки."));
                textScreen.put("Start_3", new StringBuilder("Ух, как много денежек скоро у меня будет."));
                textScreen.put("Start_4", new StringBuilder("Высаживаемся в этой зоне и приступаем активно добывать кремарий."));
                textScreen.put("Start_5", new StringBuilder("Что-то происходит с моим локатором. Он показывает невероятно огромный объект, который движется к нам. Я такого ещё не наблюдал. Видимо стая монстров надвигается к нам. Сейчас я их всех расстреляю."));
                textScreen.put("Start_6", new StringBuilder("Аааааа, да это один монстр и какой огромный. Мы все умрём!!! Человек, задержи его, я должен спастись!!!"));
                textScreen.put("Start_7", new StringBuilder("1. Я постараюсь задержать его, спасайся!\n2. Р-7, я не хочу помирать!\n3. Для меня гордость умереть в бою!\n4. Здесь умрёт только один, и это буду не я."));
                textScreen.put("Finish_1", new StringBuilder("Вот это была просто ожесточённая битва. Я сражался в пол силы и вынес его. Я думал, он будет намного сильнее."));
                textScreen.put("Finish_2", new StringBuilder("Человек, если бы не я, то тебя бы давно съел тот огромный монстр. Зови меня - Р-7 непобедимый и грозный спаситель. Можешь иногда мне поклоняться."));
                textScreen.put("Finish_3", new StringBuilder("Лучшие инженеры разработали оружия для борьбы с такими особями. Было бы неплохо что-нибудь у них прикупить."));
                textScreen.put("Finish_4", new StringBuilder("1. Мы справились.\n2. Р-7, я тебе этого не прощу!\n3. Как же я оторвался!\n4. Я же говорил кто умрёт."));
            } else {
                textScreen.put("Start_1", new StringBuilder("What a hot day it is today. This lava is now very much bubbling. What is it for..."));
                textScreen.put("Start_2", new StringBuilder("We are on Mars not for studying weather conditions. We need to speed up the extraction of the cremaria. From the earthmen came requests for large supplies."));
                textScreen.put("Start_3", new StringBuilder("Oh, how much money I'll have soon."));
                textScreen.put("Start_4", new StringBuilder("We land in this zone and start to get a cremaria."));
                textScreen.put("Start_5", new StringBuilder("Something is happening to my locator. It shows an incredibly huge object that is moving towards us. I have not seen this yet. Apparently a flock of monsters is coming towards us. Now I have them all shot."));
                textScreen.put("Start_6", new StringBuilder("Aaaaaa, this is one monster and what a huge one. We all will die!!! Man, detain him, I must be saved!!!"));
                textScreen.put("Start_7", new StringBuilder("1. I will try to detain him, save yourself!\n2. R-7, I do not want to die!\n3. For me the pride of dying in battle!\n4. Only one will die here, and it will not be me."));
                textScreen.put("Finish_1", new StringBuilder("It was just a fierce battle. I fought in the floor of strength and took it out. I thought he would be much stronger."));
                textScreen.put("Finish_2", new StringBuilder("Man, if not for me, then you would have been eaten by that huge monster. Call me - R-7 is an invincible and formidable savior. You can sometimes worship me."));
                textScreen.put("Finish_3", new StringBuilder("The best engineers have developed weapons to deal with such individuals. It would be nice to buy something from them."));
                textScreen.put("Finish_4", new StringBuilder("1. We coped.\n2. R-7, I will not forgive you for this!\n3. How did I come off!\n4. I told you who will die."));
            }
            //endregion
        }
        //endregion
        //region 2
        else if (mission.equals("Missions_2_1")) {
            //region code
            if (MarsGame.getPreference().language().equals("ru")) {
                textScreen.put("Start_1", new StringBuilder("Невероятно! Я не предполагал, что тут могут быть такие огромные марсианские твари."));
                textScreen.put("Start_2", new StringBuilder("Я проанализировал останки этой убитой особи. Структура очень сильно отличаются от других видов, но ДНК полностью идентично."));
                textScreen.put("Start_3", new StringBuilder("Как такое вообще возможно? Это нарушает все законы."));
                textScreen.put("Start_4", new StringBuilder("Судя по результатам проведённых анализов, возраст этой особи более тысячи лет. И столько лет они скрывались от нас? Просто немыслимо."));
                textScreen.put("Start_5", new StringBuilder("Наконец-таки, мы сменили локацию по добыче кремария. Здесь довольно приятный климат и большие запасы кремария. Что меня очень радует."));
                textScreen.put("Start_6", new StringBuilder("1. Согласен, здесь лучше.\n2. Давай соберём побольше кремария.\n3. Надеюсь, что здесь будет веселее.\n4. Доложи об этом Земле."));
                textScreen.put("Finish_1", new StringBuilder("Человек, отличная работа. Наши склады заполнены кремарием. Теперь можно отправлять груз на Землю."));
                textScreen.put("Finish_2", new StringBuilder("Что же я хотел тебе важного сказать… что-то моя память сегодня немного барахлит. Надо мне к механику заехать."));
                textScreen.put("Finish_3", new StringBuilder("1. Я старался =)\n2. Пришлось немного попотеть.\n3. Это было не трудно.\n4. Ах ты старая развалина."));
            } else {
                textScreen.put("Start_1", new StringBuilder("Incredible! I did not expect that there could be such huge Martian creatures."));
                textScreen.put("Start_2", new StringBuilder("I analyzed the remains of this killed individual. The structure is very different from other species, but DNA is completely identical."));
                textScreen.put("Start_3", new StringBuilder("How is this even possible? This violates all laws."));
                textScreen.put("Start_4", new StringBuilder("By results of the spent analyzes, the age of this individual is more than thousand years. And for so many years they have been hiding from us? Simply unthinkable."));
                textScreen.put("Start_5", new StringBuilder("Finally, we changed the location for the extraction of cremaria. Here is a pretty pleasant climate and large reserves of cremaria. That makes me very happy."));
                textScreen.put("Start_6", new StringBuilder("1. I agree, it's better here.\n2. Let's get more cremaria together.\n3. I hope that it will be more fun here.\n4. Report this to the Earth."));
                textScreen.put("Finish_1", new StringBuilder("Man, great work. Our warehouses are filled with cremaria. Now we can send cargo to Earth."));
                textScreen.put("Finish_2", new StringBuilder("What I wanted to tell you is important ... something my memory today is a little messy. I have to go to the mechanic."));
                textScreen.put("Finish_3", new StringBuilder("1. I tried =)\n2. I had to sweat.\n3. It was not difficult.\n4. Oh, you old ruin."));
            }
            //endregion
        } else if (mission.equals("Missions_2_2")) {
            //region code
            if (MarsGame.getPreference().language().equals("ru")) {
                textScreen.put("Start_1", new StringBuilder("Я тут посидел, немного подумал и вот к чему пришёл. Думаю, тебя это очень заинтересует."));
                textScreen.put("Start_2", new StringBuilder("Чтобы эффективнее расправляться с этими марсианскими тварями, нам нужно изменить тактику. Проанализировав окрестности Марса, я обнаружил какие-то загадочные артефакты, которые должны нам помочь в сильном развитии наших технологий. А как ты знаешь, текущее наше положение малоэффективно против них и мы дальше не сможем продвинуться."));
                textScreen.put("Start_3", new StringBuilder("Мои ищейки обнаружили точное местоположение нескольких артефактов, находящихся поблизости от нас. Они нужны мне, то есть нам."));
                textScreen.put("Start_4", new StringBuilder("По полученным данным, один находится в этой местности. Добудь его любой ценой. От него зависит наша дальнейшая судьба на Марсе. Не подведи."));
                textScreen.put("Start_5", new StringBuilder("1. Р-7, отличная идея.\n2. Расстаться жизнью ради артефакта?\n3. Артефакт будет нашим!\n4. Надеюсь, ты был прав."));
                textScreen.put("Finish_1", new StringBuilder("Отлично человек. Первый артефакт у нас. Хм, в нём находится скопление каких-то неизвестных мне микроорганизмов."));
                textScreen.put("Finish_2", new StringBuilder("Очень даже интересно. Мои показатели зашкаливают. В артефакте находится огромное количество энергии. Я потрясён."));
                textScreen.put("Finish_3", new StringBuilder("Первые научные испытания позволили усовершенствовать наши технологии и разработать новое вооружение. Их мощь значительно выше, так же в снаряды я поместил часть энергии из артефакта. Они тебе понравятся."));
                textScreen.put("Finish_4", new StringBuilder("1. Первый шаг сделан!\n2. Микроорганизмы? Будь осторожнее с ними.\n3. Так, так, так. Надо оценить их.\n4. Необходимо продолжить поиски артефактов."));
            } else {
                textScreen.put("Start_1", new StringBuilder("I sat here for a while, thought for a while and that's what I came to. I think you will be very interested."));
                textScreen.put("Start_2", new StringBuilder("To more effectively deal with these Martian creatures, we need to change tactics. I analyzed the neighborhood of Mars and discovered some mysterious artifacts. They should help us in the strong development of our technologies. As you know, our current situation is ineffective against them and we will not be able to advance further."));
                textScreen.put("Start_3", new StringBuilder("My bloodhounds found the exact location of several artifacts that are close to us. I need them."));
                textScreen.put("Start_4", new StringBuilder("According to the information received, one is in this area. Obtain it at any cost. It depends on our future fate on Mars. Do not let me down."));
                textScreen.put("Start_5", new StringBuilder("1. R-7, a great idea.\n2. To part with life for an artifact?\n3. The artifact will be ours!\n4. I hope you were right."));
                textScreen.put("Finish_1", new StringBuilder("Excellent man. The first artifact is with us. Hmm, there is a cluster of some microorganisms unknown to me."));
                textScreen.put("Finish_2", new StringBuilder("Very interesting. My indicators go off scale. In the artifact is a huge amount of energy. I'm shocked."));
                textScreen.put("Finish_3", new StringBuilder("The first scientific tests allowed us to improve our technologies and develop new weapons. Their power is much higher, just as I put some of the energy from the artifact into the shells. You'll like them."));
                textScreen.put("Finish_4", new StringBuilder("1. The first step is done!\n2. Microorganisms? Be careful with them.\n3. So, so, so. We must evaluate them.\n4. It is necessary to continue searching for artifacts."));
            }
            //endregion
        } else if (mission.equals("Missions_2_3")) {
            //region code
            if (MarsGame.getPreference().language().equals("ru")) {
                textScreen.put("Start_1", new StringBuilder("Человек, у меня для тебя плохая новость."));
                textScreen.put("Start_2", new StringBuilder("Мы исчерпали почти все свои ресурсы на изучение полученного мной артефакта. Потребовалось больше сил и времени, чем предполагалось, а ресурсы уже на исходе."));
                textScreen.put("Start_3", new StringBuilder("Необходимо продолжать исследования, но для этого нужен кремарий. Отправляйся срочно на Марс и добудь его для наших учёных и для меня, конечно."));
                textScreen.put("Start_4", new StringBuilder("В этой области предположительно находятся большие залежи кремария. Не медли с добычей!"));
                textScreen.put("Start_5", new StringBuilder("1. Я постараюсь как можно быстрее управиться.\n2. А монстров здесь не видать?\n3. Надеюсь, добыча кремария не будет скучной.\n4. Р-7, куда так много тратишь ресурсов?"));
                textScreen.put("Finish_1", new StringBuilder("Отлично! Я получил достаточное количество кремария и смог завершить очередное исследование."));
                textScreen.put("Finish_2", new StringBuilder("По моим данным и наставлениям учёным удалось кое-что разработать. Загляни в арсенальную и оцени."));
                textScreen.put("Finish_3", new StringBuilder("1. Это было легко.\n2. Кое-что?\n3. Я всегда делаю всё по высшему разряду.\n4. Интересно, что там им удалось изобрести."));
            } else {
                textScreen.put("Start_1", new StringBuilder("Man, I have bad news for you."));
                textScreen.put("Start_2", new StringBuilder("We exhausted almost all of our resources in the study of the artifact I received. It took more time and effort than expected. Resources are already running out."));
                textScreen.put("Start_3", new StringBuilder("It is necessary to continue research, but for this you need a cremaria. Go immediately to Mars and get it for our scientists."));
                textScreen.put("Start_4", new StringBuilder("In this area, there are supposedly large deposits of cremaria. Do not delay with the prey!"));
                textScreen.put("Start_5", new StringBuilder("1. I will try to manage as soon as possible.\n2. Do not see monsters here?\n3. I hope the extraction of a cremaria will not be boring.\n4. R-7, where do you spend so much resources?"));
                textScreen.put("Finish_1", new StringBuilder("Excellent! I got enough cremaria and was able to complete the next study."));
                textScreen.put("Finish_2", new StringBuilder("According to my information and instructions, scientists have managed to work out something. Look at the arsenal and evaluate."));
                textScreen.put("Finish_3", new StringBuilder("1. It was easy.\n2. Something?\n3. I always do everything best.\n4. What did they invent?"));
            }
            //endregion
        } else if (mission.equals("Missions_2_4")) {
            //region code
            if (MarsGame.getPreference().language().equals("ru")) {
                textScreen.put("Start_1", new StringBuilder("Следующий артефакт должен находиться в этой области. От него исходит слабый сигнал, так что я не могу точно определить его местоположение."));
                textScreen.put("Start_2", new StringBuilder("Я предполагаю, что он как-то связан с нашей недавней находкой и может значительно понизить затраты на исследования. Ну, или повысить вдвое. Хи-хи-хи."));
                textScreen.put("Start_3", new StringBuilder("Недавно я обнаружил новый вид. Судя по его строению, он способен летать. Эффективен против него будет пулемёт, от остального оружия он, возможно, может увернуться."));
                textScreen.put("Start_4", new StringBuilder("Достань мне образцы этого вида. Нужно его будет изучить. Возможно, получиться узнать чего-нибудь интересного про них."));
                textScreen.put("Start_5", new StringBuilder("1. Постараюсь найти артефакт.\n2. Как? Они ещё и летать умеют?\n3. Чую будет хорошая заварушка.\n4. Я добуду тебе эти образцы."));
                textScreen.put("Finish_1", new StringBuilder("Я немного расстроился, что здесь не оказался артефакт. Ну, ничего, у меня ещё есть пару мест, где его можно найти и ты туда отправишься."));
                textScreen.put("Finish_2", new StringBuilder("Как интересно. Эти монстры очень быстро мутируют. Крылатый вид, судя по анализам, появился относительно недавно, с момента нашего появления."));
                textScreen.put("Finish_3", new StringBuilder("Походу у них есть какой-то разум."));
                textScreen.put("Finish_4", new StringBuilder("1. Крылатые препятствовали добыче кремария.\n2. У них хоть есть слабые места?\n3. Они точно не ожидали такого разгрома и отпора.\n4. Р-7, из-за твоей промашки, мы потеряли время."));
            } else {
                textScreen.put("Start_1", new StringBuilder("The next artifact must be in this area. It emits a weak signal, so I can not pinpoint its location."));
                textScreen.put("Start_2", new StringBuilder("I guess that he is somehow connected with our recent discovery and can significantly reduce research costs. Or double it."));
                textScreen.put("Start_3", new StringBuilder("Recently I discovered a new species. In its structure, it is able to fly. Effective against him a machine gun, from the rest of the weapon, he can dodge."));
                textScreen.put("Start_4", new StringBuilder("Get me some samples of this kind. We need to study it. Maybe get to know something interesting about them."));
                textScreen.put("Start_5", new StringBuilder("1. I wll try to find an artifact.\n2. How? They also know how to fly?\n3. I will chew a good deal.\n4. I will get you these samples."));
                textScreen.put("Finish_1", new StringBuilder("I was a little upset that here we did not find the artifact. I still have a couple of places where you can find it and you go there."));
                textScreen.put("Finish_2", new StringBuilder("How interesting. These monsters very quickly mutate. The winged appearance appeared relatively recently, from the moment of our appearance."));
                textScreen.put("Finish_3", new StringBuilder("They have some kind of intelligence in the campaign."));
                textScreen.put("Finish_4", new StringBuilder("1. Winged monsters prevented the extraction of cremaria.\n2. Do they have any weaknesses?\n3. They certainly did not expect such defeat and rebuff.\n4. R-7, because of your mistake, we lost time."));
            }
            //endregion
        } else if (mission.equals("Missions_2_5")) {
            //region code
            if (MarsGame.getPreference().language().equals("ru")) {
                textScreen.put("Start_1", new StringBuilder("По моим данным артефакт точно должен быть где-то в этой области. Хм, датчик показывает, что он рядом, но где."));
                textScreen.put("Start_2", new StringBuilder("Человек, я нашёл его. Но тут небольшая проблема. Артефакт залило лавой и он в ней окаменел. Просто так его не достать. Тут нужна ювелирная работа, иначе артефакт можно повредить и все поиски окажутся напрасны."));
                textScreen.put("Start_3", new StringBuilder("Человек, охраняй меня и отбивай волны монстров, которые будут надвигаться на нас. Не дай им помешать достать мне этот артефакт!"));
                textScreen.put("Start_4", new StringBuilder("И не забудь про добычу кремария. Он будет очень кстати для проведения следующих лабораторных испытаний."));
                textScreen.put("Start_5", new StringBuilder("1. Р-7, надеюсь на тебя.\n2. Р-7, пожалуйста, поторопись!\n3. Как их много. Это просто прекрасно!\n4. Давай быстрее, а я ими займусь."));
                textScreen.put("Finish_1", new StringBuilder("Великолепно! Очередной артефакт у меня. Теперь сможем значительно продвинуться в технологиях. Посмотрим."));
                textScreen.put("Finish_2", new StringBuilder("Что это..."));
                textScreen.put("Finish_3", new StringBuilder("А нет, просто показалось."));
                textScreen.put("Finish_4", new StringBuilder("1. Я был уверен в нашем успехе :-)\n2. Ты вообще сдурел, так пугать?\n3. Пора уже развивать наши технологии.\n4. Р-7, артефакт не твой, не вздумай его испортить!"));
            } else {
                textScreen.put("Start_1", new StringBuilder("According to my information, the artifact should definitely be somewhere in this area. Hmm, the sensor shows that it is near. Where is he?"));
                textScreen.put("Start_2", new StringBuilder("Man, I found it. But here a small problem. The artifact was flooded with lava and it was petrified in it. Just so you can not get it. Need a piece of jewelry, otherwise the artifact can be damaged and all searches will be in vain."));
                textScreen.put("Start_3", new StringBuilder("Человек, охраняй меня и отбивай волны монстров, которые будут надвигаться на нас. Не дай им помешать достать мне этот артефакт!"));
                textScreen.put("Start_4", new StringBuilder("Do not forget about the prey of cremaria. It will be very useful for the following laboratory tests."));
                textScreen.put("Start_5", new StringBuilder("1. R-7, I'm counting on you.\n2. R-7, please hurry!\n3. How many of them. It's just perfect!\n4. Come on quickly, and I'll take care of them."));
                textScreen.put("Finish_1", new StringBuilder("Sumptuously! The next artifact is mine. Now we can make significant progress in technology. Let's see what happens here."));
                textScreen.put("Finish_2", new StringBuilder("What is it..."));
                textScreen.put("Finish_3", new StringBuilder("Just seemed."));
                textScreen.put("Finish_4", new StringBuilder("1. I was confident of our success :-)\n2. Are you crazy, so frightening?\n3. It is high time to develop our technologies.\n4. R-7, the artifact is not yours, do not you dare to spoil it!"));
            }
            //endregion
        } else if (mission.equals("Missions_2_6")) {
            //region code
            if (MarsGame.getPreference().language().equals("ru")) {
                textScreen.put("Start_1", new StringBuilder("У нас возникла проблема в исследовании моих двух артефактов. Чего-то не хватает для проведения испытания. Нужен недостающий фрагмент."));
                textScreen.put("Start_2", new StringBuilder("Возможно, недостающий фрагмент есть в следующем артефакте. Так, где он может быть."));
                textScreen.put("Start_3", new StringBuilder("Очень странно. Мои локаторы показывают, что артефакт движется. Видимо тут какая-то ошибка. Всё указывает, что артефакт это огромный монстр."));
                textScreen.put("Start_4", new StringBuilder("Человек, тебе необходимо удостовериться ошибка это или нет. Отправляйся в зону высадки рядом с тем монстром и разведай что это за монстр и где находится артефакт."));
                textScreen.put("Start_5", new StringBuilder("1. Отправляемся на разведку.\n2. Ещё один огромный монстр?\n3. Зачем идти на разведку, когда можно его уничтожить.\n4. Р-7, продолжай сканировать местность,\nя чую артефакт где-то рядом."));
                textScreen.put("Finish_1", new StringBuilder("Невероятно! Этот монстр когда-то съел артефакт и под его выделяющейся безграничной энергии смог вырасти до таких размеров. Я даже не представляю, до каких размеров он мог бы вырасти."));
                textScreen.put("Finish_2", new StringBuilder("Так, артефакт я достал и получил недостающий фрагмент для завершения великого прорыва в технологиях. Мне нужно время чтобы всё прошло без каких-либо недоразумений."));
                textScreen.put("Finish_3", new StringBuilder("Человек, а ты можешь пока отдохнуть."));
                textScreen.put("Finish_4", new StringBuilder("1. Главное артефакт у нас.\n2. Монстр был невероятно огромным.\n3. Был бы он вдвое больше, всё равно не ушёл бы от меня!\n4. Р-7, жду от тебя отчёт в ближайшее время."));
            } else {
                textScreen.put("Start_1", new StringBuilder("We had a problem in researching my two artifacts. Something is not enough for the test. We need the missing fragment."));
                textScreen.put("Start_2", new StringBuilder("The missing fragment is in the next artifact. Where can he be?"));
                textScreen.put("Start_3", new StringBuilder("Very strange. My locators show that the artifact is moving. Apparently there is some mistake. Everything indicates that the artifact is a huge monster."));
                textScreen.put("Start_4", new StringBuilder("Man, you need to make sure that my locators are not broken. Go to the landing zone next to that monster. Explore what kind of monster and where is the artifact."));
                textScreen.put("Start_5", new StringBuilder("1. We go on scouting.\n2. Another huge monster?\n3. Why go to the exploration, when you can destroy it.\n4. R-7, continue to scan the terrain,\nI smell the artifact somewhere nearby."));
                textScreen.put("Finish_1", new StringBuilder("Incredible! This monster once ate an artifact and under its outstanding unlimited energy could grow to such a size. I do not even know how big he could have grown."));
                textScreen.put("Finish_2", new StringBuilder("So, I got the artifact and got the missing fragment to complete the great breakthrough in technology. I need time to get through without any misunderstandings."));
                textScreen.put("Finish_3", new StringBuilder("Man, you can rest for now."));
                textScreen.put("Finish_4", new StringBuilder("1. The main artifact is with us.\n2. The monster was incredibly huge.\n3. If he were twice as big, he would not have left me!\n4. R-7, I expect a report from you in the near future."));
            }
            //endregion
        }
        //endregion
        //region 3
        else if (mission.equals("Missions_3_1")) {
            //region code
            if (MarsGame.getPreference().language().equals("ru")) {
                textScreen.put("Start_1", new StringBuilder("Ещё один огромный монстр уничтожен благодаря мне. Если не моя смекалка и превосходный интеллект, тебе пришлось бы туго справиться с такой громадиной. А это дорогого стоит, так что с тебя куча кремария."));
                textScreen.put("Start_2", new StringBuilder("Недостающий третий артефакт теперь у меня. Отлично! Надеюсь, этого хватит, чтобы провести незаконченные эксперименты и получить новые технологии. Мы уже далеко прошли, чтобы на этом останавливаться."));
                textScreen.put("Start_3", new StringBuilder("Человек, как ты думаешь, земляне смогут выжить благодаря нам? Не пройдут ли мои усилия зря? Я же на Марс полетел только ради своих любимых человечков. Чтобы они жили, не тужили и ремонтировали меня."));
                textScreen.put("Start_4", new StringBuilder("1. Р-7, ты отлично справляешься.\n2. Лучше бы переживал за наше выживание!\n3. Если перестреляем всех монстров, тогда да!\n4. Мы сделаем всё для выполнения нашей миссии!"));
                textScreen.put("Finish_1", new StringBuilder("Новая местность довольно таки интересна и не обычна. Не зря было моим решением приступить добывать кремарий именно здесь."));
                textScreen.put("Finish_2", new StringBuilder("Монстры слабые и беспомощные, много кремария и нет ужасного пекла."));
                textScreen.put("Finish_3", new StringBuilder("Мы остаёмся здесь и изучим досконально всю местность от и до. Возможно, найдём чего-нибудь интересного. Да, мой человек?"));
                textScreen.put("Finish_4", new StringBuilder("1. Конечно, Р-7.\n2. Слабые, но их было много.\n3. Мне не нравится, что монстры слабые.\n4. Выпускай своих ищеек, пусть дальше сканируют местность."));
            } else {
                textScreen.put("Start_1", new StringBuilder("Another huge monster is destroyed thanks to me. If not my ingenuity and excellent intellect, you would have to cope with such a huge. And it's worth a lot, so there's a lot of cremaria from you."));
                textScreen.put("Start_2", new StringBuilder("The missing third artifact now is mine. Excellent! I hope this is enough to conduct unfinished experiments and get new technologies. We have already gone far to dwell on this."));
                textScreen.put("Start_3", new StringBuilder("Man, do you think earthlings will be able to survive thanks to us? Will my efforts go in vain? I flew to Mars just for the sake of my favorite little men. That they lived and repaired me."));
                textScreen.put("Start_4", new StringBuilder("1. R-7, you are doing very well.\n2. I'd rather worry about our survival!\n3. If we shoot all the monsters, then yes!\n4. We will do our best to fulfill our mission!"));
                textScreen.put("Finish_1", new StringBuilder("The new area is quite interesting and not ordinary. It was not in vain that I decided to get the cremaria right here."));
                textScreen.put("Finish_2", new StringBuilder("Monsters are weak and helpless, lots of cremaria and there is no horrible baking."));
                textScreen.put("Finish_3", new StringBuilder("We stay here and study thoroughly the whole area from and to. Perhaps we will find something interesting. Yes, my man?"));
                textScreen.put("Finish_4", new StringBuilder("1. Of course, R-7.\n2. Weak, but there were a lot of them.\n3. I do not like that monsters are weak.\n4. Release your bloodhounds, let them further scan the terrain."));
            }
            //endregion
        } else if (mission.equals("Missions_3_2")) {
            //region code
            if (MarsGame.getPreference().language().equals("ru")) {
                textScreen.put("Start_1", new StringBuilder("Человек, хорошие новости поступили ко мне этим утром."));
                textScreen.put("Start_2", new StringBuilder("Земляне запросили большие поставки высококачественного кремария, за который они щедро заплатят. Часть денег они уже перевели на мои счёта. Чтобы не осрамить мою репутацию, как надёжного и качественного поставщика даю тебе 15 минут на добычу кремария. И я сразу отправляю груз на Землю. Иначе по срокам не уложимся, тогда мне придётся с тебя вычесть неустойку за не выполнение поставленных сроков."));
                textScreen.put("Start_3", new StringBuilder("А если груз придёт раньше оговоренного срока, есть вероятность получить хорошие проценты. Заказчик, на этот раз, выдался очень щедрым."));
                textScreen.put("Start_4", new StringBuilder("Так, посмотрим. Мои ищейки доложили, что в этой местности находятся залежи кремария и он очень хорошего качества. Видимо на него повлияла окружающая среда. Ммм, просто великолепно."));
                textScreen.put("Start_5", new StringBuilder("Человек, приземляйся в указанной зоне высадки и приступай добывать кремарий. И смотри, бережней с ним. По окончанию я всё проверю и оценю твою работу."));
                textScreen.put("Start_6", new StringBuilder("1. Отлично, подзаработаем немного =)\n2. Р-7, я знаю свою работу.\n3. А монстры где?\n4. Р-7, я не понял! Какие счёта???"));
                textScreen.put("Finish_1", new StringBuilder("Я такого ещё никогда не видел. Откуда их столько повылазило."));
                textScreen.put("Finish_2", new StringBuilder("Человек, я рад, что ты смог выкарабкаться и доставить мой кремарий. Если бы там помер, кто бы мне доставил кремарий."));
                textScreen.put("Finish_3", new StringBuilder("Отлично! Кремарий высокого качества и идеальной формы. Срочно отправляю груз на Землю."));
                textScreen.put("Finish_4", new StringBuilder("1. Спасибо за беспокойство.\n2. Р-7, почему не выслал гвардию на помощь?\n3. Уху, мясорубка была на славу!\n4. Р-7, проследи, чтобы груз добрался до места."));
            } else {
                textScreen.put("Start_1", new StringBuilder("Man, good news came to me this morning."));
                textScreen.put("Start_2", new StringBuilder("Earthlings have requested a large supply of high-quality cremaria, for which they will pay generously. Some of the money they already transferred to my account. In order not to disgrace my reputation, as a reliable and high-quality supplier, I give you 15 minutes for the extraction of cremaria. And I immediately send the cargo to Earth. Otherwise, we can not meet the deadline, then I'll have to deduct the penalty for not fulfilling the deadlines."));
                textScreen.put("Start_3", new StringBuilder("And if the cargo arrives earlier than the agreed period, it is possible to get good interest. The customer was very generous."));
                textScreen.put("Start_4", new StringBuilder("So, we'll see. My bloodhounds reported that in this area there are deposits of cremaria and it is of very good quality. Apparently it was influenced by the environment. Mmm, just great."));
                textScreen.put("Start_5", new StringBuilder("Man, land in the indicated landing zone and proceed to get the cremaria. And look, be careful with him. At the end I will check everything and evaluate your work."));
                textScreen.put("Start_6", new StringBuilder("1. Excellent, earn a little =)\n2. R-7, I know my work.\n3. And where are the monsters?\n4. R-7, I do not understand! What accounts???"));
                textScreen.put("Finish_1", new StringBuilder("I have never seen this before. How did they get out so much?"));
                textScreen.put("Finish_2", new StringBuilder("Man, I'm glad you could get out and deliver my cremaria. If there died, who would have given me the cremaria."));
                textScreen.put("Finish_3", new StringBuilder("Excellent! Cremaria of high quality and ideal shape. I urgently send cargo to Earth."));
                textScreen.put("Finish_4", new StringBuilder("1. Thank you for your concern.\n2. R-7, why did not you send the Guards to help?\n3. The meat mincer was on the glory!\n4. R-7, make sure that the cargo gets to the place."));
            }
            //endregion
        } else if (mission.equals("Missions_3_3")) {
            //region code
            if (MarsGame.getPreference().language().equals("ru")) {
                textScreen.put("Start_1", new StringBuilder("Человек, груз успешно доставлен. Заказчик очень доволен товаром и моей безотказной работой. Старайся и дальше так работать и денежку мне приноси."));
                textScreen.put("Start_2", new StringBuilder("Так, а теперь к делу. Конструктору совместно с учёными разработали сверхмощную пулемётную установку, но возникли некоторые проблемы. Они не могут завершить последние испытания в связи с возникшими проблемами. Им не хватает какого-то фрагмента. Они передали мне необходимые данные, что им требуется."));
                textScreen.put("Start_3", new StringBuilder("Мои ищейки обнаружили что-то похожее по описанию в секторе ПП-09К. Тебе следует туда слетать и обследовать местность."));
                textScreen.put("Start_4", new StringBuilder("По данным ищеек этот объект находится на глубине 3754 метра под залежами кремария. Отправляй своих роботов бурыльщиков и пусть они начинают работать. И не забывай про летающих, они могут нам очень сильно помешать в бурении."));
                textScreen.put("Start_5", new StringBuilder("1. Что-то очень глубоко бурить.\n2. Как я не люблю этих крылатых.\n3. Пулемёт??? Чего же мы сидим? Полетели!!!\n4. Надеюсь, ищейки не ошиблись. Этот сектор очень опасный."));
                textScreen.put("Finish_1", new StringBuilder("Человек, ты его выкопал? Великолепно! Быстрее доставь его в арсенальную. Они уже заждались."));
                textScreen.put("Finish_2", new StringBuilder("Так, они приступили к испытаниям. Давай подождём и узнаем, как у них всё пройдёт. То ли я для них достал."));
                textScreen.put("Finish_3", new StringBuilder("Вау! Человек, у нас всё вышло. В арсенальной тебя ждёт приятный сюрприз."));
                textScreen.put("Finish_4", new StringBuilder("1. Мы это сделали!\n2. А вот сюрпризы я люблю.\n3. Скорее покажите мне эту пушку.\n4. Р-7, поучиться бы тебе у конструкторов."));
            } else {
                textScreen.put("Start_1", new StringBuilder("Man, the goods have been successfully delivered. The customer is very pleased with the product and my trouble-free work. Try and continue to work like this and give me money."));
                textScreen.put("Start_2", new StringBuilder("The designer together with scientists developed a super-powerful machine gun installation, but some problems arose. They can not complete the final test. They have problems. They lack a fragment. They gave me the necessary data that they need."));
                textScreen.put("Start_3", new StringBuilder("My bloodhounds found something similar to the description in the PP-09K sector. You should go there and explore the area."));
                textScreen.put("Start_4", new StringBuilder("According to the bloodhounds this object is located at a depth of 3754 meters under the cremaria deposits. Send your robots borers and let them begin to work. And do not forget about flying, they can greatly hinder us in drilling."));
                textScreen.put("Start_5", new StringBuilder("1. Something very deep to drill.\n2. How I do not like these winged ones.\n3. The machine gun??? What are we sitting on? Have departed!!!\n4. I hope the bloodhounds were not mistaken. This sector is very dangerous."));
                textScreen.put("Finish_1", new StringBuilder("Man, did you dig it out? Sumptuously! Quickly get him into the arsenal. They were already waiting."));
                textScreen.put("Finish_2", new StringBuilder("They began to test. Let's wait and find out how they will go. I hope I got what they need."));
                textScreen.put("Finish_3", new StringBuilder("Wow! Man, we got it. In arsenal you are waiting for a pleasant surprise."));
                textScreen.put("Finish_4", new StringBuilder("1. We did it!\n2. I like surprises.\n3. Quickly show me this gun.\n4. R-7, you would like to learn from the designers."));
            }
            //endregion
        } else if (mission.equals("Missions_3_4")) {
            //region code
            if (MarsGame.getPreference().language().equals("ru")) {
                textScreen.put("Start_1", new StringBuilder("Я очень доволен твоими успехами в выполнении несложных миссий. Сегодня тебя ждёт простенькая работёнка по добыче кремария. Нужно уже приступать к заполнению наших складов, чтобы сразу отправить его к заказчику."));
                textScreen.put("Start_2", new StringBuilder("Высаживайся в зоне ПК-117м и приступай к бурению. Ищейки докладывают об активности насекомых в этой зоне. Но тебя не должно это беспокоить. Ты прошёл через многие битвы и эту должен пройти с успехом."));
                textScreen.put("Start_3", new StringBuilder("&* &<%:0#-,,*! ;%+=-$<# -#m#dbq#--% -/iu ;q/-#<u! =q= m* &*-u0db#-* &/3 u-=4<%0=<$!"));
                textScreen.put("Start_4", new StringBuilder("Ты ещё кто такой и чего там бормочешь? Эй, чего не отвечаем? (сигнал утерян)"));
                textScreen.put("Start_5", new StringBuilder("А я уже подумал, что меня испугался."));
                textScreen.put("Start_6", new StringBuilder("1. Интересно, что он хотел...\n2. Это ещё кто был?\n3. Какой он агрессивный. Р-7, видимо твой обманутый заказчик.\n4. Отправь сообщение расшифровщикам. Нужно узнать кто он."));
                textScreen.put("Finish_1", new StringBuilder("Человек, я выяснил чего он хотел от тебя."));
                textScreen.put("Finish_2", new StringBuilder("Это был разумный марсианин и ему не нравятся твои действия по добыче кремария. И ещё что-то говорил про твою смерть."));
                textScreen.put("Finish_3", new StringBuilder("Думаю, не стоит обращать внимания на его пустые угрозы и продолжать свою миссию."));
                textScreen.put("Finish_4", new StringBuilder("1. Я с тобой полностью согласен.\n2. Стоп, стоп, стоп! Что там про мою смерть?!\n3. Пусть только сунется и я с ним покончу.\n4. Разумный? И у них есть подобные технологии?"));
            } else {
                textScreen.put("Start_1", new StringBuilder("I am very pleased with your success in carrying out simple missions. Today you are waiting for a simple job to extract cremaria. We need to start filling out our warehouses to immediately send it to the customer."));
                textScreen.put("Start_2", new StringBuilder("Land in the area of the PK-117m and start drilling. Bloodhounds report the activity of insects in this zone. But you should not be bothered. You have gone through many battles and this one must pass with success."));
                textScreen.put("Start_3", new StringBuilder("&* &<%:0#-,,*! ;%+=-$<# -#m#dbq#--% -/iu ;q/-#<u! =q= m* &*-u0db#-* &/3 u-=4<%0=<$!"));
                textScreen.put("Start_4", new StringBuilder("Who are you and what are you mumbling about? Hey, why do not we answer? (the signal is lost)"));
                textScreen.put("Start_5", new StringBuilder("And I already thought that I was frightened."));
                textScreen.put("Start_6", new StringBuilder("1. I wonder what he wanted...\n2. Who was it?\n3. How aggressive he is. R-7, apparently your deceived customer.\n4. Send a message to the decrypters. It is necessary to find out who he is."));
                textScreen.put("Finish_1", new StringBuilder("Man, I found out what he wanted from you."));
                textScreen.put("Finish_2", new StringBuilder("He was a reasonable Martian and he does not like your actions for the extraction of cremaria. And he said something about your death."));
                textScreen.put("Finish_3", new StringBuilder("I think we should not pay attention to his empty threats and continue his mission."));
                textScreen.put("Finish_4", new StringBuilder("1. I completely agree with you.\n2. Stop, stop, stop! What is there about my death ?!\n3. Let it just stick and I'll finish it.\n4. Reasonable? And they have similar technology?"));
            }
            //endregion
        } else if (mission.equals("Missions_3_5")) {
            //region code
            if (MarsGame.getPreference().language().equals("ru")) {
                textScreen.put("Start_1", new StringBuilder("Что тут происходит? Мои локаторы сходят с ума. Эти марсианские насекомые собираются в одну большую колонию. И это всё неспроста. Я предполагаю, что они хотят помешать добывать мой кремарий. У них ничего не выйдет! У меня есть план и ты, человек, в нём играешь главную роль."));
                textScreen.put("Start_2", new StringBuilder("Я вас предупреждал покинуть нашу планету. Но вы меня ослушались и продолжили уничтожать наши земли! Приготовьтесь к своей смерти!"));
                textScreen.put("Start_3", new StringBuilder("Он опять с нами связался и пытается меня запугать. Но он не знает, с кем связался. Человек, отправляйся в зону высадки, укрепи свои позиции и отправляйся в атаку. Покажи им мою мощь и истреби их всех!"));
                textScreen.put("Start_4", new StringBuilder("Эй, монстр, ты меня не запугаешь своими угрозами. Жди от меня подарочек, он уже в пути. Мой человек разнесёт тебя в щепки и ты пожалеешь, что связался со мной."));
                textScreen.put("Start_5", new StringBuilder("1. Покажем ему кто мы такие!\n2. Опять мне за тебя всё расхлёбывать.\n3. Сейчас я ему надеру задницу!\n4. Р-7, повысь защиту силового поля станции и следи за радарами."));
                textScreen.put("Finish_1", new StringBuilder("Вы, вы... Заплатите за свою дерзость. Я вернусь со своими братьями и вы больше не увидите лучей Солнца!"));
                textScreen.put("Finish_2", new StringBuilder("Ой, ой, как мне страшно. Улетай, пока я добрый и больше не возвращайся. Сколько бы вас ни было, я со всеми разберусь!"));
                textScreen.put("Finish_3", new StringBuilder("... (конец связи)"));
                textScreen.put("Finish_4", new StringBuilder("Отличная победа! Он не ожидал такого отпора, а их численность значительно уменьшилась. Просто великолепно! А в знак победы, я подготовил для тебя сюрприз. Он ждёт тебя в арсенальной."));
                textScreen.put("Finish_5", new StringBuilder("1. Он был сильным, но не достаточно, чтобы нас сокрушить.\n2. Я думал, мы не одержим победу.\n3. Я ожидал настоящей битвы, а он оказался слабаком.\n4. Это не последнее сражение. Он может снова напасть."));
            } else {
                textScreen.put("Start_1", new StringBuilder("What's going on here? My locators go crazy. These Martian insects gather in one large colony. And this is no accident. I guess they want to stop getting my cremaria. They will not do anything! Man, I have a plan and you play the main role in it."));
                textScreen.put("Start_2", new StringBuilder("I warned you to leave our planet. But you disobeyed me and continued to destroy our lands! Prepare for your death!"));
                textScreen.put("Start_3", new StringBuilder("He again contacted us and trying to intimidate me. But he does not know who he contacted. Man, go to the landing zone, strengthen your position and go on the attack. Show them my power and destroy them all!"));
                textScreen.put("Start_4", new StringBuilder("Hey, monster, you do not intimidate me with your threats. Wait for me a gift, he is on his way. My man will smash you into chips and you'll regret contacting me."));
                textScreen.put("Start_5", new StringBuilder("1. Show him who we are!\n2. Again, I'll chop everything off for you.\n3. Now I'll kick his ass!\n4. R-7, increase the protection of the force field of the station and follow the radar."));
                textScreen.put("Finish_1", new StringBuilder("You, you ... Pay for your impudence. I will return with my brothers and you will no longer see the rays of the Sun!"));
                textScreen.put("Finish_2", new StringBuilder("Oh, oh, how scared I am. Fly away, while I am kind and do not return. No matter how you are, I'll deal with everyone!"));
                textScreen.put("Finish_3", new StringBuilder("... (end of communication)"));
                textScreen.put("Finish_4", new StringBuilder("Excellent victory! He did not expect such a rebuff, and their numbers decreased significantly. Just wonderful! And as a token of victory, I prepared a surprise for you. He is waiting for you in the arsenal."));
                textScreen.put("Finish_5", new StringBuilder("1. He was strong, but not enough to crush us.\n2. I thought we would not win.\n3. I was expecting a real battle, and he was weak.\n4. This is not the last battle. He can attack again."));
            }
            //endregion
        } else if (mission.equals("Missions_3_6")) {
            //region code
            if (MarsGame.getPreference().language().equals("ru")) {
                textScreen.put("Start_1", new StringBuilder("Сегодня ваш последний день в этой солнечной системе! Вас никто не спасёт. Мои собратья требуют вашей плоти. Они разорвут ваши тела и вы станете частью звёздной пыли."));
                textScreen.put("Start_2", new StringBuilder("Ты всё-таки вернулся за своей смертью? Ну, раз ты этого желаешь, пусть так оно и будет. Но знай, я не хотел этого делать, ты меня вынуждаешь."));
                textScreen.put("Start_3", new StringBuilder("Знай своё место, недоразвитое существо! Мы никого из вас не оставим в живых!"));
                textScreen.put("Start_4", new StringBuilder("Видимо тебе прошлого урока было мало? Ты до меня не сможешь добраться, а своего человека я всегда могу заменить другим. (конец связи)"));
                textScreen.put("Start_5", new StringBuilder("Человек, отправляйся на Марс и расправься, наконец, с этим товарищем. Он уже начинает меня раздражать. Покажи ему на силу и непобедимый дух землян!"));
                textScreen.put("Start_6", new StringBuilder("1. Пора с ним нам разобраться.\n2. Что значит - заменишь? Я помирать не хочу!\n3. Ну, давай посмотрим, кто кого уделает!\n4. С новым оружием мы быстро с ним расправимся."));
                textScreen.put("Finish_1", new StringBuilder("Я вас недооценил, но больше ошибок я не допущу."));
                textScreen.put("Finish_2", new StringBuilder("Человек, он удирает! Держи его!"));
                textScreen.put("Finish_3", new StringBuilder("Человек, откуда у тебя руки растут? Как можно было его второй раз упустить? Как теперь мне с такими вестями с землянами связываться? Как бы они меня не понизили до бурыльщика."));
                textScreen.put("Finish_4", new StringBuilder("1. Пусть уходит, главное мы территорию отбили.\n2. Главное со мной всё в порядке.\n3. Мы с ним ещё повидаемся и тогда уже настанет его конец.\n4. Докладывай как есть, они должны обо всё знать."));
            } else {
                textScreen.put("Start_1", new StringBuilder("Today is your last day in this solar system! No one will save you. My brethren demand your flesh. They will tear your bodies apart and you will become part of the stellar dust."));
                textScreen.put("Start_2", new StringBuilder("You still came back for your death? Well, if that's what you want, let it be so. But know, I did not want to do this, you force me."));
                textScreen.put("Start_3", new StringBuilder("Know your place, an underdeveloped being! We will not leave any of you alive!"));
                textScreen.put("Start_4", new StringBuilder("Apparently the last lesson was not enough for you? You can not reach me, but I can always replace my man with another person. (end of communication)"));
                textScreen.put("Start_5", new StringBuilder("Man, go to Mars and deal with this comrade. He is already beginning to annoy me. Show him the power and unconquerable spirit of earthlings!"));
                textScreen.put("Start_6", new StringBuilder("1. It's time to deal with him.\n2. What do you mean, replace it? I do not want to die!\n3. Well, let's see who wins!\n4. With a new weapon, we will quickly deal with it."));
                textScreen.put("Finish_1", new StringBuilder("I underestimated you, but I will not make more mistakes."));
                textScreen.put("Finish_2", new StringBuilder("Man, he's getting away! Hold it!"));
                textScreen.put("Finish_3", new StringBuilder("Man, where do your hands grow? How could I miss it a second time? How now do I have to communicate with such earthlings? As if they did not lower me to the borer."));
                textScreen.put("Finish_4", new StringBuilder("1. Let him leave, the main thing we have repulsed the territory.\n2. The main thing with me is all right.\n3. We will see him and then his end will come.\n4. Report as is, they have to know everything."));
            }
            //endregion
        }
        //endregion
        //region 4
        else if (mission.equals("Missions_4_1")) {
            //region code
            if (MarsGame.getPreference().language().equals("ru")) {
                textScreen.put("Start_1", new StringBuilder("Человек, пришёл приказ землян – устранить марсианскую угрозу или взять его живым. Я с ними полностью согласен и поддерживаю инициативу устранить его. Он нанёс достаточно много ущерба и мы терпим убытки из-за сроков добычи кремария."));
                textScreen.put("Start_2", new StringBuilder("После последнего его нападения, мои ищейки стали следить за ним. Они докладывают, что он спрятался в пещере в зоне АА-107. Ни мои датчики, ни ищейки не можем определить глубину этой пещеры и где засел этот ублюдок. Если бы его тогда не упустил, мне бы не пришлось тратить время на его поиски и поимку."));
                textScreen.put("Start_3", new StringBuilder("Вы думали, я не узнаю, что вы послали своих шпионов следить за мной? *Устрашающий смех* Я специально завёл вас в свою ловушку. Отсюда вы никогда не выберетесь и это место станет вашей гробницей. Если конечно до этого момента вас не съедят мои собратья."));
                textScreen.put("Start_4", new StringBuilder("Ты нас не запугаешь. У меня навороченная аппаратура, благодаря которой ты не смог скрыться. И эта твоя ловушка для нас будет твоей погибелью. Загнан в тупик ты, а не я."));
                textScreen.put("Start_5", new StringBuilder("Какое ты самоуверенное ничтожество. Но тебе осталось не долго существовать. Я об этом лично позабочусь. (конец связи)"));
                textScreen.put("Start_6", new StringBuilder("Человек, ты это слышал? Не стоит его оставлять в живых. Приоритет – устранить!"));
                textScreen.put("Start_7", new StringBuilder("1. Может стоит его поймать и допросить?\n2. Не стоило его преследовать, я тут помирать не хочу.\n3. Р-7, только дай мне его координаты и я с ним быстро расправлюсь!\n4. Р-7, с каких пор у тебя всё работает? Постоянно ломаешься."));
                textScreen.put("Finish_1", new StringBuilder("Вот это он спрятался в этом лабиринте. Придётся идти дальше вслепую, пока мои локаторы не найдут его местоположение."));
                textScreen.put("Finish_2", new StringBuilder("Я отправил своих ищеек в несколько туннелей. Это позволит ускорить его поиски и быстрее с этим покончить. А то тут какое-то странное чувство, что со всех сторон за тобой кто-то наблюдает."));
                textScreen.put("Finish_3", new StringBuilder("1. Он нас боится, вот поэтому и скрывается.\n2. Я бы не стал заходить глубже.\n3. Он только отдаляет свою смерть.\n4. Смотри не потеряй своих ищеек."));
            } else {
                textScreen.put("Start_1", new StringBuilder("Man, the order of the Earthmen came to eliminate the Martian threat or take it alive. I fully agree with them and support the initiative to eliminate it. He caused quite a lot of damage and we suffer losses because of the timing of the cremaria."));
                textScreen.put("Start_2", new StringBuilder("After the last attack, my bloodhounds began to follow him. They report that he hid in a cave in the AA-107 zone. Neither my sensors nor the bloodhounds can determine the depth of this cave and where this bastard sat. If he did not then miss, I would not have to waste time searching for him and catching him."));
                textScreen.put("Start_3", new StringBuilder("You thought I did not find out that you sent your spies to follow me? *Awe-inspiring laughter* I deliberately took you into my trap. From here you will never get out and this place will be your tomb. If until this point you will not eat my brethren."));
                textScreen.put("Start_4", new StringBuilder("You do not intimidate us. I have fancy hardware, thanks to which you could not hide. And this trap for you will be your ruin. You're stymied, not me."));
                textScreen.put("Start_5", new StringBuilder("What an arrogant jerk you are. But you do not have long to exist. I will personally take care of this. (end of communication)"));
                textScreen.put("Start_6", new StringBuilder("Man, did you hear that? Do not leave him alive. Priority - eliminate!"));
                textScreen.put("Start_7", new StringBuilder("1. Can it is necessary to catch and interrogate it?\n2. It was not worth pursuing him, I do not want to die here.\n3. R-7, just give me his coordinates and I will quickly deal with it!\n4. R-7, since when does it work for you? Constantly break."));
                textScreen.put("Finish_1", new StringBuilder("That's it he hid in this labyrinth. I'll have to go further blindly, until my locators find its location."));
                textScreen.put("Finish_2", new StringBuilder("I sent my bloodhounds to several tunnels. This will speed up his search and quickly finish it. And then there is some strange feeling that someone is watching from all sides."));
                textScreen.put("Finish_3", new StringBuilder("1. He is afraid of us, that's why he is hiding.\n2. I would not go deeper.\n3. He only removes his death.\n4. Do not lose your bloodhounds."));
            }
            //endregion
        } else if (mission.equals("Missions_4_2")) {
            //region code
            if (MarsGame.getPreference().language().equals("ru")) {
                textScreen.put("Start_1", new StringBuilder("Что-то мы не туда свернули. Или мы здесь уже были? Так, давай остановимся и обмозгуем дальнейшие действия. Эта пещера такая однообразная, что в ней легко заблудиться. Но со мной не пропадёшь."));
                textScreen.put("Start_2", new StringBuilder("Наши запасы почти иссякли. Нужно пополнить запасы кремария, иначе нас будет легко сломить. Да и в этих пещерах особо не найдёшь кремария. Неподалёку от базы есть залежи кремария, но его очень мало. Но хоть что-то."));
                textScreen.put("Start_3", new StringBuilder("Человек, быстрее собери кремарий. Немного пополним свои запасы и выдвинемся дальше. К этому моменту некоторые из моих ищеек должны вернуться. Может они чего-нибудь нашли."));
                textScreen.put("Start_4", new StringBuilder("1. Ну, давай соберём хоть что есть.\n2. Что-то твои ищейки долго.\n3. Надеюсь, они найдут его, а то я уже заждался.\n4. Р-7, меньше трать кремарий! Его не так просто добывать."));
                textScreen.put("Finish_1", new StringBuilder("Мало кремария, но ничего не поделаешь. Этого думаю, хватит до следующей остановки."));
                textScreen.put("Finish_2", new StringBuilder("Откуда повылазила эта шустрая мелкота? Их было так много, но смысла в их нападении не было. Меня таким не возьмёшь. Только зря наше время потратили. Или им это и надо было?"));
                textScreen.put("Finish_3", new StringBuilder("1. Видимо хотели нас задержать.\n2. Мелкие, но быстрые. Почти все боеприпасы потратил.\n3. У них уже нет сил противостоять нам.\n4. Что же марсианин задумал..."));
            } else {
                textScreen.put("Start_1", new StringBuilder("Something we did not go there. Or were we here already? So, let's stop and grind further actions. This cave is so monotonous that it is easy to get lost in it. But with me you will not perish."));
                textScreen.put("Start_2", new StringBuilder("Our reserves are almost exhausted. We need to replenish the stock of cremaria, otherwise it will be easy for us to break. And in these caves you will not find a cremaria. Not far from the base there are cremaria deposits, but it is very small. But at least something."));
                textScreen.put("Start_3", new StringBuilder("Man, quickly assemble the cremaria. Fill up our stocks a little and move forward. By this point, some of my bloodhounds should return. Maybe they found something."));
                textScreen.put("Start_4", new StringBuilder("1. Well, let's assemble though that is.\n2. Something's your bloodhound for a long time.\n3. I hope they find it, otherwise I've been waiting.\n4. R-7, less wasting the cremaria! It is not so easy to extract."));
                textScreen.put("Finish_1", new StringBuilder("Little cremaria, but there's nothing to be done. I think that's enough for the next stop."));
                textScreen.put("Finish_2", new StringBuilder("Where did this little nimble come from? There were so many of them, but there was no sense in their attack. I do not take such a thing. Only wasting our time. Or did they need it?"));
                textScreen.put("Finish_3", new StringBuilder("1. Apparently they wanted to detain us.\n2. Small, but fast. Almost all the ammunition was spent.\n3. They no longer have the strength to resist us.\n4. What did the Martian conceive..."));
            }
            //endregion
        } else if (mission.equals("Missions_4_3")) {
            //region code
            if (MarsGame.getPreference().language().equals("ru")) {
                textScreen.put("Start_1", new StringBuilder("Я не могу связаться с одной из своих ящеек. Связь была неожиданно прервана, и я не могу её восстановить. Возможно, это из-за особой конструкции коридоров и материалов, из которых всё тут слеплено."));
                textScreen.put("Start_2", new StringBuilder("Что?!?! Я потерял связь почти со всеми своими ищейками. Только одна, неподалёку от нас, всё ещё передаёт данные местности. Нужно срочно возвращать её на базу, пока и её не потеряли."));
                textScreen.put("Start_3", new StringBuilder("*Грозный смех* Что недоразвитые существа, впали в панику и уже боитесь за свою жизнь? Вижу, вы оценили мои маленькие проделки. Я специально ждал, когда вы зайдёте как можно глубже в её дом, чтобы её дети вас прикончили. А чтобы было на это веселее смотреть, я позаботился о ваших железных существах."));
                textScreen.put("Start_4", new StringBuilder("Ты поплатишься за их смерть! Они же были мне родными и выполняли все мои поручения. Без них мы не сможем выбраться из этого места."));
                textScreen.put("Start_5", new StringBuilder("Трупам они больше не понадобятся. Я позаботился на тот случай, если вы решите сбежать. Не хорошо когда моя жертва не хочет погибать."));
                textScreen.put("Start_6", new StringBuilder("Человек, моя уцелевшая ищейка добралась до базы, но сильно повреждена. Пока её не починят, мы не можем выдвигаться дальше вслепую. Придётся тебе это время защищать базу от всех угроз."));
                textScreen.put("Start_7", new StringBuilder("1. Я уже выставил укрепления.\n2. Он наступает со всех сторон!\n3. Я даже вслепую разгромлю любого противника!\n4. Р-7, принимай участие в починке ищейки,\nиначе мы здесь затеряемся."));
                textScreen.put("Finish_1", new StringBuilder("Я, наконец, починил ищейку, теперь она как новая и готова продолжить сканировать эти катакомбы."));
                textScreen.put("Finish_2", new StringBuilder("Человек, быстрее сваливаем с этого места, пока не пришло их подкрепление. Отправляемся к последнему местоположению ищейки И-03. По полученным данным там был тот ублюдок."));
                textScreen.put("Finish_3", new StringBuilder("Рад сообщить, что нам удалось разработать технологии для модернизации турелей. Теперь мы можем устанавливать на местностях вокруг базы более мощные турели."));
                textScreen.put("Finish_4", new StringBuilder("1. Отлично, одна ищейка уцелела.\n2. Быстрее сваливаем!\n3. Модернизация турелей? Как же я этого ждал.\n4. Р-7, не потеряй нашу последнюю надежду выбраться из этого лабиринта."));
            } else {
                textScreen.put("Start_1", new StringBuilder("I can not contact one of my squads. The connection was suddenly interrupted, and I can not recover it. Perhaps this is because of the special design of the corridors and materials, of which everything is fixed here."));
                textScreen.put("Start_2", new StringBuilder("What?!?! I lost touch with almost all of my bloodhounds. Only one, not far from us, still transmits terrain data. We need to urgently return it to the base, until it is lost."));
                textScreen.put("Start_3", new StringBuilder("*Terrible laughter* What are the underdeveloped beings, panicking and already afraid for their lives? I see you appreciated my little tricks. I specifically waited for you to go as deeper into her house as possible, so that her children would finish you off. And to make it more fun to watch, I took care of your iron creatures."));
                textScreen.put("Start_4", new StringBuilder("You will pay for their death! They were my relatives and fulfilled all my instructions. Without them, we can not get out of this place."));
                textScreen.put("Start_5", new StringBuilder("They will no longer need corpses. I took care in case you decide to escape. It's not good when my victim does not want to die."));
                textScreen.put("Start_6", new StringBuilder("Man, my surviving bloodhound got to the base, but badly damaged. Until it is repaired, we can not go further than blind. You have to defend this base from all threats."));
                textScreen.put("Start_7", new StringBuilder("1. I have already put up fortifications.\n2. It comes from all sides!\n3. I even blindly destroy any enemy!\n4. R-7, take part in repairing the sniffer,\notherwise we will get lost here."));
                textScreen.put("Finish_1", new StringBuilder("I finally fixed the sniffer, now it's like new and ready to continue scanning these catacombs."));
                textScreen.put("Finish_2", new StringBuilder("Man, we quickly dump from this place, until their reinforcement came. We go to the last location of the I-03. According to the information received there was that bastard."));
                textScreen.put("Finish_3", new StringBuilder("I'm glad to inform that we managed to develop technologies for modernization of turrets. Now we can establish more powerful turrets on the terrain around the base."));
                textScreen.put("Finish_4", new StringBuilder("1. Excellent, one bloodhound survived.\n2. Faster we dump!\n3. Modernization of turrets? How I waited for this.\n4. R-7, do not lose our last hope of getting out of this labyrinth."));
            }
            //endregion
        } else if (mission.equals("Missions_4_4")) {
            //region code
            if (MarsGame.getPreference().language().equals("ru")) {
                textScreen.put("Start_1", new StringBuilder("Какие вы всё-таки живучие или просто упрямцы, которые не хотят умирать. Но ваша участь уже предрешена и от неё не уйти. В этом доме ваш путь и закончится."));
                textScreen.put("Start_2", new StringBuilder("Напал на нас, не даёшь нам выполнять нашу работу и добывать кремарий для спасения человечества. У нас есть цель и мы будем идти к ней."));
                textScreen.put("Start_3", new StringBuilder("Глупые существа! Вы посягнули на наши земли и разоряете их безнаказанно. А это мои земли и я не допущу, чтобы вы их уничтожили."));
                textScreen.put("Start_4", new StringBuilder("Это ты глупый пришелец, раз не понимаешь нашей миссии. Нам больше не о чем говорить. Как мы выберемся отсюда, я самолично надеру тебе зад."));
                textScreen.put("Start_5", new StringBuilder("Вы отсюда не выберетесь! Я об этом позабочусь. *злобный смех*"));
                textScreen.put("Start_6", new StringBuilder("1. Р-7 нас выведет из этого места.\n2. Что ты такой агрессивный?\n3. Что ты вечно прячешься за спинами своих сородичей?\n4. Мы не уничтожаем земли, а берём немного лишнего."));
                textScreen.put("Finish_1", new StringBuilder("Вы за всё ответите, что делаете с нашими сородичами!"));
                textScreen.put("Finish_2", new StringBuilder("Да, да. Нападаешь на нас, вечно угрожаешь, а мы должны молча сидеть? Я найду тебя и не допущу твоего очередного бегства, как это сделал мой человек. Жди меня, я уже рядом."));
                textScreen.put("Finish_3", new StringBuilder("Человек, нам пора сменить пушку на что-то по-настоящему мощное. В арсенале тебя ждёт новая игрушка."));
                textScreen.put("Finish_4", new StringBuilder("1. Р-7, вместе мы его одолеем.\n2. Р-7, вот ты и сражайся с ним. Нечего меня вечно посылать.\n3. Я люблю новые мощные игрушки =)\n4. Р-7, что там с выходом? У нас уже ресурсы на исходе."));
            } else {
                textScreen.put("Start_1", new StringBuilder("What you are still tenacious or just stubborn, who do not want to die. But your fate is already sealed and it can not escape from it. In this house your path will end."));
                textScreen.put("Start_2", new StringBuilder("Attacked us, you do not allow us to do our work and get a cremaria for the salvation of mankind. We have a goal and we will go to her."));
                textScreen.put("Start_3", new StringBuilder("Stupid creatures! You encroached on our lands and ruined them with impunity. These are my lands and I will not allow you to destroy them."));
                textScreen.put("Start_4", new StringBuilder("You are a stupid alien, since you do not understand our mission. We have nothing more to talk about. As we get out of here, I'll kick your ass."));
                textScreen.put("Start_5", new StringBuilder("You can not get out of here! I'll take care of it. *evil laugh*"));
                textScreen.put("Start_6", new StringBuilder("1. R-7 will lead us out of this place.\n2. What are you so aggressive about?\n3. What are you always hiding behind the backs of your relatives?\n4. We do not destroy the land, but take a little extra."));
                textScreen.put("Finish_1", new StringBuilder("You will answer for everything that you do with our relatives!"));
                textScreen.put("Finish_2", new StringBuilder("Yes Yes. You attack us, you always threaten, but we must sit silently? I will find you and will not allow your next flight, as my man did. Wait for me, I'm near."));
                textScreen.put("Finish_3", new StringBuilder("Man, it's time for us to change the cannon to something really powerful. In the arsenal of you waiting for a new toy."));
                textScreen.put("Finish_4", new StringBuilder("1. Р-7, together we will overcome it.\n2. R-7, here you are and fight with it. There's nothing to send me forever.\n3. I love the new powerful toys =)\n4. R-7, what's out there? We already have resources at the end."));
            }
            //endregion
        } else if (mission.equals("Missions_4_5")) {
            //region code
            if (MarsGame.getPreference().language().equals("ru")) {
                textScreen.put("Start_1", new StringBuilder("Человек, я нашёл огромные запасы кремария. Наконец-таки мы пополним наши запасы."));
                textScreen.put("Start_2", new StringBuilder("Я уже решил, что истратим все ресурсы и правда останемся в этих катакомбах навсегда. Но, благодаря мне, мы отсюда скоро выберемся."));
                textScreen.put("Start_3", new StringBuilder("Как вы посмели посягнуть на наши запасы?! Они предназначены для матери этого дома. Я не позволю их тронуть!"));
                textScreen.put("Start_4", new StringBuilder("Человек, не слушай его и спокойно приступай добывать кремарий. И для моей безопасности лучше усиль оборону базы. Как-то не хочется, чтобы кто-то из них пробрался в базу."));
                textScreen.put("Start_5", new StringBuilder("1. Будет сделано.\n2. Как я знал, что лучше было не трогать этот кремарий.\n3. Мимо меня никто не пройдёт.\n4. Это их склад для матери? Чую скоро она нас посетит."));
                textScreen.put("Finish_1", new StringBuilder("Нееет, я не смог уберечь её запасы. Вы за это ответите!!!"));
                textScreen.put("Finish_2", new StringBuilder("Они лежали заветренные, никто их не трогал. Ну не пропадать ведь добру."));
                textScreen.put("Finish_3", new StringBuilder("Человек, я надеюсь, ты не забываешь про модернизацию турелей? Без них нам будет очень туго сражаться. Смотри, не подводи меня."));
                textScreen.put("Finish_4", new StringBuilder("1. Было ничьё, стало нашим.\n2. Не стоило этого делать.\n3. Р-7, у меня всегда самое последнее и лучшее.\n4. Р-7, где выход уже, наконец?"));
            } else {
                textScreen.put("Start_1", new StringBuilder("Man, I found a huge supply of cremaria. Finally, we will replenish our reserves."));
                textScreen.put("Start_2", new StringBuilder("I have already decided that we will spend all resources and really stay in these catacombs forever. Thanks to me, we will soon get out of here."));
                textScreen.put("Start_3", new StringBuilder("How dare you attack our reserves ?! They are for the mother of this house. I will not let them touch!"));
                textScreen.put("Start_4", new StringBuilder("Man, do not listen to him and calmly start to get a cremaria. And for my security better strengthen the defense base. Somehow I do not want any of them to get into the base."));
                textScreen.put("Start_5", new StringBuilder("1. It will be done.\n2. How I knew that it was better not to touch this cremaria.\n3. No one will pass by me.\n4. Is this their store for the mother? I feel soon she will visit us."));
                textScreen.put("Finish_1", new StringBuilder("Nooo, I could not save her supplies. You will answer for this!!!"));
                textScreen.put("Finish_2", new StringBuilder("They lay winded, no one touched them. Well, do not disappear because good."));
                textScreen.put("Finish_3", new StringBuilder("Man, I hope you do not forget about upgrading turrets? Without them, we will struggle very hard. Look, do not let me down."));
                textScreen.put("Finish_4", new StringBuilder("1. It was a draw, it was ours.\n2. Do not do it.\n3. R-7, I always have the latest and best.\n4. R-7, where is the exit already, finally?"));
            }
            //endregion
        } else if (mission.equals("Missions_4_6")) {
            //region code
            if (MarsGame.getPreference().language().equals("ru")) {
                textScreen.put("Start_1", new StringBuilder("Я, кажется, вижу выход из этой не проходимой пещеры. Вон там, вдали, виднеются лучи света. Дааа! Это выход."));
                textScreen.put("Start_2", new StringBuilder("Стой человек! Там что-то большое преграждает дорогу и оно живое."));
                textScreen.put("Start_3", new StringBuilder("Это ваш конец! Не стоило приходить сюда, убивать её детей и крась запасы еды. Вы сильно разгневали мать этого дома, что она решила самолично с вами разобраться."));
                textScreen.put("Start_4", new StringBuilder("Человек, сделай что-нибудь. Нам нужно любой ценой выбраться, но я должен уцелеть. Используй все, что у тебя есть и пробей нам путь к выходу."));
                textScreen.put("Start_5", new StringBuilder("1. Я сделаю всё, что в моих силах.\n2. А я говорил о последствиях, но меня никто не слушал.\n3. Я сейчас с ней разберусь!\n4. Да откуда вас столько много берётся..."));
                textScreen.put("Finish_1", new StringBuilder("Мать... мать дома убита..."));
                textScreen.put("Finish_2", new StringBuilder("Ты думал такое жалкое и слабое существо сможет со мной тягаться? С ней было справиться легче, чем со всей этими тварями."));
                textScreen.put("Finish_3", new StringBuilder("Я вам этого не прощу! Я вас уничтожу!"));
                textScreen.put("Finish_4", new StringBuilder("Вот чего ты разорался? Её останки пойдут на развитие наших технологий. Как раз нужны ресурсы для завершения испытаний нового оружия."));
                textScreen.put("Finish_5", new StringBuilder("1. Р-7, она и не такая слабая была.\n2. Наконец я снова вижу солнце.\n3. Новые ресурсы, новые испытания, новое вооружение =)\n4. Марсианин, ты не дал нам иного выбора."));
            } else {
                textScreen.put("Start_1", new StringBuilder("I see a way out of this cave that is not passable. There, in the distance, there are rays of light. Yeah! This is the way out."));
                textScreen.put("Start_2", new StringBuilder("Stop the man! There's something big blocking the road and it's alive."));
                textScreen.put("Start_3", new StringBuilder("This is your end! It was not worth coming here, killing her children and painting food supplies. You strongly enraged the mother of this house, that she decided to deal with you personally."));
                textScreen.put("Start_4", new StringBuilder("Man, do something. We need to get out at any cost, but I must survive. Use everything that you have and try to get us out of the way."));
                textScreen.put("Start_5", new StringBuilder("1. I will do everything in my power.\n2. And I talked about the consequences, but no one listened to me.\n3. I'll deal with her now!\n4. Yes, where you are taking so much from..."));
                textScreen.put("Finish_1", new StringBuilder("Mother... mother of the house is killed..."));
                textScreen.put("Finish_2", new StringBuilder("You thought such a pathetic and weak creature could compete with me? It was easier to cope with it than with all these creatures."));
                textScreen.put("Finish_3", new StringBuilder("I will not forgive you for this! I will destroy you!"));
                textScreen.put("Finish_4", new StringBuilder("Is that what you went broke? Its remains will go to the development of our technologies. Just resources are needed to complete the testing of new weapons."));
                textScreen.put("Finish_5", new StringBuilder("1. R-7, it was not so weak either.\n2. Finally I see the sun again.\n3. New resources, new tests, new weapons =)\n4. Martian, you did not give us any other choice."));
            }
            //endregion
        }
        //endregion
    }

    public void gameEnd() {
        if (MarsGame.getPreference().language().equals("ru")) {
            textScreen.put("Home", new StringBuilder("На базу"));
            textScreen.put("Newly", new StringBuilder("Продолжить добычу"));
            textScreen.put("Victory", new StringBuilder("Победа"));
            textScreen.put("Defeat", new StringBuilder("Поражение"));
            textScreen.put("ShowTitleRate", new StringBuilder("Оценка/Отзыв"));
            textScreen.put("ShowTextRate", new StringBuilder("Понравилась игра?\nРасскажи об этом"));
            textScreen.put("ShowClickRate", new StringBuilder("> Написать <"));
        } else {
            textScreen.put("Home", new StringBuilder("On the base"));
            textScreen.put("Newly", new StringBuilder("Continue the booty"));
            textScreen.put("Victory", new StringBuilder("Victory"));
            textScreen.put("Defeat", new StringBuilder("Defeat"));
            textScreen.put("ShowTitleRate", new StringBuilder("Rating/Feedback"));
            textScreen.put("ShowTextRate", new StringBuilder("Did you like the game?\nTell all about it."));
            textScreen.put("ShowClickRate", new StringBuilder("> Do it <"));
        }
    }

    public void menu() {
        if (MarsGame.getPreference().language().equals("ru")) {
            textScreen.put("Hangar", new StringBuilder("Ангар"));
            textScreen.put("Bridge", new StringBuilder("Мостик"));
            textScreen.put("Arsenal", new StringBuilder("Арсенал"));
            textScreen.put("Laboratory", new StringBuilder("Лаборатория"));
            textScreen.put("Reactor", new StringBuilder("Реактор"));
        } else {
            textScreen.put("Hangar", new StringBuilder("Hangar"));
            textScreen.put("Bridge", new StringBuilder("Bridge"));
            textScreen.put("Arsenal", new StringBuilder("Arsenal"));
            textScreen.put("Laboratory", new StringBuilder("Laboratory"));
            textScreen.put("Reactor", new StringBuilder("Reactor"));
        }
    }

    public void gameScreen() {
        if (MarsGame.getPreference().language().equals("ru")) {
            textScreen.put("Menu", new StringBuilder("Меню"));
            textScreen.put("Missions", new StringBuilder("Миссии"));
            textScreen.put("MissionPlay-1", new StringBuilder("Местность 1-"));
            textScreen.put("MissionPlay-2", new StringBuilder("Местность 2-"));
            textScreen.put("MissionPlay-3", new StringBuilder("Местность 3-"));
            textScreen.put("MissionPlay-4", new StringBuilder("Местность 4-"));
            textScreen.put("OnOff", new StringBuilder("Вкл/Выкл"));
            textScreen.put("Details", new StringBuilder("Детали"));
            textScreen.put("Start", new StringBuilder("Начать"));
            textScreen.put("ComingSoon", new StringBuilder("Идёт сканирование\nместности..."));
            textScreen.put("ComingSoon2", new StringBuilder("Скоро появятся"));
            textScreen.put("MenuButtonsText", new StringBuilder("* После прохождения миссии 1 будут открыты все каюты корабля"));
        } else {
            textScreen.put("Menu", new StringBuilder("Menu"));
            textScreen.put("Missions", new StringBuilder("Missions"));
            textScreen.put("MissionPlay-1", new StringBuilder("Terrain 1-"));
            textScreen.put("MissionPlay-2", new StringBuilder("Terrain 2-"));
            textScreen.put("MissionPlay-3", new StringBuilder("Terrain 3-"));
            textScreen.put("MissionPlay-4", new StringBuilder("Terrain 4-"));
            textScreen.put("OnOff", new StringBuilder("On/Off"));
            textScreen.put("Details", new StringBuilder("Details"));
            textScreen.put("Start", new StringBuilder("Start"));
            textScreen.put("ComingSoon", new StringBuilder("Scanning terrain..."));
            textScreen.put("ComingSoon2", new StringBuilder("Coming soon"));
            textScreen.put("MenuButtonsText", new StringBuilder("* After completing mission 1, all the ship's cabins will be opened"));
        }
        textScreen.put("Mission-1-1", new StringBuilder("1"));
        textScreen.put("Mission-1-2", new StringBuilder("2"));
        textScreen.put("Mission-1-3", new StringBuilder("3"));
        textScreen.put("Mission-1-4", new StringBuilder("4"));
        textScreen.put("Mission-1-5", new StringBuilder("5"));
        textScreen.put("Mission-1-6", new StringBuilder("6"));
        textScreen.put("Mission-2-1", new StringBuilder("7"));
        textScreen.put("Mission-2-2", new StringBuilder("8"));
        textScreen.put("Mission-2-3", new StringBuilder("9"));
        textScreen.put("Mission-2-4", new StringBuilder("10"));
        textScreen.put("Mission-2-5", new StringBuilder("11"));
        textScreen.put("Mission-2-6", new StringBuilder("12"));
        textScreen.put("Mission-3-1", new StringBuilder("13"));
        textScreen.put("Mission-3-2", new StringBuilder("14"));
        textScreen.put("Mission-3-3", new StringBuilder("15"));
        textScreen.put("Mission-3-4", new StringBuilder("16"));
        textScreen.put("Mission-3-5", new StringBuilder("17"));
        textScreen.put("Mission-3-6", new StringBuilder("18"));
        textScreen.put("Mission-4-1", new StringBuilder("19"));
        textScreen.put("Mission-4-2", new StringBuilder("20"));
        textScreen.put("Mission-4-3", new StringBuilder("21"));
        textScreen.put("Mission-4-4", new StringBuilder("22"));
        textScreen.put("Mission-4-5", new StringBuilder("23"));
        textScreen.put("Mission-4-6", new StringBuilder("24"));
    }

    public void bridgeScreen() {
        if (MarsGame.getPreference().language().equals("ru")) {
            textScreen.put("ShieldHPAdd", new StringBuilder("Запросить щит"));
            textScreen.put("EnergyAdd", new StringBuilder("Запросить генератор"));
            textScreen.put("Microwave", new StringBuilder("Запросить микроволны"));
            textScreen.put("Smugglers", new StringBuilder("Контрабандисты"));
        } else {
            textScreen.put("ShieldHPAdd", new StringBuilder("Request shield"));
            textScreen.put("EnergyAdd", new StringBuilder("Request generator"));
            textScreen.put("Microwave", new StringBuilder("Request microwave"));
            textScreen.put("Smugglers", new StringBuilder("Smugglers"));
        }
    }

    public void arsenalScreen() {
        arsenalScreenTacticsAttack();
        arsenalScreenTacticsDefense();
        arsenalScreenTacticsTechnologies();
        if (MarsGame.getPreference().language().equals("ru")) {
            textScreen.put("OnOff", new StringBuilder("Вкл/Выкл"));
            textScreen.put("MachineGun", new StringBuilder("Пулеметы"));
            textScreen.put("LauncherGun", new StringBuilder("Гранатометы"));
            textScreen.put("FlareGun", new StringBuilder("Ракетницы"));
            textScreen.put("LaserGun", new StringBuilder("Лазеры"));
            textScreen.put("Installed", new StringBuilder("Установлено"));
            textScreen.put("Install", new StringBuilder("Установить"));
            textScreen.put("Buy", new StringBuilder("Купить"));

            textScreen.put("Attack", new StringBuilder("Атака"));
            textScreen.put("Defense", new StringBuilder("Оборона"));
            textScreen.put("Technologies", new StringBuilder("Технологии"));
            textScreen.put("TerminalUpdateTower", new StringBuilder("Турели"));
            textScreen.put("WarningTower", new StringBuilder("* Мощь турели в 3 раза ниже главной пушки"));

            textScreen.put("Reset", new StringBuilder("Сброс"));
            textScreen.put("ResetInfo", new StringBuilder("Сбрасывает все установленные модификации. После сброса позволяет выбрать другую ветвь.\nВнимание! Все потраченные средства не возвращаются."));
        } else {
            textScreen.put("OnOff", new StringBuilder("On/Off"));
            textScreen.put("MachineGun", new StringBuilder("Machine guns"));
            textScreen.put("LauncherGun", new StringBuilder("Grenade launchers"));
            textScreen.put("FlareGun", new StringBuilder("Rocket launchers"));
            textScreen.put("LaserGun", new StringBuilder("Laser guns"));
            textScreen.put("Installed", new StringBuilder("Installed"));
            textScreen.put("Install", new StringBuilder("Install"));
            textScreen.put("Buy", new StringBuilder("Buy"));

            textScreen.put("Attack", new StringBuilder("Attack"));
            textScreen.put("Defense", new StringBuilder("Defense"));
            textScreen.put("Technologies", new StringBuilder("Technologies"));
            textScreen.put("TerminalUpdateTower", new StringBuilder("Turret"));
            textScreen.put("WarningTower", new StringBuilder("* The power of the turret is 3 times lower than the main gun"));

            textScreen.put("Reset", new StringBuilder("Reset"));
            textScreen.put("ResetInfo", new StringBuilder("Clears all installed modifications. After resetting, you can select another branch.\nAttention! All funds spent are not refundable."));
        }
    }

    private void arsenalScreenTacticsAttack() { // в arsenalScreen()
        if (MarsGame.getPreference().language().equals("ru")) {
            textScreen.put("Current", new StringBuilder("Сейчас: "));
            textScreen.put("Next", new StringBuilder("После: "));
            textScreen.put("BuyTactics", new StringBuilder(" Установить "));
            textScreen.put("NotBuyTactics", new StringBuilder(" Не доступно "));
            textScreen.put("Actively", new StringBuilder("активно"));
            textScreen.put("NotActive", new StringBuilder("не активно"));
            textScreen.put("AttackStart", new StringBuilder("Атака"));
            textScreen.put("AttackStartInfo", new StringBuilder("Позволяет повышать атакующую мощь базы и техники. После активации другие ветви будут не доступны!"));
            textScreen.put("AttackGenerator", new StringBuilder("Генератор мощности"));
            textScreen.put("AttackGeneratorInfo", new StringBuilder("Генератор увеличивает урон всех пушек. (+5%)\nНеобходимо минимум энергии базы: 50"));
            textScreen.put("AttackGeneratorPowerShot", new StringBuilder("Эндотрон урона"));
            textScreen.put("AttackGeneratorPowerShotInfo", new StringBuilder("Увеличивает урон пушек. (%)"));
            textScreen.put("AttackGeneratorEnergy", new StringBuilder("Антиэнергия"));
            textScreen.put("AttackGeneratorEnergyInfo", new StringBuilder("Снижает потребление энергии. (Снимается энергии на поддержание)"));
            textScreen.put("AttackPowerShot", new StringBuilder("Критический урон"));
            textScreen.put("AttackPowerShotInfo", new StringBuilder("Позволяет точнее прицеливаться и стрелять по уязвимым местам. (%)"));
            textScreen.put("AttackLauncherGun", new StringBuilder("Пусковая установка"));
            textScreen.put("AttackLauncherGunInfo", new StringBuilder("Позволяет строить оборонительные башни типа - Гранатомет."));
            textScreen.put("AttackLauncherGunEnergy", new StringBuilder("Антиэнергия"));
            textScreen.put("AttackLauncherGunEnergyInfo", new StringBuilder("Снижает потребление энергии. (сек.)"));
            textScreen.put("AttackFlareGun", new StringBuilder("Ракетницы"));
            textScreen.put("AttackFlareGunInfo", new StringBuilder("Позволяет строить оборонительные башни типа - Ракетницы."));
            textScreen.put("AttackFlareGunEnergy", new StringBuilder("Антиэнергия"));
            textScreen.put("AttackFlareGunEnergyInfo", new StringBuilder("Снижает потребление энергии. (сек.)"));
            textScreen.put("AttackLaserGun", new StringBuilder("Лазеры"));
            textScreen.put("AttackLaserGunInfo", new StringBuilder("Позволяет строить оборонительные башни типа - Лазеры."));
            textScreen.put("AttackLaserGunEnergy", new StringBuilder("Антиэнергия"));
            textScreen.put("AttackLaserGunEnergyInfo", new StringBuilder("Снижает потребление энергии. (сек.)"));
        } else {
            textScreen.put("AttackStart", new StringBuilder("Attack"));
            textScreen.put("Current", new StringBuilder("Current: "));
            textScreen.put("Next", new StringBuilder("Next: "));
            textScreen.put("BuyTactics", new StringBuilder(" Install "));
            textScreen.put("NotBuyTactics", new StringBuilder(" Not available "));
            textScreen.put("Actively", new StringBuilder("actively"));
            textScreen.put("NotActive", new StringBuilder("not active"));
            textScreen.put("AttackStartInfo", new StringBuilder("Allows you to increase the attacking power of the base and equipment.\nAfter activation, other branches will not be available!"));
            textScreen.put("AttackGenerator", new StringBuilder("Power generator"));
            textScreen.put("AttackGeneratorInfo", new StringBuilder("The generator increases the damage of all guns. (+5%)\nMinimum base energy is required: 50"));
            textScreen.put("AttackGeneratorPowerShot", new StringBuilder("Endotron damage"));
            textScreen.put("AttackGeneratorPowerShotInfo", new StringBuilder("Increases damage to guns. (%)"));
            textScreen.put("AttackGeneratorEnergy", new StringBuilder("Anti-energy"));
            textScreen.put("AttackGeneratorEnergyInfo", new StringBuilder("Reduces energy consumption. "));
            textScreen.put("AttackPowerShot", new StringBuilder("Critical damage"));
            textScreen.put("AttackPowerShotInfo", new StringBuilder("Allows to more accurately aim and shoot at vulnerable places. (%)"));
            textScreen.put("AttackLauncherGun", new StringBuilder("Launcher gun"));
            textScreen.put("AttackLauncherGunInfo", new StringBuilder("Allows to build defensive towers type - Launcher gun."));
            textScreen.put("AttackLauncherGunEnergy", new StringBuilder("Anti-energy"));
            textScreen.put("AttackLauncherGunEnergyInfo", new StringBuilder("Reduces energy consumption. (sec.)"));
            textScreen.put("AttackFlareGun", new StringBuilder("Flare gun"));
            textScreen.put("AttackFlareGunInfo", new StringBuilder("Allows to build defensive towers type - Flare gun."));
            textScreen.put("AttackFlareGunEnergy", new StringBuilder("Anti-energy"));
            textScreen.put("AttackFlareGunEnergyInfo", new StringBuilder("Reduces energy consumption. (sec.)"));
            textScreen.put("AttackLaserGun", new StringBuilder("Laser gun"));
            textScreen.put("AttackLaserGunInfo", new StringBuilder("Allows to build defensive towers type - Laser gun."));
            textScreen.put("AttackLaserGunEnergy", new StringBuilder("Anti-energy"));
            textScreen.put("AttackLaserGunEnergyInfo", new StringBuilder("Reduces energy consumption. (sec.)"));
        }
    }

    private void arsenalScreenTacticsDefense() { // в arsenalScreen()
        if (MarsGame.getPreference().language().equals("ru")) {
            textScreen.put("Current", new StringBuilder("Сейчас: "));
            textScreen.put("Next", new StringBuilder("После: "));
            textScreen.put("BuyTactics", new StringBuilder(" Установить "));
            textScreen.put("NotBuyTactics", new StringBuilder(" Не доступно "));
            textScreen.put("Actively", new StringBuilder("активно"));
            textScreen.put("NotActive", new StringBuilder("не активно"));
            textScreen.put("DefenseStart", new StringBuilder("Защита"));
            textScreen.put("DefenseStartInfo", new StringBuilder("Позволяет повышать оборонительные способности базы. После активации другие ветви будут не доступны!"));
            textScreen.put("DefenseGenerator", new StringBuilder("Энергетический генератор"));
            textScreen.put("DefenseGeneratorInfo", new StringBuilder("Покрывает базу и технику энергетическим щитом, поглощающий часть урона. (+5%)\nНеобходимо минимум энергии базы: 50"));
            textScreen.put("DefenseGeneratorPowerShield", new StringBuilder("Супер прочность"));
            textScreen.put("DefenseGeneratorPowerShieldInfo", new StringBuilder("Энергетический щит становится прочнее и эффективнее поглощает урон. (%)"));
            textScreen.put("DefenseGeneratorEnergy", new StringBuilder("Антиэнергия"));
            textScreen.put("DefenseGeneratorEnergyInfo", new StringBuilder("Снижает потребление энергии. (Снимается энергии на поддержание)"));
            textScreen.put("DefenseHeartLife", new StringBuilder("Живучесть"));
            textScreen.put("DefenseHeartLifeInfo", new StringBuilder("В критический момент гибели единожды восстанавливает часть HP базы. (%)"));
            textScreen.put("DefenseShieldHP", new StringBuilder("Экстра-щит"));
            textScreen.put("DefenseShieldHPInfo", new StringBuilder("Увеличивает характеристики энергетического щита. (+10%)"));
            textScreen.put("DefenseShieldHPup", new StringBuilder("Модификатор"));
            textScreen.put("DefenseShieldHPupInfo", new StringBuilder("Делает энергетический щит более мощным. (%)"));
            textScreen.put("DefenseEnergy", new StringBuilder("Экстра-энергия"));
            textScreen.put("DefenseEnergyInfo", new StringBuilder("Увеличивает характеристики энергетической батареи. (+10%)"));
            textScreen.put("DefenseEnergyUp", new StringBuilder("Модификатор"));
            textScreen.put("DefenseEnergyUpInfo", new StringBuilder("Делает энергетическую батарею более мощной. (%)"));
            textScreen.put("DefenseMicrowave", new StringBuilder("Микроволны"));
            textScreen.put("DefenseMicrowaveInfo", new StringBuilder("Увеличивает мощность микроволн, позволяющие остановить монстров на время. (+1 сек.)"));
            textScreen.put("DefenseMicrowaveUp", new StringBuilder("Модификатор"));
            textScreen.put("DefenseMicrowaveUpInfo", new StringBuilder("Увеличивает продолжительность действия микроволн. (+0.5 сек.)"));
        } else {
            textScreen.put("AttackStart", new StringBuilder("Attack"));
            textScreen.put("Current", new StringBuilder("Current: "));
            textScreen.put("Next", new StringBuilder("Next: "));
            textScreen.put("BuyTactics", new StringBuilder(" Install "));
            textScreen.put("NotBuyTactics", new StringBuilder(" Not available "));
            textScreen.put("Actively", new StringBuilder("actively"));
            textScreen.put("NotActive", new StringBuilder("not active"));
            textScreen.put("DefenseStart", new StringBuilder("Defense"));
            textScreen.put("DefenseStartInfo", new StringBuilder("Allows to increase the defensive capabilities of the base.\nAfter activation, other branches will not be available!"));
            textScreen.put("DefenseGenerator", new StringBuilder("Power generator"));
            textScreen.put("DefenseGeneratorInfo", new StringBuilder("It covers the base and equipment with an energy shield absorbing some of the damage. (+5%)\nMinimum base energy is required: 50"));
            textScreen.put("DefenseGeneratorPowerShield", new StringBuilder("Super strength"));
            textScreen.put("DefenseGeneratorPowerShieldInfo", new StringBuilder("Energy shield becomes stronger and more efficiently absorbs damage. (%)"));
            textScreen.put("DefenseGeneratorEnergy", new StringBuilder("Anti-energy"));
            textScreen.put("DefenseGeneratorEnergyInfo", new StringBuilder("Reduces energy consumption. (It takes off energy to maintain)"));
            textScreen.put("DefenseHeartLife", new StringBuilder("Vitality"));
            textScreen.put("DefenseHeartLifeInfo", new StringBuilder("At the critical moment of death, once a part of HP's base is restored. (%)"));
            textScreen.put("DefenseShieldHP", new StringBuilder("Extra shield"));
            textScreen.put("DefenseShieldHPInfo", new StringBuilder("Increases the characteristics of the energy shield. (+10%)"));
            textScreen.put("DefenseShieldHPup", new StringBuilder("Modifier"));
            textScreen.put("DefenseShieldHPupInfo", new StringBuilder("Makes the energy shield more powerful. (%)"));
            textScreen.put("DefenseEnergy", new StringBuilder("Extra-energy"));
            textScreen.put("DefenseEnergyInfo", new StringBuilder("Increases the characteristics of the energy battery. (+10%)"));
            textScreen.put("DefenseEnergyUp", new StringBuilder("Modifier"));
            textScreen.put("DefenseEnergyUpInfo", new StringBuilder("Makes an energy battery more powerful. (%)"));
            textScreen.put("DefenseMicrowave", new StringBuilder("Microwave"));
            textScreen.put("DefenseMicrowaveInfo", new StringBuilder("Increases the power of microwaves, allowing to stop the monsters at a time. (+1 sec.)"));
            textScreen.put("DefenseMicrowaveUp", new StringBuilder("Modifier"));
            textScreen.put("DefenseMicrowaveUpInfo", new StringBuilder("Increases the duration of the action of microwaves. (+0.5 sec.)"));
        }
    }

    private void arsenalScreenTacticsTechnologies() { // в arsenalScreen()
        if (MarsGame.getPreference().language().equals("ru")) {
            textScreen.put("Current", new StringBuilder("Сейчас: "));
            textScreen.put("Next", new StringBuilder("После: "));
            textScreen.put("BuyTactics", new StringBuilder(" Установить "));
            textScreen.put("NotBuyTactics", new StringBuilder(" Не доступно "));
            textScreen.put("Actively", new StringBuilder("активно"));
            textScreen.put("NotActive", new StringBuilder("не активно"));
            textScreen.put("TechnologiesStart", new StringBuilder("Технологии"));
            textScreen.put("TechnologiesStartInfo", new StringBuilder("Позволяет строить дополнительные снабжающие станции и модернизировать работов.\nПосле активации другие ветви будут не доступны!"));
            textScreen.put("TechnologiesRadar", new StringBuilder("Радарная станция"));
            textScreen.put("TechnologiesRadarInfo", new StringBuilder("Радарная станция позволяет обнаруживать вражеских монстров. Никто не проберется с тыла!\nНеобходимо минимум энергии базы: 50"));
            textScreen.put("TechnologiesShowMonsterLife", new StringBuilder("Жизнь монстра"));
            textScreen.put("TechnologiesShowMonsterLifeInfo", new StringBuilder("Отображает жизни монстров. Позволяет обнаруживать слабые места монстров."));
            textScreen.put("TechnologiesRadarEnergy", new StringBuilder("Антиэнергия"));
            textScreen.put("TechnologiesRadarEnergyInfo", new StringBuilder("Снижает потребление энергии. (Снимается энергии на поддержание)"));
            textScreen.put("TechnologiesRobot", new StringBuilder("Робот-рабочий"));
            textScreen.put("TechnologiesRobotInfo", new StringBuilder("Сооружает дополнительную единицу робота. Больше рабочих - больше кремария."));
            textScreen.put("TechnologiesPower", new StringBuilder("Генератор мощности"));
            textScreen.put("TechnologiesPowerInfo", new StringBuilder("Генератор вырабатывает электричество и эффективнее подзаряжает батареи базы. (+2)"));
            textScreen.put("TechnologiesPowerEnergy", new StringBuilder("Усилитель"));
            textScreen.put("TechnologiesPowerEnergyInfo", new StringBuilder("Вырабатывает дополнительное электричество."));
            textScreen.put("TechnologiesCarryingCapacity", new StringBuilder("Грузоподъемность"));
            textScreen.put("TechnologiesCarryingCapacityInfo", new StringBuilder("Гусиницы становятся крепче. Робот может перевозить больше кремария."));
            textScreen.put("TechnologiesRobotSpeed", new StringBuilder("Модернизация двигателя"));
            textScreen.put("TechnologiesRobotSpeedInfo", new StringBuilder("С улучшенным двигателем роботы быстрее передвигаются по марсианской поверхности. (км/ч)"));
            textScreen.put("TechnologiesConverter", new StringBuilder("Преобразователь"));
            textScreen.put("TechnologiesConverterInfo", new StringBuilder("Преобразует одну единицу электрической энергии в одну единицу HP базы. (+1)"));
            textScreen.put("TechnologiesConverterLife", new StringBuilder("Усилитель"));
            textScreen.put("TechnologiesConverterLifeInfo", new StringBuilder("Отдает больше энергии на восстановление HP базы."));
        } else {
            textScreen.put("AttackStart", new StringBuilder("Attack"));
            textScreen.put("Current", new StringBuilder("Current: "));
            textScreen.put("Next", new StringBuilder("Next: "));
            textScreen.put("BuyTactics", new StringBuilder(" Install "));
            textScreen.put("NotBuyTactics", new StringBuilder(" Not available "));
            textScreen.put("Actively", new StringBuilder("actively"));
            textScreen.put("NotActive", new StringBuilder("not active"));
            textScreen.put("TechnologiesStart", new StringBuilder("Technologies"));
            textScreen.put("TechnologiesStartInfo", new StringBuilder("Allows building additional supply stations and upgrading robots.\nAfter activation, other branches will not be available!"));
            textScreen.put("TechnologiesRadar", new StringBuilder("Radar station"));
            textScreen.put("TechnologiesRadarInfo", new StringBuilder("The radar station allows you to detect enemy monsters. No one will make his way from the rear!\nMinimum base energy is required: 50"));
            textScreen.put("TechnologiesShowMonsterLife", new StringBuilder("Life of a monster"));
            textScreen.put("TechnologiesShowMonsterLifeInfo", new StringBuilder("Displays the life of monsters. Allows you to detect the weak points of monsters."));
            textScreen.put("TechnologiesRadarEnergy", new StringBuilder("Anti-energy"));
            textScreen.put("TechnologiesRadarEnergyInfo", new StringBuilder("Reduces energy consumption. (It takes off energy to maintain)"));
            textScreen.put("TechnologiesRobot", new StringBuilder("Working robot"));
            textScreen.put("TechnologiesRobotInfo", new StringBuilder("Constructs an additional unit of the robot. More workers - more cremaria."));
            textScreen.put("TechnologiesPower", new StringBuilder("Power generator"));
            textScreen.put("TechnologiesPowerInfo", new StringBuilder("The generator generates electricity and more efficiently recharges the battery base. (+2)"));
            textScreen.put("TechnologiesPowerEnergy", new StringBuilder("Amplifier"));
            textScreen.put("TechnologiesPowerEnergyInfo", new StringBuilder("Generates additional electricity."));
            textScreen.put("TechnologiesCarryingCapacity", new StringBuilder("Carrying capacity"));
            textScreen.put("TechnologiesCarryingCapacityInfo", new StringBuilder("Caterpillars become stronger. A robot can carry more cremaria."));
            textScreen.put("TechnologiesRobotSpeed", new StringBuilder("Engine modernization"));
            textScreen.put("TechnologiesRobotSpeedInfo", new StringBuilder("With an improved engine, robots move faster on the Martian surface. (km/h)"));
            textScreen.put("TechnologiesConverter", new StringBuilder("Converter"));
            textScreen.put("TechnologiesConverterInfo", new StringBuilder("Converts electrical energy to an HP base. (+1)"));
            textScreen.put("TechnologiesConverterLife", new StringBuilder("Amplifier"));
            textScreen.put("TechnologiesConverterLifeInfo", new StringBuilder("Gives more energy to rebuild the HP base."));
        }
    }

    public void laboratoryScreen() {
        if (MarsGame.getPreference().language().equals("ru")) {
            textScreen.put("Hydrogen", new StringBuilder("Водород-13П"));
            textScreen.put("Refrigerant", new StringBuilder("Хладагент-777"));
            textScreen.put("Zoman", new StringBuilder("Зоман-04"));
            textScreen.put("Info", new StringBuilder("Инфо"));
            textScreen.put("SwitchOff", new StringBuilder("Выключить"));
            textScreen.put("InfoHydrogen", new StringBuilder("Российские ученые создали вещество, сжигающее все дотла. Только Водород-13П способен прожечь ткань инопланетных тварей и испепелить их. Никто и ничто не скроется от адского пламени."));
            textScreen.put("InfoRefrigerant", new StringBuilder("Хладагент-777 был изобретен русским ученым Табаковым специально для охлаждения двигателей межорбитального исследовательского космического корабля \"Надежда\". Но, как выяснилось, марсианские твари уязвимы к Хладагент-777."));
            textScreen.put("InfoZoman", new StringBuilder("Против марсианских тварей земные технологии были бесполезны и выдающийся русский ученый Калингер смогизобрести ядовитый газ Зоман-04. Газ проникал в тело тварей и начинал изнутри разлагать их организмы."));
            textScreen.put("Damage", new StringBuilder("Увеличивает урон"));
            textScreen.put("Cooldown", new StringBuilder("Умен. время восст."));
            textScreen.put("Current", new StringBuilder("Сейчас: "));
            textScreen.put("Next", new StringBuilder("После: "));
            textScreen.put("Max", new StringBuilder("Максимум"));
            textScreen.put("Buy", new StringBuilder("Купить"));
        } else {
            textScreen.put("Hydrogen", new StringBuilder("Hydrogen-13P"));
            textScreen.put("Refrigerant", new StringBuilder("Refrigerant-777"));
            textScreen.put("Zoman", new StringBuilder("Zoman-04"));
            textScreen.put("Info", new StringBuilder("Info"));
            textScreen.put("SwitchOff", new StringBuilder("Switch off"));
            textScreen.put("InfoHydrogen", new StringBuilder("Russian scientists have created a\nsubstance that burns everything to\nthe ground. Only Hydrogen-13P is able\nto burn tissue of alien creatures\nand to incinerate their. No one and\nnothing will hide from hellfire."));
            textScreen.put("InfoRefrigerant", new StringBuilder("Refrigerant-777 was invented by\nTabakov (russian scientist) specifica-\nlly to cool the engines of the interor-\nbital research spacecraft \"Nadezhda\".\nBut, as it turned out, Martian creatu-\nres are vulnerable to Refrigerant-777."));
            textScreen.put("InfoZoman", new StringBuilder("Against the Martian creatures earth\ntechnology was useless and the out-\nstanding Russian scientist Kalinger\nwas able to invent the poisonous gas\nZoman-04. The gas penetrated into\nthe body of the creatures and began\nto decompose their organisms from\nthe inside."));
            textScreen.put("Damage", new StringBuilder("Increases damage"));
            textScreen.put("Cooldown", new StringBuilder("Reduces cooldown"));
            textScreen.put("Current", new StringBuilder("Current: "));
            textScreen.put("Next", new StringBuilder("Next: "));
            textScreen.put("Max", new StringBuilder("Max"));
            textScreen.put("Buy", new StringBuilder("Buy"));
        }
    }

    public void reactorScreen() {
        if (MarsGame.getPreference().language().equals("ru")) {
            textScreen.put("HP", new StringBuilder("База"));
            textScreen.put("HPup", new StringBuilder("Увеличивает здоровье базы"));
            textScreen.put("HPspeed", new StringBuilder("Увел. скорость ремонта здания"));
            textScreen.put("MP", new StringBuilder("Энергия"));
            textScreen.put("MPup", new StringBuilder("Увеличивает запасы энергии"));
            textScreen.put("MPspeed", new StringBuilder("Увел. восстановление энергии"));
            textScreen.put("Reactor", new StringBuilder("Реактор"));
            textScreen.put("Current", new StringBuilder("Сейчас: "));
            textScreen.put("Next", new StringBuilder("После: "));
            textScreen.put("Max", new StringBuilder("Максимум"));
            textScreen.put("Buy", new StringBuilder("Купить"));
        } else {
            textScreen.put("HP", new StringBuilder("Base"));
            textScreen.put("HPup", new StringBuilder("Increases HP of the base"));
            textScreen.put("HPspeed", new StringBuilder("Speeds up repair rate for building"));
            textScreen.put("MP", new StringBuilder("Energy"));
            textScreen.put("MPup", new StringBuilder("Increases max MP energy"));
            textScreen.put("MPspeed", new StringBuilder("Speeds up energy auto-recovery"));
            textScreen.put("Reactor", new StringBuilder("Reactor"));
            textScreen.put("Current", new StringBuilder("Current: "));
            textScreen.put("Next", new StringBuilder("Next: "));
            textScreen.put("Max", new StringBuilder("Max"));
            textScreen.put("Buy", new StringBuilder("Buy"));
        }
    }

    public void aboutScreen() {
        textScreen.put("Version", new StringBuilder("v. 0.1.8 (31)"));
        if (MarsGame.getPreference().language().equals("ru")) {
            textScreen.put("Menu", new StringBuilder("Меню"));
            textScreen.put("Developer", new StringBuilder("Разработчик"));
            textScreen.put("Name", new StringBuilder("Табаков Юрий"));
            textScreen.put("Site", new StringBuilder("Сайт"));
            textScreen.put("GooglePlay", new StringBuilder("Google Play"));
            textScreen.put("VK", new StringBuilder("VK страница"));
            textScreen.put("Facebook", new StringBuilder("Facebook"));
            textScreen.put("Twitter", new StringBuilder("Twitter"));
            textScreen.put("VKgroup", new StringBuilder("VK сообщество"));
        } else {
            textScreen.put("Menu", new StringBuilder("Menu"));
            textScreen.put("Developer", new StringBuilder("Developer"));
            textScreen.put("Name", new StringBuilder("Tabakov Yuri"));
            textScreen.put("Site", new StringBuilder("Site"));
            textScreen.put("GooglePlay", new StringBuilder("Google Play"));
            textScreen.put("VK", new StringBuilder("VK page"));
            textScreen.put("Facebook", new StringBuilder("Facebook"));
            textScreen.put("Twitter", new StringBuilder("Twitter"));
            textScreen.put("VKgroup", new StringBuilder("VK community"));
        }
    }

    public void helpScreen() {
        if (MarsGame.getPreference().language().equals("ru")) {
            textScreen.put("Menu", new StringBuilder("Меню"));
            textScreen.put("CompleteMission", new StringBuilder("Закончить миссию"));
            textScreen.put("CompleteCrystals", new StringBuilder("Собрать все кристаллы"));
            textScreen.put("CompleteIntact", new StringBuilder("Остаться невредимым"));
            textScreen.put("CompleteDieWormCave", new StringBuilder("Взорвать инкубатор"));
            textScreen.put("ShotPower", new StringBuilder("Урон"));
            textScreen.put("RateOfFire", new StringBuilder("Скорострельность"));
            textScreen.put("RechargeTime", new StringBuilder("Время перезарядки"));
            textScreen.put("ShotRange", new StringBuilder("Масштаб взрыва"));
            textScreen.put("ShotDistance", new StringBuilder("Дальность атаки"));
            textScreen.put("Hide", new StringBuilder("Толстая шкура"));
            textScreen.put("Feet", new StringBuilder("Лапки"));
            textScreen.put("Scrotum", new StringBuilder("Мошонка со\nслизью"));
            textScreen.put("Immunity", new StringBuilder("Иммунитет\nк химии"));
        } else {
            textScreen.put("Menu", new StringBuilder("Menu"));
            textScreen.put("CompleteMission", new StringBuilder("Complete mission"));
            textScreen.put("CompleteCrystals", new StringBuilder("Collect all crystals"));
            textScreen.put("CompleteIntact", new StringBuilder("Remain unscathed"));
            textScreen.put("CompleteDieWormCave", new StringBuilder("Blow up the incubator"));
            textScreen.put("ShotPower", new StringBuilder("Damage"));
            textScreen.put("RateOfFire", new StringBuilder("Rate of fire"));
            textScreen.put("RechargeTime", new StringBuilder("Recharge time"));
            textScreen.put("ShotRange", new StringBuilder("The scale of\nthe explosion"));
            textScreen.put("ShotDistance", new StringBuilder("Range of attack"));
            textScreen.put("Hide", new StringBuilder("Thick skin"));
            textScreen.put("Feet", new StringBuilder("Feet"));
            textScreen.put("Scrotum", new StringBuilder("Scrotal with\nmucus"));
            textScreen.put("Immunity", new StringBuilder("Immunity to\nchemistry"));
        }
    }

    public void r7Message() {
        if (MarsGame.getPreference().language().equals("ru")) {
            textScreen.put("R7Message-1", new StringBuilder("Привет, человек =)"));
            textScreen.put("R7Message-2", new StringBuilder("Я робот Р-7"));
            textScreen.put("R7Message-3", new StringBuilder("Меня сделали в России"));
            textScreen.put("R7Message-4", new StringBuilder("Как прошел день?"));
            textScreen.put("R7Message-5", new StringBuilder("Какие у тебя дела?"));
            textScreen.put("R7Message-6", new StringBuilder("Что сегодня будем\nделать?"));
            textScreen.put("R7Message-7", new StringBuilder("Сегодня все тихо"));
            textScreen.put("R7Message-8", new StringBuilder("Двигатель корабля\nфункционирует"));
            textScreen.put("R7Message-9", new StringBuilder("А я уже подзарядился :-)"));
            textScreen.put("R7Message-10", new StringBuilder("В бой!!!"));
            textScreen.put("R7Message-11", new StringBuilder("Фух, еле доехал..."));
            textScreen.put("R7Message-12", new StringBuilder("Что-то я утомился"));
            textScreen.put("R7Message-13", new StringBuilder("Пора денег подзаработать"));
            textScreen.put("R7Message-14", new StringBuilder("Нам нужен кремарий"));
            textScreen.put("R7Message-15", new StringBuilder("Ты кто?!"));
            textScreen.put("R7Message-16", new StringBuilder("Мы на корабле \"Надежда\""));
            textScreen.put("R7Message-17", new StringBuilder("Потыкай по мне =)"));
            textScreen.put("R7Message-18", new StringBuilder("Где моя зарядка?!"));
            textScreen.put("R7Message-19", new StringBuilder("Где моя заначка?"));
            textScreen.put("R7Message-20", new StringBuilder("Что с кораблем?"));
            textScreen.put("R7Message-21", new StringBuilder("Меня надо смазать"));
            textScreen.put("R7Message-22", new StringBuilder("Где мое машинное масло?"));
            textScreen.put("R7Message-23", new StringBuilder("Подписывайся в twitter"));
            textScreen.put("R7Message-24", new StringBuilder("Подписывайся в facebook"));
            textScreen.put("R7Message-25", new StringBuilder("Подписывайся в вКонтакте"));
            textScreen.put("R7Message-26", new StringBuilder("Подписывайся в google plus"));
            textScreen.put("R7Message-27", new StringBuilder("Оцени игру в google play"));
            textScreen.put("R7Message-28", new StringBuilder("Оставь отзыв в google play"));
            textScreen.put("R7Message-29", new StringBuilder("Давай почудим?"));
            textScreen.put("R7Message-30", new StringBuilder("Опять ты?"));
            textScreen.put("R7Message-31", new StringBuilder("Прекрасно выглядишь"));
            textScreen.put("R7Message-32", new StringBuilder("Где мои деньги?"));
            textScreen.put("R7Message-33", new StringBuilder("Где мои кристаллы?"));
            textScreen.put("R7Message-34", new StringBuilder("Я просто шикарен"));
            textScreen.put("R7Message-35", new StringBuilder("Почему тут пыльно?"));
            textScreen.put("R7Message-36", new StringBuilder("Куда все делись?"));
            textScreen.put("R7Message-37", new StringBuilder("Что за ящик Пандоры?"));
            textScreen.put("R7Message-38", new StringBuilder("Контрабандисты прилетели"));
            textScreen.put("R7Message-39", new StringBuilder("Мне нужен ремонт"));
            textScreen.put("R7Message-40", new StringBuilder("В корабле пробоина"));
        } else {
            textScreen.put("R7Message-1", new StringBuilder("Hi, people =)"));
            textScreen.put("R7Message-2", new StringBuilder("I'm a robot R-7"));
            textScreen.put("R7Message-3", new StringBuilder("I was made in Russia"));
            textScreen.put("R7Message-4", new StringBuilder("How was your day?"));
            textScreen.put("R7Message-5", new StringBuilder("What are you doing?"));
            textScreen.put("R7Message-6", new StringBuilder("What are we going to do\ntoday?"));
            textScreen.put("R7Message-7", new StringBuilder("Today everything is quiet"));
            textScreen.put("R7Message-8", new StringBuilder("The ship's engine\nis functioning"));
            textScreen.put("R7Message-9", new StringBuilder("I already recharged :-)"));
            textScreen.put("R7Message-10", new StringBuilder("To battle!!!"));
            textScreen.put("R7Message-11", new StringBuilder("(Sigh) Barely reached..."));
            textScreen.put("R7Message-12", new StringBuilder("Something I'm tired of"));
            textScreen.put("R7Message-13", new StringBuilder("It's time to earn\nsome money"));
            textScreen.put("R7Message-14", new StringBuilder("We need a cremaria"));
            textScreen.put("R7Message-15", new StringBuilder("Who are you?!"));
            textScreen.put("R7Message-16", new StringBuilder("We are on the\nspaceship \"Hope\""));
            textScreen.put("R7Message-17", new StringBuilder("Poke on me =)"));
            textScreen.put("R7Message-18", new StringBuilder("Where is my charge?!"));
            textScreen.put("R7Message-19", new StringBuilder("Where is my stash?"));
            textScreen.put("R7Message-20", new StringBuilder("What about the spaceship?"));
            textScreen.put("R7Message-21", new StringBuilder("I need to lubricate"));
            textScreen.put("R7Message-22", new StringBuilder("Where is my engine oil?"));
            textScreen.put("R7Message-23", new StringBuilder("Subscribe to twitter"));
            textScreen.put("R7Message-24", new StringBuilder("Subscribe to facebook"));
            textScreen.put("R7Message-25", new StringBuilder("Subscribe to vk.com"));
            textScreen.put("R7Message-26", new StringBuilder("Subscribe to google plus"));
            textScreen.put("R7Message-27", new StringBuilder("Rate the game in\ngoogle play"));
            textScreen.put("R7Message-28", new StringBuilder("Leave feedback in\ngoogle play"));
            textScreen.put("R7Message-29", new StringBuilder("Let is have fun?"));
            textScreen.put("R7Message-30", new StringBuilder("You again?"));
            textScreen.put("R7Message-31", new StringBuilder("You look beautiful"));
            textScreen.put("R7Message-32", new StringBuilder("Where is my money?"));
            textScreen.put("R7Message-33", new StringBuilder("Where are my crystals?"));
            textScreen.put("R7Message-34", new StringBuilder("I'm just gorgeous"));
            textScreen.put("R7Message-35", new StringBuilder("Why is it dusty?"));
            textScreen.put("R7Message-36", new StringBuilder("Where have all gone?"));
            textScreen.put("R7Message-37", new StringBuilder("What is Pandora's box?"));
            textScreen.put("R7Message-38", new StringBuilder("Smugglers flew to us"));
            textScreen.put("R7Message-39", new StringBuilder("I need repairs"));
            textScreen.put("R7Message-40", new StringBuilder("In the ship of the hole"));
        }
    }

    public void r7Die() {
        if (MarsGame.getPreference().language().equals("ru")) {
            textScreen.put("r7Die-1", new StringBuilder("Неееет!!! Мой человечек."));
            textScreen.put("r7Die-2", new StringBuilder("Слабый был человек. Запрошу посильнее."));
            textScreen.put("r7Die-3", new StringBuilder("Ого, человек взорвался!"));
            textScreen.put("r7Die-4", new StringBuilder("Человек, не умирай! Где твои запчасти?"));
            textScreen.put("r7Die-5", new StringBuilder("Сейчас я тебя восстановлю."));
            textScreen.put("r7Die-6", new StringBuilder("Человек, ты там живой?"));
            textScreen.put("r7Die-7", new StringBuilder("Человек, что ты натворил!"));
            textScreen.put("r7Die-8", new StringBuilder("Ты взорвал мою базу!"));
            textScreen.put("r7Die-9", new StringBuilder("Человек, больше не взрывай базу."));
            textScreen.put("r7Die-10", new StringBuilder("Был человек, и нет человека."));
            textScreen.put("r7Die-11", new StringBuilder("Ты останешься в моей оперативной памяти."));
            textScreen.put("r7Die-12", new StringBuilder("Так сражался и так жалко пал."));
            textScreen.put("r7Die-13", new StringBuilder("Я бы намного лучше справился с этим простым заданием."));
            textScreen.put("r7Die-14", new StringBuilder("Это сражение было настоящего бойца."));
            textScreen.put("r7Die-15", new StringBuilder("Вот ещё один факт того, что люди слабые существа."));
            textScreen.put("r7Die-16", new StringBuilder("Вот к чему привела твоя оплошность."));
            textScreen.put("r7Die-17", new StringBuilder("Взял и провалил такую важную миссию."));
        } else {
            textScreen.put("r7Die-1", new StringBuilder("Nooooo!!! My little man."));
            textScreen.put("r7Die-2", new StringBuilder("Weak was a man. I'll ask more hard for a man."));
            textScreen.put("r7Die-3", new StringBuilder("Wow, the man exploded!"));
            textScreen.put("r7Die-4", new StringBuilder("Man, do not die! Where are your spare parts?"));
            textScreen.put("r7Die-5", new StringBuilder("Now I will restore you."));
            textScreen.put("r7Die-6", new StringBuilder("Man, are you there alive?"));
            textScreen.put("r7Die-7", new StringBuilder("Man, what have you done!"));
            textScreen.put("r7Die-8", new StringBuilder("You blew my base!"));
            textScreen.put("r7Die-9", new StringBuilder("Man, do not blow up the base anymore."));
            textScreen.put("r7Die-10", new StringBuilder("There was a man, and there is no man."));
            textScreen.put("r7Die-11", new StringBuilder("You will stay in my RAM."));
            textScreen.put("r7Die-12", new StringBuilder("So I fought and fell so miserably."));
            textScreen.put("r7Die-13", new StringBuilder("I would have done a lot better with this simple task."));
            textScreen.put("r7Die-14", new StringBuilder("This battle was a real fighter."));
            textScreen.put("r7Die-15", new StringBuilder("Here is another fact that people are weak creatures."));
            textScreen.put("r7Die-16", new StringBuilder("This is what your mistake led to."));
            textScreen.put("r7Die-17", new StringBuilder("Took and failed such an important mission."));
        }
    }

    public void loadScreen() {
        if (MarsGame.getPreference().language().equals("ru")) {
            textScreen.put("loading", new StringBuilder("Загрузка"));
            textScreen.put("1", new StringBuilder("Это один маленький шаг для человека, но гигантский скачок для всего человечества."));
            textScreen.put("2", new StringBuilder("В космосе ничего не пропадает."));
            textScreen.put("3", new StringBuilder("Вроде темнота, а как заполняет собой межзвёздное пространство."));
            textScreen.put("4", new StringBuilder("Земля - это корзина с человечеством, пущенная по Млечному пути."));
            textScreen.put("5", new StringBuilder("Вселенная вертится во тьме, не беря на себя обязательств и не предоставляя гарантий."));
            textScreen.put("6", new StringBuilder("То, что мир бесконечен - это ничем не доказанный предрассудок."));
            textScreen.put("7", new StringBuilder("Человек затерян в глухом углу Вселенной."));
            textScreen.put("8", new StringBuilder("Вселенная родилась из акта любви."));
            textScreen.put("9", new StringBuilder("Чёрные дыры - результат деления Вселенной через ноль в процессе Творения."));
            textScreen.put("10", new StringBuilder("Мелочь, а приятно. А если приятно, то это уже не мелочь."));
            textScreen.put("11", new StringBuilder("Лишённым сострадания не будет оправдания."));
            textScreen.put("12", new StringBuilder("Не ищи пятен на Солнце - ослепнешь!"));
            textScreen.put("13", new StringBuilder("Ветер в голове никогда не бывает попутным."));
            textScreen.put("14", new StringBuilder("Возмездие приходит безвозмездно."));
            textScreen.put("15", new StringBuilder("Ничто так не портит цель, как попадание."));
        } else {
            textScreen.put("loading", new StringBuilder("Loading"));
            textScreen.put("1", new StringBuilder("This is one small step for man, but a giant leap for all of humanity."));
            textScreen.put("2", new StringBuilder("In space, nothing is lost."));
            textScreen.put("3", new StringBuilder("It seems dark, but as it fills the interstellar space."));
            textScreen.put("4", new StringBuilder("The Earth is a basket with humanity, launched along the Milky Way."));
            textScreen.put("5", new StringBuilder("The universe spins into darkness, without incurring obligations and without providing guarantees."));
            textScreen.put("6", new StringBuilder("The fact that the world is infinite is an unproven prejudice."));
            textScreen.put("7", new StringBuilder("A man is lost in a remote corner of the universe."));
            textScreen.put("8", new StringBuilder("The universe was born out of an act of love."));
            textScreen.put("9", new StringBuilder("Black holes are the result of the division of the universe through zero in the process of Creation."));
            textScreen.put("10", new StringBuilder("A trifle, but nice. And if it's nice, then it's not a trifle anymore."));
            textScreen.put("11", new StringBuilder("There will be no excuse for the lack of compassion."));
            textScreen.put("12", new StringBuilder("Do not look for spots on the sun - you will go blind!"));
            textScreen.put("13", new StringBuilder("The wind in the head is never a passing one."));
            textScreen.put("14", new StringBuilder("Vengeance comes free of charge."));
            textScreen.put("15", new StringBuilder("Nothing spoils the goal like hit."));
        }
    }

    public void disposeText() {
        textScreen.clear();
    }

    public void dispose() {
        try {
            disposeText();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}