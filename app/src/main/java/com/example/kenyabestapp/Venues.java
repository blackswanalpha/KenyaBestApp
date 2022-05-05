package com.example.kenyabestapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

public class Venues extends AppCompatActivity implements MyMovieAdapter.OnNoteListener {
    Countydets selectedShape;
    ImageView img;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    String parsedStringID;
    MyMovieAdapter myMovieAdapter;
    MyMovieData[] myMovieData;
    Button back;
    String title = "Venues";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venues);
        getSelectedShape();


        navigationView = (NavigationView) findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:

                        Intent intent = new Intent(Venues.this,HomePage.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_drawer1:
                        Intent intent1 = new Intent(Venues.this, Counties.class);

                        startActivity(intent1);
                        break;
                    case R.id.nav_drawer2:
                        Intent intent2 = new Intent(Venues.this, EditProfilePage.class);

                        startActivity(intent2);
                        break;

                    case R.id.nav_feedback:
                        Intent intent8 = new Intent(Venues.this, Feedback.class);
                        startActivity(intent8);
                        break;

                    case R.id.nav_aboutus:
                        Intent intent3 = new Intent(Venues.this, About.class);
                        startActivity(intent3);
                        break;


//Paste your privacy policy link

                    case  R.id.nav_settings:{

                        Intent intent7 = new Intent(Venues.this, Settings.class);
                        startActivity(intent7);

                    }
                           break;
                    case R.id.nav_share: {

                        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                        sharingIntent.setType("text/plain");
                        String shareBody = "http://play.google.com/store/apps/detail?id=" + getPackageName();
                        String shareSub = "Try now";
                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                        startActivity(Intent.createChooser(sharingIntent, "Share using"));

                    }
                    break;
                }
                return false;
            }
        });




        if (parsedStringID.equals("0") ){
            setUpToolbar();
            setTitle("Mombasa");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Fort Jesus: ","Located at the end of Nkrumah Road in Mombasa CBD, Fort Jesus  is a famous tourist attraction in Mombasa and is a UNESCO World Heritage Site. The eye-catching structure immediately ushers you into history as you begin to explore the massive fort that was built by the Portuguese in 1593-1596; famous Milanese Architect Giovanni Battista Cairati, a well-respected architect by the Portuguese, designed it.The 16th Century days are reminiscent whenever you set foot in the huge structure that preserves the history of the Portuguese, Arabs and British, all who at one time were in control of Fort Jesus.  The ruined buildings, weaponry and a museum are some of the must see places while you’re touring the port. There is small fee you need to pay to the National Museums of Kenya at the entrance.", R.drawable.fort) ,
                    new MyMovieData("Mombasa Marine Park: ","Watching the sea below and seeing the diverse and beautiful marine life is the wish of every traveler that comes to see exotic Mombasa tourist attractions. Located on the North Coast on Bamburi beach is Mombasa Marine Park. Diving and snorkeling are some of the exciting activities you can engage in as well as get the chance to see a wide variety of marine creatures that are found in the park. While here, you can see Mombasa’s wreck MV Dania as well as hire a glass bottom boat to explore the park. You can easily get to the Marine Park from any of Mombasa north coast beaches; Bamburi, Shanzu and Diani.", R.drawable.mombasamarinemark),
                    new MyMovieData("Haller Park:"," If you are an animal and nature lover, you should not leave Mombasa without coming to Haller Park. The park is located approximately 10km from the CBD on the road to Mtwapa and was formerly known as Bamburi Nature Trail. This exciting park is highly rated as one of the best Mombasa tourist attractions. The park was initially a limestone quarry but thanks to the efforts of Dr. René Haller, the abandoned limestone quarry was transformed into a nature haven with different tree species, a wildlife park, hundreds of bird species as well as walking and cycling parks. Haller Park is famous for picnics and many Mombasa residents come here on weekends to spend some time with nature.Many of tourists both domestic and foreign flock to this family friendly park. Wildlife here includes zebras, giraffes, waterbucks, hippos and Cape buffalo. Giraffe feeding is a popular attraction for guests coming here. There is also a butterfly pavilion you cannot afford to miss while here. If you are using public transport, take Mtwapa or Bamburi matatus from Digo Road in the CBD. You can also use a private car or tuk tuk; a small entrance fee is charged at the gate. ", R.drawable.hallerpark),
                    new MyMovieData(" Mombasa Beaches","The beaches in Mombasa rank amongst top Mombasa tourist attractions. Everyone who comes to Mombasa is keen on one thing; to enjoy a first-hand experience of seeing the beautiful waters of the Indian Ocean, relaxing on the white sandy beaches and participating in a host of beach activities. You can choose to visit North Coast beaches or South Coast beaches. North Coast beaches are access using Nyali Bridge while the South Coast is access via Likoni ferry. Come and be part of a unique Mombasa experience you will live to remember. ", R.drawable. mombasabeach ),
                    new MyMovieData("Old Town"," You can never say you were in Mombasa without visiting the Old town. Strategically located within the city center, Old Town is a blend of Arab, Portuguese and British influence. The traditional architecture, narrow streets, friendly people and a reassuring cool breeze are some of the main characteristics of Mombasa Old Town. As one of the major Mombasa tourist attractions, many guests flock here to familiarize themselves with the surrounding as well as explore shops that sell souvenirs. A rich history and culture reflects what Mombasa looked like in the previous days. Old town is expansive; if possible, be accompanied by a guide who understands the area well to make the best of your trip. ", R.drawable.oldtown),
                    new MyMovieData("Elephant Tusks"," Even those who have not been to Mombasa know about the giant tusks that sit on Moi Avenue, a major street in the central business district. Built to commemorate the visit by Queen Elizabeth to Mombasa, the aluminum tusks sit on both sides of the dual carriageway and symbolically take the shape of an “M” that stands for Mombasa.They are huge and therefore quite visible once you are on the street. Uhuru Gardens is a quiet park located adjacent to the tusks where you can relax after visiting the tusks; it is the perfect spot to catch your breath. ", R.drawable.tusk),
                    new MyMovieData("Mamba Village"," Situated on Links road in Nyali, Mamba Village is a large crocodile farm; the largest in East Africa where you can come and indulge yourself in plenty of fun activities as you learn more about crocodiles. Feeding time is especially thrilling as you watch them jump high to grab food.Being one of the famous Mombasa tourist attractions, Mamba village receives many guests; weekends and holidays are particular packed. Here, you will get a chance to see giant crocodiles and receive a few tips from the experts; it is a great place to be. ", R.drawable.mambavillage),
                    new MyMovieData("Bombolulu Workshops and Cultural Cente"," Bombolulu Workshops is a vibrant cultural Centre located off Malindi Road in Bombolulu neighborhood that show cases the African culture to guests who are eager to experience and learn more about African culture. The Association for the Physically Disabled are in charge of the project; they have done a wonderful job bringing culture to the city. If you love tribal dances and performances; this is the place to be .There are also .traditional homesteads that show the diverse Kenyan culture as well as perfectly made souvenirs such as wood carvings, textiles and jewelry. It would be nice to buy something small and contribute towards the upkeep of the centre. A restaurant dedicated to serving Kenyan traditional dishes is also available in the compound. To get here, take a Mtwapa, Bamburi Mtambo or Bombolulu matatu from the CBD", R.drawable.bomboluluworkshop),
                    new MyMovieData("Likoni Ferry and Kilindini Harbor"," I know this may not sound like one of Mombasa tourist attractions. However, many tourists’ especially domestic guests come to the coast excited to enjoy a ferry ride; this is common amongst first time visitors to Mombasa. If you want to have fun, do not go for a ferry ride when its peak hours (7am-9am) or (5pm-7pm); there is usually a lot of human traffic and vehicles waiting to board the ferry. As you cross the channel, you get the chance to see giant cargo and passenger ships docking at the Kilindini port; the view is breathtaking. Mombasa and the entire Kenyan Coast is blessed to have so many amazing sites to visit ", R.drawable.likoniferry),
                    new MyMovieData("Nguuni Nature Sanctuary"," Located in Kiembeni, Bamburi; Nguuni Nature Sanctuary makes you forget you are in Mombasa. The Sanctuary’s natural vegetation resembles that of a national park such as Tsavo or Amboseli. Nguuni is located 4km from the Bamburi Cement factory junction and therefore within close range to Haller Park. Many people come here to relax, have a get-together, celebrate birthdays and weddings and watch animals such as waterbucks, elands, giraffes and ostriches. The grassland vegetation makes the sanctuary ideal for a game ride especially if you want to explore the deeper sections of Nguuni. Many schools visiting Mombasa come here for educational tours. To access with public service vehicles, board Kiembeni matatus from Digo Road. Alternatively, you can also board a Bamburi Mtambo matatu alight at Bamburi Mwisho (Old Malindi road junction) and take a tuk tuk or pick a Kiembeni bound matatu. This is a perfect spot for camping and having picnics. ", R.drawable.nguunisanctuary),
                    new MyMovieData("Ngomongo Villages"," Another place to experience rich tradition and culture is to pay a visit to Ngomomgo Villages in Shanzu. As the name suggests, this Mombasa tourist attraction site focuses on highlighting tradition covering 9 Kenyan tribes represented as complete homesteads with a hut, crops, domestic and wild animals. This set-up best demonstrates the African way of living and how Kenyan communities coexist. Unfortunately, Ngomongo villages is often left out of Mombasa tourist attractions yet it is an interesting and fun place to visit particularly for guests who want to acquaint themselves with Kenyan culture. ", R.drawable.ngomongovillages),
                    new MyMovieData("Jumba La Mtwana"," Jumba la Mtwana is a Swahili ruined village tucked away in Kilifi County (Approx. 20 km) from Mombasa CBD just past Mtwapa town on your way to Kilifi. The picturesque tourist attraction consists of four houses, a tomb and four mosques. It is evident the village was once lived and inhabited by Muslims. The village touches the shores of the Indian Ocean and extends 250 meters inland. If you need to get out of town, you can visit this magnificent historical site. The good thing is that it is very near Mombasa CBD (Approximately 30 minutes). From the city centre, take Mtwapa matatus from Digo Rd, alight at Mtwapa and take a tuk tuk to the site. The site is about 4km off main Mombasa-Malindi highway and is also accessible with a private car. ", R.drawable.jumbalamtwana),
                    new MyMovieData(" Mombasa Go-Kart","Mombasa Go-Kart is a hit with speedsters and kids of all ages. Zoom around the smooth concrete track in go-karts, bounce around on the off-road buggies, or learn to dig in a Bobcat excavator. After all the excitement, visitors can enjoy a snack at the family-friendly restaurant with computer games, a large playground, and a big screen showing sporting events. The Go-Kart track is flood-lit at night. Location: Bamburi Beach, Mombasa:The above list focuses mainly on Mombasa County and it is not the full list, there are other things worth viewing in Mombasa. Keep checking for future highlights on other amazing Kenyan coast tourist attractions.", R.drawable. mombasagokart)
            };



            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("1") ){
            setUpToolbar();
            setTitle("Kwale");

            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{

                    new MyMovieData("Tiwi Beach","It is a tranquil beach located in the Kenyan South Coast. It is an ideal destination for swimming, snorkeling and various water sports. Several beachfront hotels and lodges are located within the beach.", R.drawable.tiwibeach),
                    new MyMovieData("Jungle Snake Park","It is located in Mwamanga, Ukunda. The park features different species of snakes, turtles, crocodiles, tortoise and other small reptiles. It is usually open from 9 am to 5.30 pm, Monday to Saturday.", R.drawable.junglesnakepark ),
                    new MyMovieData("Diani Beach Art Gallery"," It was officially opened in September 2010, to promote fine African art locally and internationally through exhibiting, selling and supporting African artwork in the gallery’s space. It is a perfect place to view and buy different paintings, sculptures, framed and unframed photography.", R.drawable.dianibeachartgallery),
                    new MyMovieData("KayaKinondoForest","It is the only sacred forest at the Kenyan Coast that is open to the public. It is a sacred forest and place of worship for the Digo community. It is actually a nice place to visit and learn the cultural practices of the Digo people, enjoy nature walks and birdwatching.", R.drawable.kayakinondoforest),
                    new MyMovieData("Diani Beach"," It is a perfect chill spot for lovers of a tranquil environment. It is an ideal destination for swimming, jet skiing, snorkeling, skydiving, boat rides and various water sports.", R.drawable.dianibeach),
                    new MyMovieData("Wasini Island"," The Island is situated about 3 kilometres opposite the harbour of the port village of Shimoni.It is a perfect destination for snorkelling, scuba diving, dhow sailing, sunset cruise and dolphin spotting. You can also enjoy exquisite seafood at the island. ", R.drawable.wasiniisland),
                    new MyMovieData("Kisite-Mpunguti Marine Park:"," It lies in the coral gardens south of Wasini Island, approximately 11 kilometres off the Kenyan Coast at Shimoni. It was established to protect the scenic islands and special habitats of marine animals at the Kenyan Coast. It is one of the best location for snorkeling, diving, bird watching, camping and sunbathing. ", R.drawable.kisitempungutimarinepark),
                    new MyMovieData("Shimba Hills National Reserve"," The reserve is located in Kwale district, approximately 33 kilometres south of Mombasa. Major attractions at the reserve include elephants, the endangered sable antelope, giraffes, leopards, different species of birds, hyenas, and different species of reptiles, vervet and Sykes monkeys. The reserve offers an enabling environment for game viewing activities, camping and nature walk. Sheldrick falls and the Mwaluganje elephant sanctuary are located within the reserve.", R.drawable.shimbahillsnationalreserve),


            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("2") ){
            setUpToolbar();
            setTitle("Kilifi");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Jumba La Mtwana","It is situated about 4 kilometres from the Mombasa-Malindi road. Jumba la mtwana is a Swahili word that means ‘the large house of the slave. It is a national monument, which features ancient mosques, four houses, courts and kibla. It was gazetted as a national monument in 1982.", R.drawable.jumbalamtwana),
                    new MyMovieData(" Mnarani Ruins"," Mnarani Ruins is located in Kilifi and overlooks the Kilifi Creek from the southern side, approximately 200 metres from the Mombasa- Malindi road. It consists of mosques, madrassa and a group of tombs and pillars.", R.drawable. mnaraniruins),
                    new MyMovieData("Vasco Da Gama Pillar","It is a monument that was built by the Portuguese to give direction to explorers who were following the sea route to India. It is one of the popular tourist attraction and historical sites in Malindi.", R.drawable.vascodagamapillar ),
                    new MyMovieData("Watamu Beach"," It is a calm sandy beach located in Watamu. It is a popular destination for snorkelling, diving, swimming, boat rides and various water sports. It is a perfect place for lovers of a tranquil environment.", R.drawable.watamubeach),
                    new MyMovieData("Mida Creek"," A tidal creek stretches from the sea to Arabuko Sokoke forest. It is a perfect kayaking destination and a bird watching paradise. It is an ideal place for water sports such as waterskiing and wakeboarding. It also features a 260-metre walk board, perfect for nature walks with family and friends. A restaurant and a mini-bar are also available at the site.", R.drawable.midacreek),
                    new MyMovieData("Malindi Museum","It is situated in Malindi town. The museum houses cultural exhibitions and artefacts used by early Arabs and the local coastal people. It also doubles as an information centre for attractions and local happenings in Malindi and its environs.", R.drawable.malindimuseum),
                    new MyMovieData(" Arabuko Sokoke National Reserve"," It features one of the largest stretches of indigenous coastal dry forest in East Africa. The stretch is about 400 square kilometres. It is a notable place for bird watching activities, game drives, guided walking safari, cycling, camping and nature trails.", R.drawable. arabukososokenationalpark),
                    new MyMovieData("Gedi Ruins","It is a national museum and historical site located approximately sixteen kilometres south of Malindi. Gedi Ruins are the remains of an early Swahili town called Gedi, which was inhabited by sailors, traders and settlers from Oman. You can take guided tours through the ruins, museum and information centre located within the area, to learn about the early Swahili culture", R.drawable.gediruins),
                    new MyMovieData("Malindi Marine National Park and Reserve","It is situated in Malindi, about 110 kilometres North of Mombasa. It is endowed with magnificent coral gardens, fringing reefs, seagrass beds, mangroves, mudflats, marine mammals and different species of shorebirds. It is a perfect place for bird watching, camping, diving, glass-bottomed boat rides, sunbathing, water skiing, windsurfing and snorkelling", R.drawable.malindimarinenationalpark),
                    new MyMovieData("Watamu Marine National Park and Reserve","It is one of Kenya’s best marine park that has a rich and diverse birdlife, fish, turtles, dugongs, the lizard buzzard and other marine animals. It is a perfect place to enjoy the sandy beaches of the Indian Ocean, snorkelling, water skiing, windsurfing and glass-bottomed boat tours. ", R.drawable.watamumarinenationalpark),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("3") ){
            setUpToolbar();
            setTitle("Tana River");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{

                    new MyMovieData("Adamson Falls Bridge and Adamson Falls","The Adamson Falls Bridge on Tana River that connects Meru National Park to Kora National Park. It is said to be the sleeping giant of Coastal tourism.George Adamson (3 February1906-20 August 1989),known as the Baba ya Simba(“Father of Lions”),was a Kenyan wildlife conservationist and author.He and his wife,Joy,are best known through the movie Born Free and best-selling book with the same title,which is based on the true story of Elsathe Lioness,an orphaned lioness cub they had raised and later released into the wild.The beautiful bridge a long the River Tana is a sight to behold but beware of the crocodiles that come out to bask in the sun. ", R.drawable.adamsonsfalls),
                    new MyMovieData("Tana River Primate Reserve","The Tana River Primate Resserve is located in Tana River at the coast of Kenya.This is about 350km from the capital city and approximately 240km from Mombasa city.This protection zone,established in 1976,preserves endangered species like the Mangabey and the red colobus monkeys.Humans invaded land around this water source putting mangabeys in danger and that’s why the reserve was established.The Tana River mangabey monkey is prevalent in forests a long the banks this river.The managabey,with its white eyelids and yellow-brown fur,is remarkable sight as you explore the park.The Tana River Primate National Reserve is a 170 square kilometres (66 Sq. mi) national wildlife reserve in Tana River County. The government set aside the land in 1976 in order to protect the swampy forests of the Lower Tana River and two endangered primates, the Tana River mangabey and the Tana River red colobus, that are found there. The endangered primates inhabit sixteen patches of forest (ranging from .1 to 6.25 km2) which extends for 60 km down the meandering lower Tana River, between Nkanjonja and Mitapani. Despite a $6.7 million World Bank. Global Environment Facility project (1996 to 2001), conservation measures for the two primates have been largely ineffective. In 2005, more than 250 families of farmers were relocated 90 km away to the coastal community of Kipini. The lush river forest patches are remainders of western African forests. The river cuts through dry woodland and open savannah. Recorded bird species there number 262, and at least 57 species of mammals live there. There are several endemic tree species as well as a variety of other animals and plants. Many of the bird and animal species in the reserve are unusual in East Africa, being typical of Central Africa’s lowland rainforest. The white-winged apalis is extremely rare. The African open bill stork, martial eagle, bat hawk, African pygmy-falcon, African barred owlet, scaly babbler, black-bellied glossy-starling, and golden pipit are also rare. ", R.drawable.tanariverprimatesnationalreserve),
                    new MyMovieData("River Tana Delta","The Tana River Delta is one of Kenya’s largest and most important freshwater wetland systems both rich in wildlife and with a significant local community of cattle herders and others dependent on it and who have done so for centuries. However, it is under serious threat.A number of large scale projects have been proposed including turning wetlands into sugarcane plantations and rich natural woodland into eco-friendly bio-fuel crops. ", R.drawable.tanariverdelta),

                    new MyMovieData("Tana River"," The 1,000 kilometres (620 mi) long, Tana River is the longest river in Kenya, and gives its name to the Tana River County. Its tributaries include the Thika, as well as several smaller rivers that flow only during the rainy season. The river rises in the Aberdare Mountains to the west of Nyeri. ", R.drawable.tanariver),
                    new MyMovieData("Inland Beaches and Fishing","The availability of the Tana River and the Indian Ocean coastline has seen fishing activities in the county. However, most of the fishing in the county is on small scale for domestic consumption. Tana River County is accessible by road. Certain parts of the River Tana and the short coastline of the county has seen the development of water transportation means like the use of water boats,however; mainly for fishing activities. ", R.drawable.inlandbeaches),
                    new MyMovieData("Coastal Public Beaches and Coral Reefs","The county, amongst the five with a coastline has the shortest of the coastline share. Therefore, there has not been a lot of investment yet in hotels, resorts and beaches industry along its short coastline. ", R.drawable.coastalpublicbeaches),

                    new MyMovieData(" Kora National Park"," The home of the legendary Bwana Simba aka George Adamson of the Born Free fame, Simba had his camp at the base of the 442-metre-high Kora Rock. Gazzetted in 1973 as a reserve, Kora National Park attained national park status in 1990. This triangle of dense woodland and scrub has as its northern boundary 65km of the Tana River, which begins in the highlands of the Aberdares and Mount Kenya to flow 700km to the Indian Ocean. The western boundary follows a straight line from the Tana River to Mwingi National Reserve. The Eastern boundary runs along Mwitamyisi River. The park has several rocky inselbergs, the highest of which are Mansumbi at 488 metres and Kumbulanwa at 450, meters. The park has several seasonal rivers. ", R.drawable.koranationalpark),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }


        else if (parsedStringID.equals("4") ){
            setUpToolbar();
            setTitle("Lamu");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("The Fort of Shela","The fort is situated along the sand dunes of Shela beach. The Fort depicts the Omani architectural design. It is an elegant and unique sanctuary that offers a tranquil environment for personalised hospitality. The Fort is a paradise for kite surfers. Yoga and meditation classes are also offered at the Fort. ", R.drawable.fortofshela),
                    new MyMovieData("Manda Toto ","It is one of the islands of the Lamu Archipelago. It is actually the best spot for snorkelling on the Lamu Archipelago. ", R.drawable.mandatoto ),
                    new MyMovieData("The Swahili House Museum","The museum is located in the northern part of Lamu town. It gives visitors a glimpse of the traditional set up of a Swahili home. It features a Swahili home with neat and furnished living areas, bedrooms, kitchen and bathrooms. ", R.drawable.swahilihousemuseum),
                    new MyMovieData(" Takwa Ruins","Takwa ruins are the remains of a thriving Swahili trading town that was abandoned in the 17th century. A historical site features a unique mosque with a large pillar believed to symbolise the burial of a Sheikh. The ruins are located on the southeastern corner of Manda Island. The place is suitable for picnics and overnight camping. ", R.drawable. takwaruins),
                    new MyMovieData("Dodori National Reserve","It was establishesd in 1976. It covers an approximate area of 877 square kilometres. The reserve is famous for its large topi population, different species of birds, elephants, gazelles, kudus, zebras and green turtles. It is a perfect spot for game viewing and bird watching activities. ", R.drawable.dodorinationalreserve),
                    new MyMovieData(" Lamu Fort","A multi-storied building was built between 1813 and 1821. It houses an environmental museum and a library. The environmental museum is divided into three sections, the marine section, freshwater and terrestrial section. The fort is majorly used for community events. ", R.drawable. lamufort),
                    new MyMovieData("Lamu Museum","It is located in the Lamu Archipelago. It features fascinating collections and exhibits that represent the material culture of the coastal people like the Boni, Pokomo and Orma. ", R.drawable.lamumuseum),
                    new MyMovieData("Kiunga Marine National Reserve","A pristine ecosystem incorporates a chain of approximately 50 offshore islands, sand dune, and coral reefs. The reserve is home to various marine animals such as sea turtles, lobsters, sea urchins, reef fish, sea star and crabs. It is a perfect destination for diving, windsurfing, snorkeling, sunbathing and water skiing. ", R.drawable.kiungamarinenationalreserve),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("5") ){

            setUpToolbar();
            setTitle("Taita Taveta");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{

                    new MyMovieData("Shetani Lava Flow","It is one of the largest volcanic crater fields in Kenya. The charcoal black lava flow was formed about a hundred years ago. It spreads across the savannah near Chyulu hills. It is endowed with flora, fauna and beautiful caves worth exploring.", R.drawable.shetanilavaflow),


                    new MyMovieData("Lugard Falls","The falls are located within the Tsavo East National Park. It features eye catching multicoloured rocks with strips of pink, light grey and white. It is a habitat of giant crocodiles and hippos. The fall was named after Frederick Lugard, a British explorer who passed the place on his way to Uganda.", R.drawable.lugardfalls),


                    new MyMovieData("Mzima Springs","It is a series of four natural springs located in Tsavo West National Park. The springs’ source is a natural reservoir located under the Chyulu Hills. Major attractions at the springs include the hippos and Nile crocodiles.", R.drawable.mzimasprings),


                    new MyMovieData("Lake Jipe","The Lake also straddles the border of Kenya and Tanzania. The lake covers an area of approximately 30 square kilometres. The lake is mainly fed by Lumi River and streams from the Pare Mountains in Tanzania. The Lake is known for its unique water birds and other species of birds, endemic fish, lake edge swamps and wetland plants.", R.drawable.lakejipe),


                    new MyMovieData("Lake Chala","A crater lake is located north of Taveta, between the border of Kenya and Tanzania. One of the lake’s shore is in Kenya while the other in Tanzania. The Lake features a beautiful landscape with diverse species of birds. Monitor lizards, baboons and vervet monkeys can also be spotted within the lake’s vicinity.", R.drawable.lakechala),


                    new MyMovieData("LUMO Community Wildlife Sanctuary","It is a community-owned wildlife sanctuary located near Mwatate town. The sanctuary hosts elephants, leopards, Maasai lions, Maasai giraffes, zebras, impalas, waterbucks, gazelles, buffalos and different species of birds. It is a perfect destination for bush walks, game viewing, nature trails and ornithological walks. The sanctuary also features a community-owned tourist lodge, the Lion’s Bluff Lodge.", R.drawable.lumocommunitywildlifesanctuary),


                    new MyMovieData("Taita Hills","A privately owned sanctuary was established in 1973 by the Hilton Hotel Chain. Sarova Hotels currently manage it. It features different species of birds, elephants, lions, cheetahs, giraffes, gazelles, zebras, impalas, waterbucks, dik-dik and various small animals. The sanctuary provides a tranquil environment for game viewing activities, bird watching, camping and nature walks. Two luxury lodges, the Sarova Salt Lick Game Lodge and Sarova Taita Hills Game Lodge are located in the sanctuary.", R.drawable.taitahills),


                    new MyMovieData("Taita Hills Wildlife Sanctuary","A privately owned sanctuary was established in 1973 by the Hilton Hotel Chain. Sarova Hotels currently manage it. It features different species of birds, elephants, lions, cheetahs, giraffes, gazelles, zebras, impalas, waterbucks, dik-dik and various small animals. The sanctuary provides a tranquil environment for game viewing activities, bird watching, camping and nature walks. Two luxury lodges, the Sarova Salt Lick Game Lodge and Sarova Taita Hills Game Lodge are located in the sanctuary.", R.drawable.taitahillswildlifesanctuary),


                    new MyMovieData(" Tsavo East National Park","The park covers an approximate area of 13, 747 square kilometres. It is home to most of the larger mammals, dust red elephants, rhinos, buffalos, lions, leopards, hippos, crocodiles, waterbucks and over 200 bird species. It is a perfect park for camping activities, bird watching, game viewing and nature walks.", R.drawable.tsavoeastnationalpark),


                    new MyMovieData("Tsavo West National Park","It is a beautiful park with a savannah ecosystem that comprises of open grasslands, scrublands, acacia woodlands, belts of riverine vegetation and rocky ridges. Attractions at the park include diverse bird and plant species, elephants, hippos, rhino, leopards, buffalos, cheetahs and lions. It is an ideal park for cave exploration, game viewing, nature trails and camping.", R.drawable.tsavowestnationalpark),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("6") ){
            setUpToolbar();
            setTitle("Garissa");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{

                    new MyMovieData("Tana Garden Hotel","It is located along the Garissa-Dadaab road. It offers comfortable accommodation in guest rooms categorized as standard double rooms, deluxe double rooms, and standard twin rooms. Other services and facilities offered include; free Wi-Fi, modern meeting/conference facilities and an onsite restaurant that serves a variety of meals.", R.drawable.tanagardenhotel),


                    new MyMovieData("Nomad Palace Hotel","It is situated along the Garissa- Dadaab road. It offers exquisite accommodation in guest rooms categorized as deluxe twin rooms, deluxe double rooms, suites, and superior double rooms. It also prides in state of the art conference facilities, a business center, a mini bar and restaurant that serves sumptuous meals.", R.drawable.nomadpalacehotel),


                    new MyMovieData("Nomad Palace Hotel","It is situated along the Garissa- Dadaab road. It offers exquisite accommodation in guest rooms categorized as deluxe twin rooms, deluxe double rooms, suites, and superior double rooms. It also prides in state of the art conference facilities, a business center, a mini bar and restaurant that serves sumptuous meals.", R.drawable.nomadpalacehotel),


                    new MyMovieData("Garissa Community Giraffe Sanctuary","It is a community-based conservation initiative, situated about 3 kilometers from Garissa town, in the village of Bour-Algi. You can visit the place to have a glimpse of a large number of giraffes, attracted by the abundant acacia trees within the area. It’s also home to the rare white giraffes.", R.drawable.garissacommunitygiraffesanctuary),


                    new MyMovieData("Arawale National Reserve","A designated conservation area covers about 53,324 hectares. Major attractions here include wildlife such as the hirola, elephants, giraffes, cheetahs, buffalos, Grevy’s zebra and diverse species of birds. It is an ideal place to visit for bird watching adventures, camping, game viewing, and nature walks.It lies North Eastern province of Kenya, 77km south of Garissa town.Arawale started in 1974 and was the first sanctuary established to conserve the relic Hunter’s Hartebeast or Hirola.as it locally known: a critically threatened gazelle population endemic to North-Eastern Kenya and south-west parts of the Republic of Somalia. ", R.drawable.arawalenationalreserve),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("7") ){
            setUpToolbar();
            setTitle("Wajir");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
//                    new MyMovieData("Wajir Museum"," ", R.drawable. danduhill),
                    new MyMovieData("Wajir Museum","The Wajir Museum houses an exhibition that reflects traditions and the customs of communities" +
                            "living in this Northern part of Kenya. The theme of the exhibition is “A Window to Northern  " +
                            "Kenya”. It is a part of initiatives to open up Northern Kenya to the tourism industry forming a " +
                            "part of the tourist attractions that will offer distinctive products in the region. The Wajir Museum was officially open on 19 April 2011.The main objective of this museum is to give you a glimpse of the rich cultural, historical and natural heritage of Northern Kenya and its interaction with the world. The Wajir Museum houses an exhibition that reflects traditions and the customs of communities living in this Northern part of Kenya.\nThe theme of the exhibition is 'A Window to Northern Kenya'", R.drawable.wajirmuseum),
                    new MyMovieData("History of Wajir","Wajir was occupied in 1912, to prevent the Boranas from being driven away from the Wells, " +
                            "which  originally belonged to them by other tribes. British Officers arrived at Wajir in 1913. " +
                            "In 1921, the military took over the administration of the district until September 1925, when it " +
                            "reverted to civil administration in 1928; the boundary was shifted north of Modo Gashe to the " +
                            "line of Uaso Nyiro and Lake Dera. Unitl 1917, Bulsesa was a sub-district of Wajir but in 1918. " +
                            "Wajir became a district of its own.\n" +
                            "The headquarters of Wajir was evacuated in 1940 during the Italian invasion. Save for that period.\n" +
                            "Wajir has remained a full district since 1918.\n ", R.drawable.historyofwajir),
                    new MyMovieData(" Wagalla Massacre","The Wagalla massacre took place on 10 February 1984 at the Wagalla Airstrip. The facility is " +
                            "situated approximately 15 km (9 mi) west of the county capital of Wajir in the North Eastern " +
                            "Province, a region primarily inhabited by ethnic Somalis. Kenyan troops had descended on the " +
                            "area to reportedly help defuse clan-related conflict. However, according to eyewitness testimony, " +
                            "about 5,000 Somali men were then taken to an airstrip and prevented from accessing water and " +
                            "food for five days before being executed by Kenyan soldiers.\n" +
                            "According to a commissioner with The Truth, Justice and Reconciliation Commission of Kenya," +
                            "a government oversight body that had been formed in response to the 2008 Kenyan post-election " +
                            "Violence, the Wagalla massacre represents the worst human rights violation in Kenya’s history. ", R.drawable.wagallamassacre),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("8") ){
            setUpToolbar();
            setTitle("Mandera");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData(" Dandu Hill","The Dandu Hill, in Mandera West alongside Chiracha Hills,is part of Mandera’s water-catchment currently protected, and enlisted for upgrading into a conservancy.Currently,less than 1% of its landmass has been designated for its conservation effort- in the Malka Mari National park.The founding of Dandu Hill Conservancy a longside 2 other conservancies,Arabi and Tabaka aims to diversify and conserve its outstanding accents. ", R.drawable. danduhill),


                    new MyMovieData("Marehan Sandstone","About 36km east of Tabakka town of the hills,and outcrops that dot the jagged landscape at Tabakka especially to the north,and northeast region,the Marehan Outcrop is perhaps the most dramatic and clear-cut of them.This sandstone formation rises 200 feet above the surrounding low limestone hillock.With its striking arc of strike ridges.Mostly “red” the Marehan appears to adjust colours at different times of the day.At dawn,and dusk the site is marked by a bright orange glow.The little-known Marehan has lots of possibilities as a hikers paradise. ", R.drawable.marehansandstone),


                    new MyMovieData("Elewak Ancient Wells","Livestock is the most important natural resource and is the main stay of the economy of Mandera.Livestock “grazing land” takes up a wide-ranging proportion of the rangeland resources.Of course, Mandera is a “water-scarce-area” and the nomadic pastoralists have had to devise ingenious ways to keep the livestock hydrated. The Ancient Wells which date back to 17th and 18th centuries, some of which are almost 60ft deep, are a salient lifeline for the livestock. ", R.drawable.elewakancientwells),


                    new MyMovieData("Malka Mari National Park","Malka Mari was gazetted in 1989 and is an IUCN (International Union for Conservation of Nature).Malka Mari National Park is situated along the banks of Daua River on the Kenya – Ethiopia border. It is approximately 1,500km2 in size and is located on the Mandera Plateau in the extreme north of Kenya. It has a high concentration of wildlife and plants with some plants being endemic to the area. The park is mostly semi-arid bushland and scrubby grassland with riparian woodland along the river.Malka Mari Park experiences a hot and dry climate and is yet to be developed to host tourists. ", R.drawable.malkamarinationalpark),


                    new MyMovieData("Malka Mari National Park","Malka Mari was gazetted in 1989 and is an IUCN (International Union for Conservation of Nature).Malka Mari National Park is situated along the banks of Daua River on the Kenya – Ethiopia border. It is approximately 1,500km2 in size and is located on the Mandera Plateau in the extreme north of Kenya.", R.drawable.malkamarinationalpark),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }




        else if (parsedStringID.equals("9") ){
            setUpToolbar();
            setTitle("Marsabit");

            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Huri Hills","The Huri Hills, a remote region of large lava cones,is located between the Chalbi Desert and the Kenyan-Ethiopian border in central-north Kenya.These hills rise about 300meters(985 feet) above the lava plateau,reaching 1524 meters(5000feet) above sea level.The diversity and abundance of birds in this location are breathtaking,especially for bird lovers.Here you also spotsome warthogs,Greater Kudu,Beisa Oryx and much more.", R.drawable.hurihills),


                    new MyMovieData("The Chalbi Desert","Located East of the famous Lake Turkana and spreading to the Ethiopian border,the magical desert is one of the hottest and most arid places in Kenya and covers an area of about 100,000-kilometre square.While storms are the most conspicuous sightings that greet you on reaching its fringes,Chalbi desert,itself is a bleached stretch of coarse sand spiced up with pure with pure rocks and immense clay.There are also ash-grey ridges and broken clusters of tiny huts.The desert is believed to have been a lake that dried up a thousand years ago,therefore,the name chalbi,which means bare and salty in the Gabbra dialect.", R.drawable.chalbidesert),


                    new MyMovieData("Shurr Conservancy ","Established in 2013, and immediately to the east of Marsabit,this conservancy has a lot potential.The 364km2 of rocky –lava terrain of grassland savannah( Under Northern Rangelands Trust) holds great promise and the communities within are now improving the infrastructure and their security operations.", R.drawable.shurrconservancy ),


                    new MyMovieData("Jarigole Pillars","The dimensional arrangement of its rock –pillars,the ornaments and beads and remts of the ancient burial site.This sequence of slender,tall pillars “standing guard” over a sleeping sun-scorched valley is one of the most exceptional achaeo-astronomical ramparts among the four main sights of its kind put –up near L.Turkana.", R.drawable.jarigolepillars),


                    new MyMovieData("Jaldesa Conservancy","Jaldesa Community Wildlife Conservancy was established by the community in the year 2013.This Wildlife Conservancy is located in Marsabit county in the Eastern province of Kenya,the 650km2 Jaldesa in the gently undulating plains is community run and it aims to set a “balance” between livestock keeping,and the preservation of the wildlife.", R.drawable.jaldesaconservancy),


                    new MyMovieData("Bongole Crater","Also known as, “Gof Bongole” with a diameter of about 2.5km, the crater was formed by a reaction between underground water and magma.The crater floor has a lake whose volume varies with rainfall, from a green marsh during the rainy times to a dry bed during the drier times.The lake serves as a grazing spot for animals.", R.drawable.bongolecrater),


                    new MyMovieData("Marsabit Cemetery","Found within Marasbit town, Marsabit cemetery is where the WW2 guard – posts overlooking the “Main Route” between Kenya and Italian East Africa.The cemetery commemorates the twenty-four troops who died in 1939 to 1945 war.", R.drawable.marsabitcemetery),


                    new MyMovieData("Mount Poi","The mountain, which is located in the Ndoto range, has one of the largest rock faces in Africa. It is an ideal destination for mountain climbers and nature lovers.", R.drawable.mountpoi),


                    new MyMovieData("Mount Ololokwe","The picturesque mountain is located along Isiolo – Marsabit highway. It is usually a huge draw for travelers with a thirst for adventure.", R.drawable.mountololokwe),


                    new MyMovieData("South Island National Park","It is an ideal park for game watching activities. It has one of the world’s largest concentration of crocodiles and abundant birdlife. It is also home to venomous reptiles such as snakes and prehistoric fish.", R.drawable.southislandnationalpark),


                    new MyMovieData("Kalacha Camp","It is situated on the edge of an oasis in the Chalbi desert. A small camp offers accommodation in four rustic bandas. It features a kidney-shaped swimming pool, a refreshing escape from the hot desert weather. Activities you can engage in here include; cultural visits to the Gabra villages take sundowners in the desert and visit the ancient rock arts within the area.", R.drawable.kalachacamp),


                    new MyMovieData("Mount Kulal","It is an eroded down extinct volcano located east of Lake Turkana, approximately 50 kilometers from Loiyangalani. It has an elevation of about 2,285 meters. It was designated as a biosphere reserve in 1978. The mountain provides opportunities for hiking, bird watching adventures and viewing of wild animals that visit the area. ", R.drawable.mountkulal),


                    new MyMovieData("El Molo Villages and Shrines","You can visit the El Molo villages and shrines to familiarise yourself with the rich El Molo culture. The El Molo shrines are found at Lorian Island. The sacred shrines are four in number and represent the four clans of the El Molo people.", R.drawable.elmolovillagesandshrines),


                    new MyMovieData("Loiyangalani Rock Arts","There are three main rock art sites in Marsabit County. The rock art sites include; Surima, Marti, and Afgaba. The rock arts consist of ancient images and symbols that illustrate different eras when the region supported different cultures and diverse human population.", R.drawable.loiyangalanirockarts),


                    new MyMovieData("Mount Marsabit","The forested realms of Marsabit National Park cover it. At the bottom of the mountain lies scenic crater lakes, swamps and an array of wild animals such as elephants, leopards, gazelles, buffalos and different species of birds. It offers amazing opportunities for hiking, sightseeing and bird watching adventures.", R.drawable.mountmarsabit),


                    new MyMovieData("Koobi Fora Museum","It is a world heritage site believed to be Dr. Richard Leakey discovered the cradle of mankind.The first Australopithecus skull here. The museum is open daily from 8.00 am to 6.00 pm. ", R.drawable.koobiforamuseum),


                    new MyMovieData("Desert Museum Loiyangalani","It was opened in June 2008. It is located on top of a hill, with a backdrop of the picturesque Lake Turkana. It was mainly established to preserve and enhance the indigenous culture of the local communities within Marsabit County and beyond. The indigenous communities in Marsabit have also continued to uphold their culture through festivals, artifacts, and games. ", R.drawable.desertmuseumloiyangalani),


                    new MyMovieData("Marsabit National Park and Reserve","The park covers an area of 1,554 square kilometers. It is a refuge for huge tusked bull elephants, diverse birdlife and different types of reptiles. Other attractions include; three craters, lake paradise and pristine forest that offers amazing opportunities for bird watching adventures and nature walks. ", R.drawable.marsabitnationalparkandreserve),


                    new MyMovieData("Sibiloi National Park","It lies on the northeastern shore of Lake Turkana. It was mainly established to protect and preserve the unique pre-historic/archaeological sites and wildlife found within Marsabit County. Attractions here include wildlife such as zebras, giraffes, hippos, crocodiles, flamingoes, gazelles, cheetahs, and leopards. Numerous pre-historic and archaeological sites are also located within the park. ", R.drawable.sibiloinationalpark),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("10") ){
            setUpToolbar();
            setTitle("Isiolo");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Bisadi National Reserve","Bisadi National Reserve is a wildlife sanctuary also called Kinna national reserve with an area of 606sq km. It is managed by the KWS. Bisadi National Reserve is next to the Meru National Park and the border between the two parks is the traditional boundary between the Meru and the Borana people of eastern province, the reserve was opened in September 1979.The reserve has many species of mammals including lion,elephant,cheetah,rhino,buffalo,hippos and over 400 species of birds. ", R.drawable.bisadinationalreserve),


                    new MyMovieData("Buffalo Springs National Reserve","Buffalo Springs National Reserve Kenya was, named after an oasis of clear water at its western end. It is the natural home to five rare species known as the five northern species, which are endemic to this area: Grevys Zebra, Somali ostrich, Reticulated Giraffe, Gerenuk and the Beisaoryx. The reserve is home to the endangered Grevy’s Zebra,elephant,gerenuk,oryx,giraffe,leopard,lion,cheetah,hyena and buffalo.The park has recorded over 365 species of birds that include the Somali ostriches that are widespread. ", R.drawable.buffalospringsnationalreserve),


                    new MyMovieData("Shaba National Reserve","Shaba National Reserve Kenya is the home of Joy Adamson’s monument. There is one lodge in Shaba with 178 beds and one tented lodge with 34. The major attractions are the scenic landscape and riverine forest and 17 springs where animal congregate during the dry season.Driving to the park you will often see Samburu herding cattle through the thorn bush or watering camels in the river.The Ewaso Ngiro River is life-giving for the area.The permanent water ensures that an abundance of wildlife exists in the reserve at all times. ", R.drawable.shabanationalreserve),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("11") ){
            setUpToolbar();
            setTitle("Meru");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("The River Kathita Waterfall","It is a scenic waterfall popularly referred to as ‘ndurumo ya M’ntanii’ by the locals. It lies close to another small waterfall from River Mpuri. It is a scenic waterfall that you actually need to visit if you are a lover of nature.", R.drawable.riverkathitawaterfall),


                    new MyMovieData("Devils’ Bridge Waterfall","It is located along the Meru-Nkubu Highway, about 300 metres from Gikumene primary school. It is a splendid waterfall that drops down to about 300 feet, hits upon rocks before forming a small natural dam. The place was an important source of ochre that was used by early African communities for body decoration.", R.drawable.devilsbridgewaterfall),


                    new MyMovieData("Giitune Sacred Forest","An indigenous forest falls within the larger Mount Kenya forest eco-system. Many traditional myths and taboos are associated with the forest, which was believed to house an enormous serpent that guarded the forest. The forest features many species of flora, fauna and divergent birdlife. ", R.drawable.giitunesacredforest),


                    new MyMovieData("Nyambene National Reserve","It was named after the famous Nyambene hills. It features one of the most breath-taking craters in Kenya- Igombe, which is located at the northeast tip of the Nyambene range. It also features over 100 species of birds, leopards, cheetahs, giraffes, antelopes, zebras, cheetahs, leopards and lions. ", R.drawable.nyambenenationalreserve),


                    new MyMovieData("Meru Equator Tamaduni Cultural Centre","It is a private museum where over 300 Meru traditional artefacts are displayed. Some of the artefacts you can find there include; kitchenware, clothing, farm implements, ornaments and weaponry. ", R.drawable.meruequatortamaduniculturalcentre ),


                    new MyMovieData("Mount Kenya","It is the highest mountain in Kenya and the second largest in Africa after Mount Kilimanjaro. A breath-taking world heritage site features dense forests, mineral springs, glaciers and different species of wild animals. It is a perfect destination for camping, hiking and mountain climbing. ", R.drawable.mountkenya),


                    new MyMovieData("Lewa Wildlife Conservancy","A private wildlife sanctuary was formed in 1995. It is home to a variety of wildlife such as the endangered black rhinos, Grevy’s zebras, sitatungas, lions, leopards, elephants, cape buffaloes, cheetahs, giraffes and different species of birds.The most notable conservation efforts at Lewa are those focused on black rhinos and Grevy’s Zebras. ", R.drawable.lewawildlifeconservancy),


                    new MyMovieData("Ngare Ndare Forest","It is a lush indigenous forest located at the foothills of Mount Kenya. It features amazing waterfalls, rock pools, wild animals and diverse bird species. It is an ideal destination for tree canopy walk, camping, rock climbing, game drives, canyoning and bird watching. ", R.drawable.ngarendareforest),


                    new MyMovieData("Meru National Museum","It originated in 1974 in an old historic building that dates back to 1916. The museum features a garden of indigenous medicinal shrubs, a compound of traditional huts, various displays and exhibitions of the cultural history of the Meru people. ", R.drawable.merunationalmuseum),


                    new MyMovieData("Meru National Park","The park covers an area of 870 square kilometres. It features coursing rivers, luxurious jungle, verdant swamp, khaki grasslands, different bird species and game animals such as zebras, elephants, reedbucks, buffalos and diverse species of snakes. It is a perfect park for camping, nature trails, bird watching and game viewing activities ", R.drawable.merunationalpark),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("12") ){
            setUpToolbar();
            setTitle("Tharaka-Nithi");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Ura Gate ","Ura Gate sits next to the riverside forests of Ura river.One of the Tana River’s tributaries.Ura Gate has been a contention between Meru and Tharaka Nithi route to the park.This is a remote area,with farms and scattered settlement occupying the opposite side of the river.It also is on the Southwestern end of Meru national park and near the equator.", R.drawable.uragate ),


                    new MyMovieData("The Mighty Mutungurini","Among the major attractions in the county is Mutungurini tree at Ndagani Village which is considered sacred to the Chuka sub-tribe and has served as a shrine where community elders go for divine intervention in times of drought or other calamities.The tree which is about 40 meters tall is probably the tallest tree in Kenya,though residents here believe it is the tallest in Africa.The story of the tree is also well known to the residents and has attracted a significant number of visitors over the years.Apart from the tourism and religious functions,the tree also serves as a crucial landmark and is visible from any point of the county and is commonly used as a sign post for navigation in the county.Whereas it is an important landmark,the tree is also home to the world deadliest vipers which have been responsible for many fatalities including many deaths and limb amputation among residents.Some of the largest pythons and other serpents’species in the county are also found here. ", R.drawable.mightymutungurini),


                    new MyMovieData("duru Bat Caves","In many parts of Africa,tribespeople like to associate bats with dark forces.Quite the contrary,bats are a keystone to pollination and a big-time check on insects;and thus play a critical part in the beauty of life.African bats will feed on fruits and mostly flying insects.Its a spectacular display at dusk as one million (plus) strong cloud of bats head-out from an isolated cave in Ganga village to feed.While it may spook some,the local are oblivious of the unveil and they have learnt to co-exist happily.", R.drawable.durubatcaves),


                    new MyMovieData("Kibuuka Falls","The hidden treasres of Kibuuka waterfalls form a beautiful scenery for locals and visitors touring Marimanti in Tharaka Nithi county.The falls draw its name from a man and his family who threw themselves into the Tana River waters on poverty grounds. ", R.drawable.kibuukafalls),


                    new MyMovieData("Weru Tea Factory","Tea is one of the most important exports of Tharaka Nithi which is prominent around its upper zone.Much of the beauty of the region arises from flush tea-landscapes.Weru Tea Factory is located in Muthambi Division,Tharaka Nithi County.It is about 1.5kilometres from Marima town,off the Embu-Meru highway.The tea factory in Tharaka Nithi welcomes guests and offers fine insights of the enriching “journey” of tea from farm to cup.This trip includes:weighing,fermentation,timed-dying,sieving and grading.", R.drawable.weruteafactory ),


                    new MyMovieData("Waterfalls of Tharaka Nithi","The landscape of Tharaka Nithi is chaperoned by a farrago of lovely waterfalls,modest and big,which provide a unique way to explore it.In all it is reported that this region has fifteen falls,most of which are only little known and serve only as village delights.Among its catalogue of scenic,falls includes the Ura Falls;Kibuuka,Ururuni and Ikwa falls in Tharaka;Machi,Ngoki and Mwanyingi waterfalls in Chuka; Mwita,Munyiithi Katheruka and the Kandakame waterfalls in Maara.All its falls are for trekking trips. ", R.drawable.waterfallsoftharakanithi),


                    new MyMovieData("Mt.Kenya Park","Locally known as Mt.Kirinyaga which loosely translates to the “Place of God or Mwene Nyaga”.It is arguably the most pleasing scenery in kenya.Overlooking central ,this world heritage site takes-up all the land the mountain over 11,000ft and parts of Lewa and Ngare Ndare.Mount Kenya is a world heritage site.It’s the only snow-capped mountain in the entire globe which lies along the equator and Chogoria Route in Tharaka Nithi was once the preferred route for hikers.Apart from hiking,this route offers a unique opportunity to enjoy the magical sceneries alongside the flora and fauna.", R.drawable.mtkenyapark),


                    new MyMovieData("Lake Michaelson","Located in the heart of Mount Kenya,this small glacier lake collects the meltwater that comes from its impressive heights.The lake got its name from a friend of the first explorer to summit Mount Kenya.Halford Mackinder always commented this person had taken much interest in his 1899 expedition and thanked him for it in this completely immortal way.One of its most spectacular features is the infinity pool-like effect on its outlet stream,right on the outer edge of the lake.Its water is also rich in fauna,with plenty of Rainbow trout inhabiting it. The lake boasts 360-degree breathtaking views.It is so up, that vegetation is scarce.", R.drawable.lakemichaelson),


                    new MyMovieData(" Mutejwa Reserve","Established in 1959 as the Mutejwa Forest Reserve, this 13.76km2 park in the forest that lines up along the Nithi River is best known for a variety of wildlife; most notably antelopes monkeys.The reserve is served by a navigable network of park-routes.", R.drawable.mutejwareserve),


                    new MyMovieData("Chogoria Route","This 30kms route,from the base to Point Lea,on the eastern side of Mt.Kenya is the longest but it is alsoplausibly the most formidable of the seven routes.But for all the effort it takes hikers are rewarded with great sights which include: Lake Alice,the Temple,Lake Michaelson,Hall Tarns,the Giant Billiard Table,Ithaguni Hills,Nithi Falls,and vast magnificent cliffs.Chogoria route starts at the Chogoriagate from where most hikersdrive up the Bamboo Forests,to the Mt.Kenya Bandas.It’s an 8 hrs hike Minto Camp which is the next stop then up Lea.", R.drawable.chogoriaroute),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("13") ){
            setUpToolbar();
            setTitle("Embu");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Kianjiru Hills","The scenic hills feature bushlands and indigenous trees, which form a habitat for different species of birds. It is also among the top hiking destinations in Embu County. It offers amazing opportunities for photo shoots and sightseeing of the seven forks dams and other scenic sites in Embu County.", R.drawable.kianjiruhills),


                    new MyMovieData("Camp Ndunda Falls","It is located at the foothills of Mount Kenya, approximately 8 kilometres from Embu town. It is a beautiful place where you can relax and engage in outdoor activities such as hiking, mountain cycling, zip lining, canopy walking, bird watching, nature trails and camping.", R.drawable.campndundafalls),


                    new MyMovieData("Izaak Walton Inn","A luxury hotel offers accommodation in guest rooms categorized as superior rooms, deluxe rooms and executive rooms. It also prides in a garden restaurant, modern conference facilities and a state of the art swimming pool for recreational purposes.", R.drawable.izaakwaltoninn),


                    new MyMovieData("Mau Mau Caves","The scenic caves are located within the Kirimiri Forest. The caves were used as hideouts by Kenyan freedom fighters during the mau-mau uprising.", R.drawable.maumaucaves),


                    new MyMovieData("Kiangombe Hill","The magnificent hill also offers amazing opportunities for hiking, birdwatching and sightseeing adventures. Locals believe that the hill is a center for witchcraft practices in Embu County.", R.drawable.kiangombehill),


                    new MyMovieData("Kirimiri Forest","The forest is dominated by rare indigenous trees with thick undergrowths frequented by wild animals and diverse species of birds. It is one of the best hiking, camping, birdwatching and picnicking destinations in Embu County.", R.drawable.kirimiriforest),


                    new MyMovieData("Seven Forks Power Plants","You can visit the power plants located in Embu, to have a glimpse of how hydroelectric power is generated. The hydroelectric power plants include; Gitaru, Kamburu, Kindaruma, Kiambere and Masinga.", R.drawable.sevenforkspowerplants),


                    new MyMovieData("Nthenge Njeru Falls","It is a double waterfall located in Runyenjes, off the Embu-Runyenjes road. It is a splendid waterfall that is surrounded by beautiful vegetation that provides a conducive habitat for wild animals and over 50 species of birds.", R.drawable.nthengenjerufalls),


                    new MyMovieData("Karue Hill","It is a scenic hill located off the Embu-Runyenjes Road; about 30 minutes drive from Embu town. It offers amazing opportunities for hiking, camping, picnicking and sightseeing of Embu County and its environs.", R.drawable.karuehill),


                    new MyMovieData("Mwea National Reserve","It is located in Mbeere district. The reserve’s ecosystem comprises of small hills with bushy vegetation and scattered trees, which are breeding grounds for wild animals such as elephants, zebras, giraffes, bushbucks, buffalos, impalas, vervet monkeys, baboons, gazelles, warthogs and sykes. You can visit the reserve for game viewing and bird watching adventures.", R.drawable.mweanationalreserve),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }

        else if (parsedStringID.equals("14") ){
            setUpToolbar();
            setTitle("Kitui");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Mutha Hills"," It is also a hiking and birding destination located in Kitui south. Different species of birds can be spotted within the hills covered by forests and thorny bushes ", R.drawable.muthahills),

                    new MyMovieData("Kaningo Campsite"," The campsite is located in Mwingi North sub-county. It was established to host visiting tourists in Kitui County. Game rangers are located within the campsite to enhance security and ensure visiting tourists have a comfortable stay. ", R.drawable.kaningocampsite),

                    new MyMovieData("Mutito Hills "," It is an important birding and hiking destination in Kitui. Over 100 species of birds can be spotted within the hills. ", R.drawable.mutitohills ),

                    new MyMovieData("Muumoni Hills"," It is a wonderful hiking and birding destination located in Mwingi North. The hill is surrounded by thorny bushes and forests, which are breeding grounds for different types of snakes and porcupines. You can also explore the gigantic cave located within the hills. ", R.drawable.muumonihills),

                    new MyMovieData(" Ikoo Valley"," The scenic V-shaped valley is located in Migwani, Mwingi West sub-county. It offers a vantage point for photographic opportunities of undulating hills and beautiful sceneries in Kitui County and beyond. ", R.drawable. ikoovalley),

                    new MyMovieData(" Ngomeni Rock"," It is a scenic rocky outcrop located in Mwingi. Thorny bushes surround the rock and numerous caves, which you actually need to explore when visiting Mwingi. A large dam is also located near the rock. This is one place you need to visit for hiking adventures and sightseeing of Mwingi Town and its environs. ", R.drawable. ngomenirock),

                    new MyMovieData("Mutomo Hill Plant Sanctuary"," It is a botanical garden located about 75 kilometers south of Kitui Town. The sanctuary features over 100 species of indigenous trees and plants believed to have medicinal value. It is a nice place to visit for bird watching adventures, camping, nature walks and picnicking. ", R.drawable.mutomohillplantsanctuary),

                    new MyMovieData(" South Kitui National Reserve"," It was established in 1979 and covers an estimated area of 1,833 square kilometers. Wild animals that relocate to and from Tsavo National Park frequent the reserve. Some of the wild animals that frequent the reserve include lions, elephants, giraffes, leopards and the lesser kudu. It is a hidden game suitable for bird watching adventures, game viewing and camping. ", R.drawable. southkituinationalreserve),

                    new MyMovieData("Mwingi Game Reserve"," The reserve covers an area of approximately 745 square kilometres. It can be accessed via Thika to Mwingi then Northeast through Kyuso village. Animals frequently visit the reserve from other neighbouring reserves and parks. It is a designated wilderness activity zone that offers amazing opportunities for fly camping, camel and horseback safaris. ", R.drawable.mwingigamereserve),

                    new MyMovieData("Nzambani Rock"," It is a stone outcrop that is locally known as Ivia ya Nzambani. It is situated about 10 kilometres from Kitui town, along the Kitui-Mutitu road. It is a popular attraction in Kitui due to the myths that surround it. Locals claim that if you go round the rock seven times, your gender automatically changes. It is a perfect destination for hiking adventures and sightseeing. ", R.drawable.nzambanirock),



            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("15") ){
            setUpToolbar();
            setTitle("Machakos");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Komarock Shrine "," It is a sacred sculpture of Jesus held by his mother Mary located near Tala Town; 2.5 km off Kangundo Road. ", R.drawable.komarockshrine ),
                    new MyMovieData("The African Heritage House","It is located next to AIC Kasina church in Mlolongo. It is a showpiece of African culture and heritage. It contains a collection of African art and furnishings. It is also available for meals, conferences, and overnight stays in rooms filled with African art and furnishings. ", R.drawable.africanheritagehouse),
                    new MyMovieData("Mua Hills","The hills are located off Mombasa road. They are small hills with thorny bushes and vegetation. The hills are ideal for hiking activities, more so for those hiking for the first time. ", R.drawable.muahills),
                    new MyMovieData("Lukenya hills ","The hills are located off the Nairobi-Mombasa highway. It features savannah shrubland with spectacular rocks that offer opportunities for hiking, sightseeing and wildlife viewing on the surrounding Athi plains. ", R.drawable.lukenyahills ),
                    new MyMovieData("Maanzoni Sanctuary","It is set on a 10000-acre ranch that prides in great vistas and game such as zebras, giraffes, elands, swara, wildebeest, gazelles, ostriches and diverse birdlife. A luxury lodge that offers exquisite dining and spacious accommodation is located within the ranch. ", R.drawable.maanzonisantuary),
                    new MyMovieData("Masinga Dam","It is the main reservoir in the hydropower complex of seven forks scheme. It straddles the border of Machakos and Embu counties, located approximately 106 kilometres from Nairobi. You can visit the dam to see how electricity is generated from water. ", R.drawable.masingadam),
                    new MyMovieData("Machakos People’s Park","It is located a few kilometres from Machakos town, next to Machakos agricultural showground. It is a unique park complete with a field amphitheatre, children’s’ play area, dancing water fountain, solar exhibition stands, conference facilities, miniature golf courses, restaurants and an artificial lake ideal for speed boat rides. ", R.drawable.machakospeoplspark),
                    new MyMovieData("Kyamwilu Magical Corner"," It is a mysterious attraction located along the Machakos- Mutituni road, where nature defies gravity. It is a magic corner where people visit to watch water flow upwards the hill instead of downwards. You can actually experiment by pouring water at the spot. You will be shocked to see the water flowing uphill instead of downhill. ", R.drawable.kyamwilumagicalcorner),
                    new MyMovieData("Lukenya Caves"," The caves were hideouts for mau-mau freedom fighters during the pre-colonial era. It is only a 5 minutes drive from Mombasa road to the caves. ", R.drawable.lukenyacaves),
                    new MyMovieData("Iveti Forest"," It is the second highest peak in Machakos County. It features scenic peaks, spectacular cedar trees, pine trees and abundant birdlife. You can visit the forest for birdwatching activities and hiking. ", R.drawable.ivetiforest),
                    new MyMovieData("Ol Donyo Sabuk National Park"," The park is dominated by a small mountain covered in montane forest. Buffalos, over 45 bird species, leopards, bushbucks, olive baboons, aardvarks, porcupines, monitor lizards and pythons are the main attractions at the park. A gravesite (Macmillan grave) is also located within the park. ", R.drawable.oldonyosabuknationalpark),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("16") ){
            setUpToolbar();
            setTitle("Makueni");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Mbooni Hills ","The scenic hills also offer perfect opportunities for hiking, birdwatching adventures, and sightseeing of the spectacular sceneries of Makueni County and beyond. ", R.drawable.mboonihills ),
                    new MyMovieData("Hunters Lodge"," It is a classic lodge set on 25 acres of lush gardens. It offers comfortable accommodation in 62 luxury guest rooms, which are fully furnished and very spacious. It is a paradise for bird watching adventures, as it hosts over 100 species of birds. It also features a stylish swimming pool perfect for recreational purposes. ", R.drawable.hunterslodges),
                    new MyMovieData("Campi Ya Kanzi"," It is an exquisite eco-tourism lodge situated at the foot of the legendary Chyulu Hills. It offers a combination of 5-star luxury, first class wilderness adventure and memorable wildlife encounters. ", R.drawable.campiyakanzi),
                    new MyMovieData("Kilima Kiu Manor","It is a boutique country home nestled in the serene Malili area. An exquisite place offers luxury accommodation in spacious guestrooms. It features a state of the art restaurant that serves sumptuous meals, a modern swimming pool, and top-notch events facilities. It also offers opportunities for nature walks, bird watching adventures, camping, biking, and hiking. ", R.drawable.kilimakiumanor),
                    new MyMovieData("Makongo Valley"," The 40 kilometers long valley is located along the Machakos-Makueni-Makindu road. It features panoramic viewpoints where you can have a glimpse of the beautiful sceneries and landscape that surround Makueni County. ", R.drawable.makongovalley),
                    new MyMovieData("Mbui Nzau Hills","The spectacular hills are located about 5 kilometers from the Kibwezi junction, along the Nairobi-Mombasa highway. It is a sacred place where the Akamba used to offer their sacrifices. Locals claim that a white goat used to appear on top of the hills very early in the morning, just before the arrival of missionaries. It is one of the best hiking and sightseeing spots in Makueni County. ", R.drawable.mbuinzauhills),
                    new MyMovieData("Kenya’s first AIC Missionary Church"," Makueni County prides in hosting the first AIC Missionary church in Kenya. Peter Cameron Scott, a Scottish missionary, constructed the church in 1895. The church is located in Kalamba village and is believed to have pioneered the emergence of Christianity in Kenya. ", R.drawable.kenyasfirstaicmissionarychurch),
                    new MyMovieData("Peterson Camp Ruins","It is located in Mtito Andei, off the Nairobi-Mombasa highway. A historical site used to be former president Jomo Kenyatta is resting place whenever he visited the lower parts of the former eastern province. ", R.drawable.petersoncampruins),
                    new MyMovieData("Sikh Temple Makindu"," It is located along the Nairobi-Mombasa highway, approximately 170 kilometers from Nairobi. Sikhs who were working on the construction of the Kenya-Uganda railway built it in 1926. A holy shrine also features a dining facility that provides free langar (food) to visitors. ", R.drawable.sikhtemplemakindu),
                    new MyMovieData("Chyulu Hills National Park"," The park is popularly known as Green Hills of Africa. Its estimated size is 741 square kilometers. It is a scenic park that is dotted by verdant rolling hills of endless green, magnificent caves, wildlife such as elephants, bushbucks, buffalos, elands, leopards, bush pigs, giraffes, giant forest hogs and over 100 species of birds. It offers amazing opportunities for camping, game viewing, bird watching adventures, mountain climbing, and horse riding. ", R.drawable.chyuluhillsnationalpark),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("17") ){
            setUpToolbar();
            setTitle("Nyandarua");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Ndaragwa Waterfall"," It is located off the Nyeri-Nyahururu Highway, within the Ndaragwa forest station. It can be viewed from the footbridge at the bottom of the Ndaragwa nature trail, which is also located within the forest station. ", R.drawable.ndaragwawaterfall),
                    new MyMovieData("Karuru Falls"," The magnificent waterfall is located within the Aberdares National Park. It is the longest and highest waterfall in Kenya. Beautiful indigenous trees and vegetation surround the breathtaking waterfall, which attracts different species of birds. It is actually one of the unique places to visit in Nyandarua County. ", R.drawable.karurufalls),


                    new MyMovieData("Ndaragwa Nature Trail","It is located along the Nyeri-Nyahururu Highway, about 230 kilometres from Nairobi. It is situated in Ndaragwa forest station that is managed by the Kenya Forest Service. The trail offers a quiet and amazing walk with panoramic views of lush forest and Ndaragwa town. ", R.drawable.ndaragwanaturetrail),


                    new MyMovieData("Mau Mau Caves ","You can also explore the numerous mau-mau caves located in Aberdares forest. The caves were used as hideouts by freedom fighters during the mau-mau uprising. Other attractions such as scenic waterfalls are also located around the caves. ", R.drawable.maumaucaves ),


                    new MyMovieData("Elephant Hill","It is located on the southern end of the Aberdare Range. It is a favourable location for day hikes, guided walks and bird watching adventures. It is also a perfect hiking destination for hardy hikers. ", R.drawable.elephanthill),


                    new MyMovieData("Rurimueria Hill","The hill can be accessed through the Ndunyu Njeru gate in Kigop. It is part of the Aberdares National Park. The hill features tangled forests, bamboo thickets and abundant birdlife. It is a perfect place for hikers, particularly those who love hard hikes. ", R.drawable.rurimueriahill),


                    new MyMovieData("Aberdare Range"," It is a 160km long mountain range with an average elevation of 3,500 meters. It contains a rich diversity of vegetation and forests. Western edges of the mountain range are inhabited by wildlife such as elephants, buffalos, colobus and Sykes monkeys. It is a nice place to visit for hiking and camping adventures. ", R.drawable.aberdarerange),


                    new MyMovieData("Kinangop Plateau","It lies between the Great Rift Valley to the west and the Aberdare Range to the east. A beautiful plateau is relatively flat and slopes gradually upwards towards the foothills of the Aberdares. Several rivers cut into the plateau, which has an edge of about 2,400 meters in elevation. ", R.drawable.kigopplateau),


                    new MyMovieData("Mount Kipipiri"," It is an isolated volcano located on the northwestern side of the Aberdares. It stands at an elevation of 3,349m. It is one of the best hiking and camping destinations in Nyandarua County. Wildlife such as elephants, buffalos, colobus and Sykes monkeys can be found within the area. ", R.drawable.mountkipipiri),


                    new MyMovieData("Lake Ol Bolossat","It is the only natural lake in the central region of Kenya. A small freshwater lake is approximately 43.3 square kilometres. The lake is known for its abundant birdlife and hippos. You can visit the lake for bird watching and hippo viewing adventures. ", R.drawable.lakeolbolossat)

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("18") ){
            setUpToolbar();
            setTitle("Nyeri");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Rhino Watch Camp"," It is set in 30 acres, just adjacent to the Solio rhino sanctuary. It is surrounded by 3 wildlife reserves, thus provides an ideal base for safari game drives and beautiful views of Mount Kenya. Other facilities offered at the rhino watch camp include; luxury accommodation for wildlife enthusiasts, bush meals, game walks and an art gallery for traditional artefacts. ", R.drawable.rhinowatchcamp),

                    new MyMovieData("Chinga Dam and Waterfall"," The magnificent waterfall is located near Othaya town, on your way to Chinga Boys. Chinga dam is actually the biggest water reservoir in Nyeri County. The dam offers opportunities for fishing and boat riding activities. You can visit the place to have a glimpse of the magnificent waterfall and to engage in boat riding activities in Chinga dam. ", R.drawable.chingadamandwaterfall),


                    new MyMovieData("Thunguma Museum"," The museum was opened in 1998 to preserve, communicate and inform about the Kikuyu culture and origin. The museum features traditional artefacts of the Kikuyu and live animals such as crocodiles, tortoise and porcupines. ", R.drawable.thungumamuseum),


                    new MyMovieData("Italian War Memorial Catholic Church"," Italian soldiers who were captured as prisoners during World War 2 built it. The church is characterized by a beautiful architectural design, with names of fallen soldiers inscribed on the walls. There is also a tomb and a shrine within the compound. An annual mass is usually held in November to commemorate the fallen Italian soldiers. ", R.drawable.italianwarmemorialcatholicchurch),


                    new MyMovieData("Mau Mau Caves"," It is a historic site located in Narumoru forest, that was used as a hideout by freedom fighters during the mau-mau uprising. Beautiful attractions such as waterfalls and indigenous forests with monkeys and birds are also located around the caves. It is a paradise for hiking and bird watching. ", R.drawable.maumaucaves),


                    new MyMovieData("Chaka Ranch"," It is a leisure park and entertainment facility located in Kiganjo. It is set on an expansive space that offers beautiful sceneries and views of Mount Kenya and the Aberdare mountain range. It is a perfect haven for outdoor lovers. It boasts of the biggest and widest collection of quad bikes and buggies in Kenya. It also offers luxury accommodation in tented camps. ", R.drawable.chakaranch),


                    new MyMovieData("Baden Powell Museum"," It was named after Lord Baden Powell, the founder of the Boy Scout Movement Association. The museum features scouting scarfs and other attires aimed at preserving, exhibiting and communicating the heritage of the Boy Scout Movement. It is located along the Nyeri-Kamakwa road, in the Outspan hotel compound. ", R.drawable.badenpowellmuseum),


                    new MyMovieData("Solio Ranch"," It is a private ranch that was established mainly for the purpose of rhino conservation. It is one of the most successful private rhino breeding ranches in Kenya. The ranch is also inhabited by other wildlife such as buffalos, zebras, gazelles, giraffes, antelopes, waterbucks, oryx and warthogs. You can visit the ranch for game viewing activities and nature walks. ", R.drawable.solioranch),


                    new MyMovieData("Aberdare National Park"," Steep forested ravines and open moorland characterize the park. It is a habitat for abundant birdlife and wildlife such as elephants, leopards, black rhinos, buffalos, colobus monkeys, warthogs, bushbucks, spotted hyenas and olive baboons. It is a perfect destination for game viewing, bird watching, camping and nature walk. ", R.drawable.aberdarenationalpark),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("19") ){
            setUpToolbar();
            setTitle("Kirinyaga");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Nice Digital Hotel"," It is an elegant hotel popularly known as ‘Happiness Paradise’, located in Mwea. It offers luxury accommodation in superb guest rooms, exquisite dining and recreational activities such as swimming. It also prides in well-manicured lawns, which offer amazing opportunities for holding social events. ", R.drawable.nicedigitalhotel),


                    new MyMovieData("Sagana Canyon/Gorge"," This deep and narrow passage cuts through the surface of the earth with steep cliffs on both sides. It forms when a river cuts through resistant rocks. From here, you get a breathtaking view of the beautiful Kiambicho and Kiamuti hills. ", R.drawable.saganacanyon),


                    new MyMovieData("Nokras Riverine SPA and Lodge"," It is a luxury resort located on the hills of Sagana, just next to River Sagana. It offers exquisite accommodation in luxury rooms that offer breathtaking views of scenic hills and Mount Kenya. The guest rooms are categorized as deluxe rooms, family rooms, executive rooms, business rooms and honeymoon rooms. The resort also features a fitness center, spa and sauna, a swimming pool, state of the art restaurants and a well-manicured garden ideal for holding outdoor events. ", R.drawable.nokrasriverinespaandlodge),


                    new MyMovieData("Savage Wilderness"," It is also located in Sagana Town. It provides unique and breathtaking experiences in one of nature’s most beautiful environments in Kirinyaga County. It is an ideal destination for team building activities, rafting, kayaking, swimming adventures, camping, mountain biking, zip lining and rock climbing. ", R.drawable.savagewilderness),


                    new MyMovieData("Jangwani Camp"," It is located in Sagana, along the Nyeri-Nairobi Highway. It offers luxury accommodation in tented camps and exquisite opportunities for swimming, simple rafting, fishing, main rafting, kayaking, nature walks, archery, mountain biking and team building activities. ", R.drawable.jangwanicamp),


                    new MyMovieData("Timstep Hotel and Campsite","It is a magnificent hotel located in Sagana Town. It has well-equipped cottages and lush gardens that offer amazing opportunities for retreats, camping and picnicking. It is also an ideal spot for water sports such as kayaking and river rafting. ", R.drawable.timstephotelandcampsite),


                    new MyMovieData("Ndaraca Ya Ngai"," It is a mysterious natural bridge located off the Nairobi-Embu highway that nobody has a definite answer on how it came into existence. Scenic caves that were used by the Mau Mau as hideouts are also located within the mysterious natural bridge. ", R.drawable.ndaracayangai),


                    new MyMovieData("Rapids Camp"," It is a leading adventure and team building spot located in Sagana Town. It is one of the best destinations in Kenya for camping, zip lining adventures, white water rafting, river trekking, bungee jumping, chopper trips, kayaking, bird watching, sports fishing, river boarding and rock climbing adventures. It also prides in the Rapids camp falls, which is a favourite natural hotspot attraction for most adventure lovers. ", R.drawable.rapidscamp),


                    new MyMovieData("Thingira Cultural Village"," It is a multicultural village located along the Nyeri-Nairobi highway, at the intersection of Kirinyaga, Murang’a, Embu and Machakos counties. It was mainly established to promote, preserve and foster cultural activities of the Mount Kenya people. It features four traditional homesteads complete with artefacts that demonstrate the traditional lifestyles of the Mount Kenya people. It is definitely the best place to have a cultural experience of the Mount Kenya people. It is also an excellent place for camping, bird watching, rock climbing and cycling adventure ", R.drawable.thingiraculturalvillage),


                    new MyMovieData("Castle Forest Lodge"," It is an eco-tourism facility set in a natural surrounding of rainforest, freshwater rivers with falls and fabulous views of the impressive peaks of Mount Kenya. It is a perfect getaway for nature walks, bird watching, trout fishing, horseback riding and swimming adventures. It offers luxury accommodation in cottages, bungalows, chalets and budget rooms. ", R.drawable.castleforestlodge),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("20") ){
            setUpToolbar();
            setTitle("Murang'a");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Sagana Getaway Resort"," This is a popular luxury hotel located in Makuyu, Murang’a County. It offers luxury accommodation in spacious guest rooms, which are categorised as superior rooms, executive family suite, deluxe room and executive suite. It also features a swimming pool, bar/lounge, conference facilities and an onsite restaurant that serves local and international dishes. ", R.drawable.saganagetawayresort),


                    new MyMovieData("Muchiri’s Resort"," It is a picnic and camping haven located on the shores of Ndakaini dam, off the Gatanga- Ndakaini Road. The resort is also an ideal spot for team building activities, nature walks, whiking adventures and a gateway to the serene countryside of Murang’a. ", R.drawable.muchirisresort),


                    new MyMovieData("Stanley’s Haven"," It is a holiday resort tucked on the leafy suburbs of Makuyu. It is an ideal destination for weekend getaways, swimming adventures and team building activities. It also offers an executive and private guesthouse experience. ", R.drawable.stanleyhaven),


                    new MyMovieData("Mathioya River","It is one of the hardest rafting rivers in Kenya, located in Mathioya constituency. It also offers amazing opportunities for kayaking and swimming adventures. ", R.drawable.mathioyariver),


                    new MyMovieData("Aberdare Cottages"," It is one of the finest destinations in Murang’a County ideal for hiking adventures, fly fishing, mountain biking and boat riding adventures. The luxury cottages also offer a picturesque view of the green Murang’a scenery. ", R.drawable.aberdarecottages),


                    new MyMovieData("Karia Ka Mbari Ya Ngware"," A cultural heritage site has a rich history on the origin of the Agikuyu. It is also a sacred place where Kikuyu elders conduct sacrifices, prayers and other traditions. ", R.drawable.kariakambariyangware),


                    new MyMovieData("Kimakia Fishing Grounds","It is one of the finest fishing adventure locations in the central region. The Kimakia stream offers amazing opportunities for fishing adventures in Muranga County. The stream is located within the Kimakia Forest, which is a conservation area of the Aberdares National Park. ", R.drawable.kimakiafishinggrounds),


                    new MyMovieData("Ndakaini Dam","The scenic dam is located in Gatanga constituency. It is the main source of water for the Nairobi water company, which supplies water to residents of Nairobi County. The reservoir has a storage capacity of about 70 million cubic meters of water. One of the notable aspects of the dam is the Ndakaini half marathon, which was established in 2004, under the auspices of the Ndakaini Dam Environment Conservation Association. ", R.drawable.ndakainidam),


                    new MyMovieData("Tuthu Catholic Church Mausoleum"," Tuthu Catholic Church wasestablished in 1902 byConsolata missionaries. The church houses Chief Karuri Wa Gakure’s mausoleum. Karuri Wa Gakure was a paramount chief who welcomed the very first missionaries in Central Kenya. He assigned the missionaries a compound to stay and allowed them to conduct their first mass under a Mugumo tree, a very sacred tree among the Agikuyu. A shrine is also located within the compound of the Catholic Church. ", R.drawable.tuthucatholicchurchmausoleum),


                    new MyMovieData("Mukurwe WA Nyagathanga Shrine"," It is a mythical ‘Garden of Eden’ for the Agikuyu community, believed to be the origin and home to Agikuyu ancestors (Gikuyu and Mumbi). You can visit the place to learn more about the Kikuyu culture and have a glimpse of their traditional artefacts. ", R.drawable.mukurwewanyagathangashrine),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }

        else if (parsedStringID.equals("21") ){
            setUpToolbar();
            setTitle("Kiambu");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Sigona Golf Club","It is located in Kikuyu, along the Nairobi- Naivasha highway. It is situated in a serene environment with beautiful flower bushes and scenic greenery. It is the ultimate hub for golfers in Kiambu County and beyond. It combines luxury, exceptional service and the ultimate golfing experience. ", R.drawable.sigonagolfclub),


                    new MyMovieData("Thika World War Memorial Park","It is located along the General Kago road, on your way to Mount Kenya University. It features burial sites for African soldiers who fought during the Second World War. It is a historical park for commemorating brave soldiers who died during the Second World War. ", R.drawable.thikaworldwarmemorialpark),


                    new MyMovieData("Limuru Viewpoint"," It is located along the Nairobi-Nakuru highway. It is a place you can pass by to have a view of the Great Rift Valley, the western escarpment and sample antiques from curio shops located within the area. ", R.drawable.limuruviewpoint),


                    new MyMovieData("Kilimambogo"," Kilimambogo is a Swahili word-meaning mountain of the buffalo. It is located off the Thika-Garissa Road, approximately 65 kilometres from Nairobi. It features amazing sceneries and sites such as the burial site of Lord Macmillan, a great philanthropist. It is a paradise for bird watching activities and hiking. ", R.drawable.kilimambogo),


                    new MyMovieData("Paradise Lost","It is located in Kiambu town, off the junction of Nairobi-Kiambu Road. It is a magnificent park and resort located in the middle of a coffee farm. The main attractions here include scenic waterfalls and caves. It is a suitable destination for bird watching, nature trails, picnics, fishing, boat riding and horse riding. ", R.drawable.paradiselost),


                    new MyMovieData("Gatamaiyu Camp and Fishing Ground"," It is located in Gatamaiyu forest, which is part of the Kereita forest. It consists of fishing ground, camping site and the Gatamaiyu riverine walk, an ideal destination for urban birding. The Kenya Wildlife Service manages the place. ", R.drawable.gatamaiyucampandfishingground),


                    new MyMovieData("Kereita Forest"," The forest is located in Lari, along the Nairobi-Nakuru highway. It is part of the Aberdare Forest Reserve. It is a serene area ideal for activities such as zip lining, mountain biking, nature walks, camping, paintballing, archery, horse riding and team building. ", R.drawable.kereitaforest),


                    new MyMovieData("Mugumo Gardens"," It is a historical site located along the Mugo-Kibiru Road in Thika. It serves as a historical site in memory of Mugo wa Kibiro. It was named after a giant 15-foot diameter tree where Mugo wa Kibiro used to prophesy. There is a protected area around the tree where visitors pay a small fee to visit. ", R.drawable.mugumogardens),


                    new MyMovieData("Chania Falls"," The falls are located off the Thika superhighway and can best be viewed from Blue Post hotel. The falls are located in Chania River, which draws its water from the Aberdares. The scenic falls offer perfect opportunities for birding activities, retreating, picnicking and photography sessions. ", R.drawable.chaniafalls),


                    new MyMovieData("Fourteen Falls"," Fourteen falls is located in Thika, off the Thika-Garissa road turning at Makutano junction. The spectacular fall is about 27 meters deep. The scenic site offers opportunities for boat rides, fishing, photography and wholesome interaction with nature. ", R.drawable.fourteenfalls),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("22") ){
            setUpToolbar();
            setTitle("Turkana");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("South Island","Covered end to end in volcanic ash,the nightly glow of its South Island’s luminous vents has inspired numerous tales of ghosts and evil spirits.The Island is home to a profusion of birdlife including 34 species of European migrants most spectacularly viewed as they return home between March and May.At least 23 species breed here,including Goliath heron, and African Skimmer,while African open-billed stork,Duck and Gulls feed on the shores and the volcanic island lakes attract lesser flamingos.Birds of prey are also abundant,especially swallow-tailed kites. This park is ideal for game watching and has one of the world’s largest concentrations of crocodiles. ", R.drawable.southisland),


                    new MyMovieData("Nabuyatom Cone","The discernible Nabuyatom, which in Turkana dialect is a “place of the war horn” rises 384m and is often described as a “perfect cinder-volcano”.The geological marvel 72km North of Central-Island park is a remt a collapsed deep volcano discovered by photographer Martin Harvey on an aerial view of the lake.This peculiar extinct crater is among the world’s profound craters best seen from the air. ", R.drawable.nabuyatomcone),

                    new MyMovieData("South Turkana National Reserve","When travelling from Kitale to Lodwar, most people drive past Turkana’s largest nature reserve without even sensing what they are missing. South Turkana National Reserve is probably one of the least visited nature reserves in the whole of Kenya but it is a hidden gem! Chances to meet other tourists there are minimal. So why do not you just fancy to possess your own private national park! You can explore South Turkana by 4WD or on foot. You may see oryx antelopes, gazelles, warthogs, a wonderful birdlife, even lions and leopards and most prominently: elephants! Animals are shyer and harder to trace than in the popular parks of Southern Kenya, but in exchange for that, you don’t have to share them with a pack of minibuses. The true adventure of South Turkana is its scenic beauty of vast plains with anthills of record-breaking height and singular mountains, anyway ", R.drawable.southturkaationalreserve),


                    new MyMovieData("Nariokotome Turkana Boy Monument","Where do we originally come from? Possibly from Nariokotome, near the shores of Lake Turkana! This is at least where the remts of the world famous Turkana Boy where found, a near complete skeleton of an approximately 1.6 million year old Homo erectus. Scientists as one of our direct ancestors generally regard this early human species. A monumental pillar and a brass replica of the Turkana Boy mark the spot where Kamoya Kimeu, a researcher of Dr. Richard Leakey’s scientific team detected the fossil in 1984. Many more important hominid findings have been made in other parts of Turkana County such as the oldest known stone tools with a suspected age of 3.5 million years, which support Turkana’s claim to be the Cradle of Mankind. ", R.drawable.nariokotometurkanaboymonument),


                    new MyMovieData("Lokori Standing Stones and Rock Art","In Lokori, not too far from the banks of Kerio River, there is one of Turkana’s most impressive archeological sites, an ensemble of numerous circles of standing stones and two hills bearing mysterious rock art engravings. The local people will insist that the standing stone slabs once have been dancers turned into rocks by a wizard, similar to the stories you might have heard at the Namorutunga site near Kalokol. Again, archeologists suspect other origins. Whether a graveyard or a site with another purpose – it surely must have been a place of important rituals. When you come to Lokori, catch up with the spirit of the place, imagine being Indiana Jones and try to figure out the meaning of the many enigmatic rock art symbols on the nearby hills. Can you guess their significance? ", R.drawable.lokoristandingstonesandrockart),


                    new MyMovieData("Turkana Tourist and Cultural Festival"," Thousands of people from Turkana, the neighboring countries of Uganda, South Sudan and Ethiopia as well as Nairobi and from overseas flock to the annual Turkana Tourist and Cultural Festival, which is held at Ekaleez Centre on the fringes of Lodwar. The festival program is diverse and comprises of the display of traditional Turkana houses, an exhibition and trade fair for companies and organisations, a market with traditional produce, such as bead works and woven baskets and, most important: a popular stage program. Dance troupes from all over Turkana display their artistry and various famous Kenyan singers boil up the crowd. At night, when the air gets as smooth as silk, the festival grounds turn into a huge nyama choma area, where people sit under the sparkling stars, listening to music, talking, eating, laughing and making new friends until dawn – festival atmosphere at its best! ", R.drawable.turkanatouristandculturalfestival),


                    new MyMovieData("Lobolo Swamp","A unique ensemble of sand dunes, lakescape, doom palm trees and a swampy lagoon characterize the area of Lobolo swamp. Myriads of flamingo, holy ibis and other waterfowl have chosen it as their stomping ground. In case you are a bird watcher or merely a nature lover, you will enjoy staying and unwinding here very much! There is an exclusive tented camp near a natural spring covered by a shady palm groove, right at the shores of beautiful Lake Turkana. Whether you simply want a calm time to unwind or explore the surroundings on foot together with the camp’s naturalist and mingle with the resident flamingos, you will have a rewarding time in Lobolo, just some 20 kilometres north of Eliye Springs. ", R.drawable.loboloswamp),


                    new MyMovieData("The hot waterfalls of Kapedo","On arrival in Kapedo, the border town of Baringo and Turkana County on the road running up from Lake Baringo, visitors probably will rub their eyes in disbelief when they see the major attraction of the region: Two boiling hot waterfalls that plunge over a small escarpment before merging with Suguta River! Kapedo itself is a picturesque village where traditional grass thatched huts prevail. The surrounding has also a lot of charm with Silali volcano to the east and Tiati hills to the west that both are a rewarding hiking terrain. After walking the hills, you can treat your tired legs with a swim in the huge bathing tub of Mother Nature, the warm waters of Suguta River. Whether you prefer it boiling hot or lukewarm, you will find the right water temperature depending on how close you are to the merger of the hot streams with Suguta River! ", R.drawable. hotwaterfallsofkapedo),


                    new MyMovieData("Kalokol Standing Stones ","People do not expect a mythical experience right next to a main road. However, so it may happen at Namorutunga when you drive from Lodwar to Kalokol. A gang of local elders can tell you all about the people of stone, which is the literal translation of the local name of the site. As the tale goes, the basalt pillars once where people dancing whom where cursed and turned into stone by an angry sorcerer. Archeologists are not so sure that this is the true origin of the site but rather suspect that it has been a place of worship since approximately 2,000 years. Whatever the truth might be, it is beyond doubt that Namorutunga has been a spiritual power place for people since a very long time. The local Turkana still pray here, which you can tell by the many pebbles that are placed on the stone pillars. When you pay a visit, talk to the people of stone or simply have a look at the open-air temple, which is presumably two millenia old … ", R.drawable.kalokolstandingstones),


                    new MyMovieData("Ferguson Gulf","Ferguson Gulf is a huge bay full of shallow water, confined towards Lake Turkana by a sandy ridge overgrown by doum palm trees – a terrific landscape! Everybody around seems to be busy fishing, thousands of pelicans, flamingos and yellow billed storks as well as the local fishermen who practise their trade with sailing boats, canoes with outboard engines or traditional rafts which supposedly are the most ancient vessels of human kind. It all explains why the nearby town of Kalokol is the centre of Turkana is fishing industry. At Ferguson Gulf, you can watch the work of the fishermen and accompany them as they go out to the lake, do some bird watching or simply come to marvel at the sunrises and sunsets, which turn the orange waters into fluid fervor. ", R.drawable.fergusongulf ),


                    new MyMovieData("The beaches of Eliye Springs ","Just 50 kilometres east of Lodwar lies Eliye Springs, a small resort that, back in the 1970ies enjoyed astonishing popularity with the international jet set who flew in from Nairobi with private planes to spend a weekend angling on the lake and partying on the beach. Eliye Springs surely is the greatest place to unwind: It has a very laid-back atmosphere, endless palm fringed sand beaches, a massive sand dune from which you enjoy a panoramic view of Lake Turkana, and a lack of mobile network. Therefore, Lodwar people come here on the weekend when they want to be unreachable and enjoy total peace and fun. Close to the name, giving mineral spring there is a comfortable lodge with good food, and further down the beach you will find a number of basic campsites, all being fit to offer you total relaxation to end your Turkana safari with. ‘Kabissa’, by the way means ‘completely’ in Swahili … ", R.drawable. beachesofeliyesprings),


                    new MyMovieData("Central Island National Park ","As its name suggests, Central Island grows out of the water in the middle of Lake Turkana. Being of volcanic origin, the island owns three crater lakes, one being home for tilapia fish, another one for thousands of flamingos and the third one for crocodiles. Central Island is also an important breeding place for crocodiles and a diverse avi fauna, and this is why it is protected as a national park. You can explore the island on foot; it takes only about one hour to climb the highest point from where you enjoy unrivalled vistas over Lake Turkana. If equipped with a tent you may also stay overnight which will give you the chance to watch the changing colors of marvelous sunrises and sunsets, and the glittering of myriads of stars. As you have to share the island only with a few rangers, thousands of birds and an unknown crocodile number, and because the volcanic landscape is so weird, be prepared to have an out-of-this world feeling … The ultimate place for lovers of birds, great landscapes and serenity! ", R.drawable.centralislandnationalpark),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("23") ){
            setUpToolbar();
            setTitle("West Pokot");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Kopoch Hills","The hills also offer perfect opportunities for hiking adventures, bird watching and sightseeing of the beautiful sceneries in West Pokot County. ", R.drawable.kopochhills),


                    new MyMovieData("Tartar Falls Resort","It is an elegant resort located in Kapenguria, just next to the Tartar falls. It offers affordable accommodation, sumptuous meals, and opportunities for nature walks, hiking, and birdwatching adventures. ", R.drawable.tartarfallsresort),


                    new MyMovieData("Marich Pass","It is a beautiful escarpment located approximately 360 kilometers northwest of Nairobi, on the way towards the west of Lake Turkana. However, the place is rarely visited due to security concerns. ", R.drawable.marichpass),


                    new MyMovieData("Tartar Falls","The magnificent waterfall is located in Kapenguria. Scenic rocks and beautiful vegetation that provides a habitat for different species of birds, thus making it a haven for birdwatching adventures, surround it. ", R.drawable.tartarfalls),


                    new MyMovieData("Nasolot Hill"," It is a rocky outcrop at the periphery of the Nasolot Game Reserve. It is an ideal site for rock climbing adventures, bird watching, and sightseeing of the beautiful sceneries of West Pokot County and beyond. ", R.drawable.nasolothill),


                    new MyMovieData("Turkwel Dam","It is an arch dam on River Turkwel that flows from Mount Elgon. It is Kenya’s tallest dam with a height of 153 meters. It supports the Turkwel hydroelectric power plant with an installed electric capacity of 106 megawatts. You can visit the place to have an overview of how hydroelectric power is generated. ", R.drawable.turkweldam),


                    new MyMovieData("Cherangani Hills"," The hills traverse West Pokot, Elgeyo Marakwet and Trans Nzoia counties. The eco-system features beautiful subtropical indigenous forests with diverse wildlife and bird species, magical caves and hiking sites. ", R.drawable.cheranganihills),


                    new MyMovieData("Mount Mtelo","It is situated in the northwest highlands of West Pokot County. It is the fifth highest mountain in Kenya, with an elevation of 3,336 meters. It is ideal for camping, bird watching, and hiking adventures. ", R.drawable.mountmtelo),


                    new MyMovieData("Kapenguria Museum","It was opened in 1993 to preserve the history of the struggle for Kenya’s independence. It is where the six most influential leaders in the struggle for independence were detained. The six leaders were Mzee Jomo Kenyatta, Kungu Karumba, Fred Kubai, Paul Ngei, Bildad Kaggia, and Achieng Oneko. The museum features displays of books and documents in a memorial library in honor of the heroes who fought for the independence of Kenya. ", R.drawable.kapenguriamuseum),


                    new MyMovieData("Nasolot Game Reserve"," It is actually one of the unexploited sites in West Pokot due to its remote location. It is a nice destination for camping, nature walks, fishing, bird watching and game viewing of wildlife such as hyenas, jackals, monkeys, bushbucks, lesser kudu, baboons, gazelles, and waterbucks. ", R.drawable.nasolotgamereserve),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("24") ){
            setUpToolbar();
            setTitle("Samburu");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Kirisia Forest"," It is located in the northern section of Samburu County, within the Leroghi plateau. The forest features diverse species of birds and plants. It is a paradise for bird watching activities and nature trails. ", R.drawable.kirisiaforest),


                    new MyMovieData("Loroghi Hills"," The hills rise up through a series of escarpments to a peak of approximately 2580 metres. You can explore the spectacular hills covered with bushlands, diverse species of birds and wild animals. It is a perfect destination for trekkers and hikers. ", R.drawable.loroghihills),


                    new MyMovieData("Ndoto Mountains"," It is situated on the northern end of Samburu County. It features scenic hills, a stunning panorama of jagged peaks and valleys. It is an ideal destination for hiking, camping and nature trails. ", R.drawable.ndotomountains),


                    new MyMovieData("Maralal National Sanctuary","It is one of Kenya’s little-known treasures located in Maralal, Samburu County. It is an ideal destination for wildlife viewing safaris, trekking safaris and camel safaris. The reserve features animals such as impalas, leopards, hyenas, giraffes, buffaloes, eland and warthogs. There is also a lodge and a campsite located within the reserve. ", R.drawable.maralalnationalsanctuary),


                    new MyMovieData("Sera Rhino Sanctuary","It is located within the Sera Community Conservancy in Samburu. It is the first sanctuary in East Africa to pioneer rhino tracking safaris to tourists. The sanctuary also offers amazing walking safaris, birdwatching and cultural experiences in Samburu County. ", R.drawable.serarhinosanctuary),


                    new MyMovieData("Reteti Elephant Sanctuary","The Namunyak community in Samburu County owns the elephant sanctuary. It was established to rescue and release orphaned and abandoned elephant calves, and to create benefits for the host communities. The Samburu County Governor, Moses Lenolkulal, officially opened the sanctuary on 20 August 2016. ", R.drawable.retetielephantsanctuary),


                    new MyMovieData("Kalama Conservancy","It is one of the 35 member conservancies under the Northern Rangelands Trust. The conservancy is home to elephants, Grevy’s zebras, reticulated giraffes, cheetahs, leopards, lesser kudu and wild dogs. The conservancy was mainly established to conserve wildlife and improve services for community development. ", R.drawable.kalamaconservancy),


                    new MyMovieData("Shaba National Game Reserve","It is a protected game reserve that features beautiful sceneries such as riverside forests, scattered woodlands and grasslands, waterholes, marshes, game species such as Masai giraffes, zebras, impalas, gazelles, lions, Somali ostrich, leopards, elephants and hyenas. ", R.drawable.shabanationalgamereserve),

                    new MyMovieData("Samburu National Reserve"," The reserve covers approximately 165 square kilometres. It is bordered to the south by Ewaso Nyiro River. It features wildlife such as the grevy’s zebra, Somali ostrich, giraffes, elephants, lions, leopards, cheetahs, gerenuk and the beisa oryx. The reserve provides a tranquil environment for game viewing, nature walks, bird watching and camping activities. ", R.drawable.samburunationalreserve),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("25") ){
            setUpToolbar();
            setTitle("Trans Nzoia");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Ngwarisha Cave"," The cave is about 150 meters long. It is home to about 100, 000 bats. A scenic waterfall is located at the entrance of the cave that is also frequented by elephants. ", R.drawable.ngwarishacave),


                    new MyMovieData("Kapolet Forest"," The forest is located north of Cherangani. It is a thick tropical forest with an elevation of 2068 meters. It is an ideal destination for birdwatching adventures and nature walks. ", R.drawable.kapoletforest),


                    new MyMovieData("Making’eny Cave"," It is also located within Mount Elgon National Park, about 1.5 kilometres from Kitum Cave. A scenic cave features a spectacular waterfall over its mouth. ", R.drawable.makingenycave),


                    new MyMovieData("Kitum Cave"," The cave is located within Mount Elgon National Park. Elephants, bushbucks and buffalos, in search of salts that are found in the mineral-rich earth of the caves, regularly visit it. ", R.drawable.kitumcave),


                    new MyMovieData("Cherangani Hills"," The hills traverse Trans Nzoia, West Pokot and Elgeyo Marakwet counties. The spectacular hills feature beautiful subtropical indigenous forests with diverse wildlife and bird species. Caves and hiking sites are located within the hills. ", R.drawable.cheranganihills),


                    new MyMovieData("Mount Elgon National Park","It covers an area of 169 square kilometres. The park is endowed with natural attractions such as beautiful caves, cliffs, gorges, nature trails, waterfalls and indigenous forests. It is home to diverse species of birds and wild animals such as elephants, buffalos, leopards, monkeys, hogs, waterbucks, antelopes, baboons and impalas. It is a perfect destination for camping, game viewing, hiking, birdwatching and mountain climbing. ", R.drawable.mountelgonnationalpark),


                    new MyMovieData("Treasures of Africa Museum"," John Galletly Wilson, a former colonial officer, founded it. It is a historical museum where you can visit to learn the rich African culture and view African cultural artefacts and utilities. The museum is always open from Monday to Saturday, 9:00 a.m to 5:00 p.m. Entry fee is Kshs 500 ", R.drawable.treasuresofafricamuseum),

                    new MyMovieData("Kitale Nature Conservancy","It is situated on Kitale-Lodwar Road. It was established to revive and restore the original habitat and conserve the remaining indigenous plants and animals in Trans Nzoia. Main attractions at the conservancy include a variety of wild animals, a campsite, Snake Park, cottages and biblical mountains. It is a beautiful place for nature walks, camping, game viewing and team building adventures. ", R.drawable.kitalenatureconservancy),


                    new MyMovieData("Kitale Museum","It is located within Kitale town, approximately 1 kilometre from Kitale town CBD. It was the first of the inland museums to be developed in Kenya. It features collections of ethnographical materials from local communities, collections of insects and different types of snakes. A nature trail is also located within the museum. ", R.drawable.kitalemuseum),


                    new MyMovieData("Saiwa Swamp National Park","It is located approximately 22 kilometres from Kitale town. It is a haven for nature lovers filled with exotic flowers, trees, birds and wild animals such as snakes, monkeys and the endangered sitatunga antelope. It is a haven for bird watching, camping and game viewing adventures. ", R.drawable.saiwaswampnationalpark),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("26") ){
            setUpToolbar();
            setTitle("Uasin Gishu");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Two River Dam"," It is located along Eldoret-Naiberi-Kaptagat Road. The picturesque dam is a major attraction for nature lovers. ", R.drawable.tworiverdam),


                    new MyMovieData("The Noble Hotel"," It offers exquisite accommodation in executive suites, deluxe rooms, and standard rooms. It also boasts of state of the art meeting/conference facilities, a swimming pool, gym and massage parlor, an onsite restaurant and beautiful gardens ideal for holding events such as weddings, birthday parties, and team building activities. ", R.drawable.noblehotel),


                    new MyMovieData("Boma Inn"," It is situated off Elgon View drive-in Eldoret town. It offers luxury accommodation in guest rooms categorized as; superior rooms, deluxe rooms, and governor suites. It also features modern conference facilities, classic restaurants, and well-manicured gardens ideal for holding outdoor events, terraces and open sky lounges. ", R.drawable.bomainn),


                    new MyMovieData("Sirikwa Hotel"," It is located in the heart of Eldoret town. It offers luxury accommodation in spacious and well-furnished rooms to ensure guests have a tranquil stay. It prides in modern conference facilities, a state of the art swimming pool, an onsite restaurant and well-manicured gardens ideal for holding weddings and team building activities. ", R.drawable.sirikwahotel),


                    new MyMovieData("Kesses Dam"," It is a natural dam located in Kesses. It offers unique opportunities for fishing expeditions and recreational activities such as boat riding and swimming. ", R.drawable.kessesdam),


                    new MyMovieData("Naiberi River Campsite"," It is located off the Eldoret-Kaptagat-Eldama Ravine road. It prides in serene camping grounds in a forested environment that is a haven for over 200 species of birds. Other facilities here include; a state of the art swimming pool, an iconic stone cave restaurant, nature trails, and modern conference facilities. ", R.drawable.naiberirivercampsite),


                    new MyMovieData("Poa Place Resort"," It is an elegant resort located in Eldoret town. It offers unique and inviting accommodation in safari cottages, deluxe cottages, family suites, and VIP suites. It also prides in a wedding and events garden, a nature park and cultural center, amusement park and modern restaurants that serve both local and international cuisine. ", R.drawable.poaplaceresort),


                    new MyMovieData("Greenwoods Campsite and Resort"," It sits in a serene environment within a traditional African village surrounded by natural woodland that is a haven for different species of birds. It offers luxury accommodation in cottages. It also boasts of state of the art conference facilities, beautiful grounds that offer amazing opportunities for camping, and a resort that offers facilities for self-catering. ", R.drawable.greenwoodscampsiteandresort),


                    new MyMovieData("Koromosho Falls"," It is a breathtaking waterfall located on River Sosiani, about 20 kilometers west of Eldoret town. It pours down a 70 meters cliff that separates a flat land from a rocky escarpment. It is one of the best places to visit for sightseeing adventures. ", R.drawable.koromoshofalls),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("27") ){
            setUpToolbar();
            setTitle("Elgeyo-Marakwet");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Kureswo Hot Spring"," The hot spring is located in Keiyo South. The hot water stems out of hills and flows down into Kerio River. Beautiful sceneries such as hills, caves and a rock that changes colour are also located around the area. ", R.drawable.kureswohotspring),


                    new MyMovieData("Cherangani Hills"," The hills traverse three counties; West Pokot, Elgeyo Marakwet and Trans Nzoia. The ecosystem features beautiful subtropical indigenous forests with diverse wildlife and bird species. Several caves and hiking sites are located within the hills. ", R.drawable.cheranganihills),


                    new MyMovieData("Kerio Valley"," It sits at an elevation of 1,000 meters in the Great Rift Valley. It strategically lies between Tugen Hills and the Elgeyo Escarpment. It features archaeological activities and sites such as the elaborate irrigation systems that were constructed during early periods of history. ", R.drawable.keriovalley),


                    new MyMovieData("Elgeyo Escarpment"," The spectacular escarpment is part of the western wall of the Rift Valley. The escarpment can best be viewed from the Kolol viewpoint or while paragliding. The escarpment rises more than 1, 830 metres above the Kerio Valley. ", R.drawable.elgeyoescarpment),


                    new MyMovieData("Kipteber Mountain"," The mountain strategically sits on the border of Elgeyo Marakwet and West Pokot counties. You can explore the mountain that features bushlands and wildlife such as snakes, monkeys a diverse species of birds. It is a perfect hiking destination. ", R.drawable.kiptebermountain),


                    new MyMovieData("Kapkurmoi Conservancy"," The local communities in Elgeyo Marakwet County established the conservancy in 2008. It is home to wildlife such as elephants, dik-dik, pangolin, snakes and different species of birds. ", R.drawable.kapkurmoiconservancy),


                    new MyMovieData("Torok Waterfall"," The impressive waterfall is located near Iten town. The waterfall is about 200 metres high. You can have a glimpse of the magnificent waterfall from the Kolol viewpoint. ", R.drawable.torokwaterfall),


                    new MyMovieData("Tambach Museum"," The museum is located in Tambach town, about 42 kilometres from Eldoret town. It was established to safeguard the Tambach heritage site and the culture of the Keiyo and Marakwet people. It features an exhibition space for ethnographic and archaeological collections of Elgeyo Marakwet County. ", R.drawable.tambachmuseum),


                    new MyMovieData("Rimoi National Reserve"," It is an animal conservation reserve located approximately 30 kilometres from Iten town, along the Kabarnet- Eldoret road. The main attractions at the reserve include elephants, beautiful sceneries of Kerio Valley, impalas, monkeys, dik-dik, leopards, over 100 bird species, zebras and snakes. ", R.drawable.rimoinationalreserve),


                    new MyMovieData("Kerio Valley National Reserve"," The reserve was established in 1983 and is managed by the Kenya Wildlife Service. The reserve features beautiful sceneries, diverse species of birds and wildlife such as leopards, elephants, buffalos, yellow baboons, bushbucks, waterbucks and warthogs. It is open daily from 7.00 a.m to 5.00 p.m. ", R.drawable.keriovalleynationalreserve),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("28") ){
            setUpToolbar();
            setTitle("Nandi");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Tea Plantations"," You can visit the numerous tea plantations and factories in di County, have a glimpse of how tea is planted, harvested and processed. Some of the notable tea factories in di include Kipchabo Tea Factory and Kaptumo Tea Factory ", R.drawable.teaplantations),


                    new MyMovieData("Ndalat Hill"," The hill is about 2196 meters high. Indigenous trees and vegetation surround the spectacular hill, which attracts different species of birds. It is a perfect hiking and bird watching destination in di County. ", R.drawable.ndalathill),


                    new MyMovieData("Sheu Morobi"," It is a high steep overhanging cliff located on the di Escarpment. It was once a suicide zone where old men and women used to commit suicide to relieve their families from the burden of taking care of them. The cliff is over 400 meters high. ", R.drawable.sheumorobi),


                    new MyMovieData("Mberere Shrine"," It is located about 2 kilometers from the Chemelil-di Hills road. It is a holy shrine where members of the Legio Maria sect worship and pray. Members of the sect believe that water from the nearby Mberere stream has supernatural healing and cleansing powers. ", R.drawable.mberereshrine),


                    new MyMovieData("Keben Salt Lick"," It is situated in Mogobich area, near Lessos. It is a natural formation of spring with alkaline water, which stems out of the rocky ground. The salt lick is surrounded by indigenous forests and scenic caves, which you can explore. ", R.drawable.kebensaltlick),


                    new MyMovieData("Chepkiit Waterfall"," The spectacular waterfall is located in a serene environment surrounded by cliffs, hanging rocks and indigenous trees that provide beautiful picnic sites. It is also a haven for over 100 bird species, thus making it a favourite place for bird watching adventures. ", R.drawable.chepkiitwaterfall),


                    new MyMovieData("Kingwal Swamp"," The swamp is situated between Kosirai and Chepteret, off the Eldoret-Kapsabet highway. It is home to over 100 species of bird and the rare sitatunga antelopes. It is actually one of the destinations in Kenya with the largest population of the Sitatunga antelope. You can visit the swamp to have a glimpse of the rare antelopes and for bird watching adventures. ", R.drawable.kingwalswamp),





                    new MyMovieData("Bonjoge National Reserve"," The reserve has rich biodiversity that consists of several rocks, rivers, riverine woodlands, diverse birdlife and different wild animals such as baboons, colobus monkeys, vervet monkeys, jackals, bush duikers, de-brazza’monkeys, bush pigs and the genet cat. ", R.drawable.bonjogenationalreserve),


                    new MyMovieData("Koitalel Arap Samoei Museum"," The museum was established to commemorate and honour Koitalel Arap Samoei, an influential di leader who led the di resistance against the British colonial rule. The museum houses the remains, artefacts of Koitalel Arap Samoei and other materials that depict the culture of the Kalenjin community. ", R.drawable.koitalelarapsamoeimuseum),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("29") ){
            setUpToolbar();
            setTitle("Baringo");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Dr.Richard Leakey’s Snake Park"," It is situated on the shores of Lake Baringo. It is a viewing park for different species of snakes found in Baringo County. ", R.drawable.drrichardleakeyssnakepark),


                    new MyMovieData("Kaptuya Conservancy","The Conservancy is also a project of both the local communities in Baringo and the Kenya Wildlife Service. Elephants are the main wild species at the conservancy. ", R.drawable.kaptuyaconservancy),


                    new MyMovieData("Ruko Conservancy"," It is located on the shores of Lake Baringo. It was founded by the local communities in Baringo County but is managed by the KWS. Giraffes, kudus, baboons, hippos, impalas, and different species of birds can be found at the conservancy. It is suitable for bird watching, game-viewing activities and nature walks. ", R.drawable.rukoconservancy),


                    new MyMovieData("Kerubo Swamp","The swamp is located at the northern end of Lake Bogoria. It is mainly known for its birdlife, thus making it the best place in Baringo County for bird watching activities. Over 200 species of birds can be found at the swamp. ", R.drawable.keruboswamp),


                    new MyMovieData("Lake Kamnarok Game Reserve","Lake Kamnarok is an oxbow lake with the second largest population of crocodiles in Africa, after Lake Chad. The Lake is found within the Lake Kamnarok Game Reserve. The reserve is also home to giraffes, elephants, buffaloes, waterbucks, warthogs, dik-dik and various water birds. The reserve is located in Kerio Valley, next to Lake Bogoria. ", R.drawable.lakekamnarokgamereserve),


                    new MyMovieData("Lake Bogoria","The Lake is within the Lake Bogoria National Reserve. It is commonly referred to as the ‘pink lake’, due to a large number of flamingoes it attracts. The main attractions at the lake are the hot geysers and springs, where you can boil eggs and even roast maize. ", R.drawable.lakebogoria),


                    new MyMovieData("Lake Baringo Reptile Park","The park was officially opened in 2003. It is home to different species of reptiles such as snakes, monitor lizards, crocodiles, turtles and tortoises. It is actually a perfect park for viewing different kinds of reptiles found in Kenya. ", R.drawable.lakebaringoreptilepark),


                    new MyMovieData("Kabarnet Museum","The museum was officially opened in 1996. It is located in Kabarnet town. It features four main public galleries that display the cultural artefacts and exhibits of the Rift Valley people, in particular, the Keiyo/Marakwet, Samburu, Pokot, di and Kipsigis ", R.drawable.kabarnetmuseum),


                    new MyMovieData("Lake Baringo","It is one of the two freshwater lakes found in the Great Rift Valley. It boasts of over 100 species of birds, thus making it a perfect haven for bird lovers. The Lake is also home to hippos, crocodiles, different species of bats and amphibians. One can also visit the islands found in Lake Baringo, the notable one being Ol Kokwe Island. Other activities to engage in at the Lake include fishing, boat riding and water sports such as windsurfing. ", R.drawable.lakebaringo),


                    new MyMovieData("Lake Bogoria National Reserve","The reserve covers an area of 107 square kilometres, with 34 square kilometres covered by water. It is home to a variety of wild animals like the greater kudu, impalas, gazelles, the Burchell’s zebra, warthogs, hyenas, and dik-dik and vervet monkeys. Flamingoes, different bird species and hot springs can be found at the reserve. The reserve offers an enabling environment for camping, bird watching activities, game watching, nature walking and boat riding. ", R.drawable.lakebogorianationalreserve),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("30") ){
            setUpToolbar();
            setTitle("Laikipia");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Curio Shops","There are very many curio shops in yuki town. The shops contain a diverse collection of woodcarvings, stone sculptures and artifacts of different shapes and sizes. ", R.drawable.curioshops),


                    new MyMovieData("Ol Ari Nyiro Conservancy"," It is a private conservancy under the umbrella of the Gallmann foundation. It is home to over 400 species of birds, animals such as elephants, lions, rhinos, leopards, antelopes, zebras, cheetahs and giraffes. It is one of the best places in Laikipia for game viewing activities, bird watching, camping and nature walk. ", R.drawable.olarinyiroconservancy),


                    new MyMovieData("Mount Kenya Wildlife Conservancy","It was established to prevent extinction by breeding rare and endangered species for rehabilitation to their ancestral wilderness homes. It is one of the few animal orphanages to have successfully bred the rare mountain bongo antelopes. There are many endangered species and wild animals such as the colorful colobus monkeys, zebras, giraffes, cheetah and leopards that you can view at the conservancy. ", R.drawable.mountkenyawildlifeconservancy),


                    new MyMovieData("Sosian Conservancy"," The conservancy has exceptional scope for viewing wildlife in its natural habitat. It is a haven for over 350 species of birds, the endemic Jackson’s hartebeest, Grevy’s zebra, reticulated giraffe, gazelles, cheetah, oryx, lions and leopards. The conservancy also features a beef cattle ranch and a safari lodge that offers luxury accommodation. ", R.drawable.sosianconservancy),


                    new MyMovieData("Ol Lentille Conservancy","It is one of Kenya’s most spectacular and breathtaking location located in the Laikipia region. The private conservancy is home to the endangered African wild dog, elephants, Grevy’s and Burchell’s zebra, greater kudu, leopards, cheetah, striped and spotted hyenas. It offers more than just game viewing and exclusive accommodation. It is also a paradise for bird watching, quad biking, camel safaris, horse riding and sundowners. ", R.drawable.ollentilleconservancy),


                    new MyMovieData("Mugie Conservancy"," It is a private wildlife conservancy located in Laikipia. It is a home to over 100 bird species, animals such as buffalos, elephants, Grevy’s zebra, reticulated giraffe, Jackson’s hartebeest and storks. It also offers exquisite accommodation in tented camps. It is a nice place for game viewing activities, bird watching, camping and bush walks. ", R.drawable.mugieconservancy),


                    new MyMovieData("Loisaba Conservancy","It is a 57,000-acre wildlife conservancy, established to protect and enhance critical wildlife diversity and habitat. It is a haven for over 200 species of birds, elephants, buffalos, Grevy’s zebra, giraffes, lions, leopards and cheetahs. It is a perfect destination for game drives, bush walks, horse riding, camel riding, mountain biking and bird watching. ", R.drawable.loisabaconservancy),


                    new MyMovieData("Thomson’s Falls","It is a scenic 74 meters waterfall situated about 3 kilometers from Nyahururu town. Upstream from the falls is one of the highest hippo pools in Kenya. You can visit Nyahururu town to have a glimpse of the spectacular waterfall, which plunges down several meters into a fearful gorge. ", R.drawable.thomsonsfalls),


                    new MyMovieData("Ol Jogi Wildlife Conservancy","It is Kenya’s second largest rhino sanctuary. It is also home to endangered wild species such as the reticulated giraffe, Grevy’s zebra, elephants, lions, African wild dog, cheetah, greater kudu and Laikipia hartebeest. The Conservancy also operates as a working cattle ranch and features a state of the art veterinary clinic that serves the whole of Laikipia region. ", R.drawable.oljogiwildlifeconservancy),


            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("31") ){
            setUpToolbar();
            setTitle("Nakuru");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Lake Naivasha"," It is a fresh water lake found in the Great Rift Valley. It features serene surroundings and beautiful sceneries perfect for bird watching and picnic activities. Hippopotamuses can also be spotted on the shores of the lake. ", R.drawable.lakenaivasha),


                    new MyMovieData("Lake Elementaita","It is a small soda lake located near Gilgil town. Zebras, antelopes, gazelles, impalas and a variety of reptiles graze its beautiful shores. Flamingos can also be found at the Lake, though not a good number like in Lake Nakuru. The Lake provides beautiful sceneries for bird watching, family walks, game viewing and camping. ", R.drawable.lakelementaita),


                    new MyMovieData("Crescent Island Game Conservancy","It is a game conservancy located in Lake Naivasha. It is home to abundant wildlife such as zebras, giraffes, hippopotamus, vervet monkeys, antelopes, gazelles, different species of birds, snakes and wildebeests, impalas and elands. It is also a perfect camping and picnic site. ", R.drawable.crescentislandgameconservancy),


                    new MyMovieData("Kariandusi Pre-historic Site","The site is situated on the Nakuru-Elementaita basin, about 2 kilometres to the east side of Lake Elementaita. Attractions within the site include; a campsite, nature trail, archaeological site, picnic site, bird watching, museum exhibition hall, the gorge and a monumental church building. ", R.drawable.kariandusiprehistoricsite),


                    new MyMovieData("Kigio Wildlife Conservancy","It is a community-owned wildlife conservancy located in Gilgil. It was establshed in 1997 and covers an area of 3,500 acres. The conservancy features over 100 indigenous plant species, different bird species, animals such as the African buffalo, common eland, waterbuck, gazelles, zebras, hyenas, leopards, hippopotamus, caracal, honey badger and the spring hare. It is a perfect place for game viewing activities. ", R.drawable.kigiowildlifeconservancy),


                    new MyMovieData("Hyrax Hill Pre-historic site and Museum"," The site is located approximately four kilometres from Nakuru town, off the Nakuru-Nairobi highway. The site depicts the lifestyle of seasonal settlement by prehistoric people, about 3,000 years old. It is also a renowned archaeological research area and a reference point for the prehistory of East Africa. Major attractions within the prehistoric site include; an excavation site, a tortoise pit, picnic site, camping site, nature trail and viewpoints of Lake Nakuru. ", R.drawable.hyraxhillprehistoricsiteandmuseum),


                    new MyMovieData("Menengai Crater","It is situated 10 kilometres north of Nakuru, off the Nyahururu- Nakuru main road. It is the second largest volcanic crater in the world, standing at about 2,490 metres high. It features beautiful caves, camping sites, nature trails, picnic spots and beautiful viewpoints. Activities to engage in at the crater include; hiking, camping, trekking, biking photography and picnicking. ", R.drawable.menengaicrater),


                    new MyMovieData("Mount Longonot National Park","It is located approximately 90 kilometres from Nairobi, just close to Hell’s Gate National Park. Unique attractions at the park include the crater forest and the extinct volcano of Mount Longonot. Other major attractions include wildlife such as; buffaloes, zebras, lions, giraffes, gazelles, elands and different species of birds. One can engage in rock climbing activities, biking, camping and hiking at the park. ", R.drawable.mountlongonotnationalpark),


                    new MyMovieData("Hell’s Gate National Park","The park is located in Naivasha. It features beautiful sceneries of towering cliffs, stark rock towers, water-gouged gorges, scrub-clad volcanoes, hot springs, belching plumes of geothermal steam, wildlife such as zebras, gazelles, buffalos, cheetahs, leopards and lions. Major activities one can engage in at the park include; camping, bird watching, biking, game viewing, hiking, horse riding and rock climbing. ", R.drawable.hellsgatenationalpark),


                    new MyMovieData("Lake Nakuru National Park"," The park is located approximately four kilometres from Nakuru town centre. The park features about 550 different plant species, picturesque landscape, and a variety of wildlife species, hills and waterfalls. It is one of the best parks for camping and game viewing and hiking activities. ", R.drawable.lakenakurunationalpark),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("32") ){
            setUpToolbar();
            setTitle("Narok");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Elewana Sand River"," It is located within the Maasai Mara National Reserve. It is an ideal destination for exceptional game-viewing and camping activities. The facility offers luxury tented accommodation and exquisite dining. ", R.drawable.elewanasandriver),


                    new MyMovieData("Mara Savannah Maasai Market"," The market gives you an opportunity to buy and view different Maasai African art, handcrafted beaded jewellery, souvenirs, gifts and decorating materials. ", R.drawable.marasavannahmaasaimarket),



                    new MyMovieData("Loita Hills"," The spectacular hills feature pockets of remote forests, open plains and diverse species of birds. It is a suitable destination for hiking and bird watching activities. ", R.drawable.loitahills),


                    new MyMovieData("Enonkishu Conservancy"," It is situated on the northernmost point of the greater Mara eco-system. It offers an incredible game viewing experience. It features wildlife such as elephants, lions, leopards, colobus monkeys, cheetahs, hippos and crocodiles found in Mara River, which passes through the conservancy. ", R.drawable.enonkishuconservancy),


                    new MyMovieData("Mount Suswa Conservancy"," It was mainly established to halt the massive degradation of the Mount Suswa eco-system and to promote sustainable use of its resources. The conservancy features wildlife such as lions, baboons, leopards, hyenas, wild dogs, and civet cats. It is a perfect destination for cave exploration, game viewing, hiking, camping and nature trails. ", R.drawable.mountsuswaconservancy),


                    new MyMovieData("Ol Kinyei Conservancy","The conservancy lies on a stretch of leased land belonging to the Maasai community, covering about 18, 700 acres. It is home to two safari camps, Porini Mara Camp and Porini Cheetah Camp, which can both accommodate a maximum of 12 guests. The conservancy is renowned for breathtaking sceneries such as springs, rolling hills, open savannah plains and a wide variety of animal species. Activities one can engage in at the conservancy include game viewing, camping, birdwatching, and nature walks. ", R.drawable.olkinyeiconservancy),


                    new MyMovieData("Olare Orok Conservancy"," The conservancy covers an area of 33, 000 acres and directly adjoins the Maasai Mara National Reserve to the south. It features an impressive gorge (Ntiakitiak), extensive areas of acacia woodlands, a number of bird and wildlife species such as elephants, giraffes, antelopes, zebras, leopards, gazelles, cheetahs, and lions. ", R.drawable.olareorokconservancy),


                    new MyMovieData("Mara Naboisho Conservancy"," It is a private conservancy located adjacent to the Maasai Mara National Reserve. It features a high concentration of wildlife such as elephants, giraffes, wildebeest, leopards, lions, aardvark, caracal, cheetahs and diverse species of birds. Numerous campsites and lodges are located within the 50,000-acre conservancy. ", R.drawable.maranaboishoconservancy),


                    new MyMovieData("Narok Museum"," The museum is located in Narok Town. It features gallery exhibitions of pictures, artefacts, and paintings that depict the traditional lifestyle and culture of the Maasai and other speakers of the Maa language. ", R.drawable.narokmuseum),


                    new MyMovieData("Maasai Mara National Reserve"," It is one of Africa’s most diverse and top safari game viewing eco-system. The reserve is famous for the wildebeest migration from the Serengeti National Park in Tanzania. The reserve is home to the big five; lions, leopards, buffalos, elephants and the black rhinos. It also features cheetahs, hyenas, antelopes, zebras, cats and different species of birds. Stunning rivers and plains are also located within the reserve. It is a perfect destination for game viewing, camping, night game drives, ballooning and bush dinners. ", R.drawable.maasaimaranationalreserve),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("33") ){
            setUpToolbar();
            setTitle("Kajiado");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{

                    new MyMovieData("Ole Polos"," It is a hidden gem located in Kajiado County, renowned for its Nyama Choma delicacy. You can visit the place to enjoy some nyamachoma, have a glimpse of the Maasai culture and the beautiful sceneries of Ngong ranges. It is located about 10 kilometres from Kiserian town. ", R.drawable.olepolos),


                    new MyMovieData("Maasai Ostrich Farm"," The farm is located on the outskirts of Kitengela town. It is a perfect place to get up close with ostriches and learn various facts concerning the life cycle of ostriches. You can also enjoy ostrich rides at the farm. ", R.drawable.maasaiostrichfarm),


                    new MyMovieData("Ol Doinyo Orok Mountain"," It is situated approximately 170 kilometres south of Nairobi, at the border town of Namanga. Its elevation is 2,548 meters above sea level. It contains a variety of plants, herbs and animal species. It is a perfect destination for hiking activities, nature walks, bird watching and game viewing. ", R.drawable.oldoinyoorokmountain),


                    new MyMovieData("Nyiri Desert"," It is also called the Nyika/Taru desert. It is located east of Lake Magadi. The desert features thorny trees and bushes, which provide shelter to wildlife such as elephants, rhinos, leopards, lions and impalas. You can visit the desert and have a glimpse of diverse wildlife in Kajiado County. ", R.drawable.nyiridesert),


                    new MyMovieData("Shompole Conservancy"," It is a private conservation area located between two alkaline lakes, Lake Magadi to the north and Lake Natron to the south. The Conservancy features diverse birdlife and wildlife such as giraffes, buffalos, elephants, desert antelopes such as gerenuk and oryx. ", R.drawable.shompoleconservancy),


                    new MyMovieData("Lake Magadi"," It is a saline lake with a surface area of 100 square kilometres. It is a serene and amazing destination for bird lovers, nature lovers and camping activities. The lake is endowed with a variety of wading birds such as flamingos and pelicans. Wildlife such as antelopes, giraffes, ostriches, zebras, wildebeests and hyenas can also be spotted around the lake. ", R.drawable.lakemagadi),


                    new MyMovieData("Selenkay Conservancy"," It is one of the pioneers of community conservation in Kenya. It was established on about 15, 000 acres of land leased from the local Maasai community. It was established to protect the wildlife habitat and encourage wildlife conservation as an alternative to farming for the local community. Animals located within the conservancy include elephants, lions, cheetahs, leopards, giraffes, gazelles, bat-eared fox, porcupine and the yellow baboons. ", R.drawable.selenkayconservancy),


                    new MyMovieData("Ngong Hills"," It is located about 25 kilometres from Nairobi, at the northern tip of Kajiado County. Points of interest include hiking sites, camping and picnic sites, nature trails, 30 wind energy power generation sites and religious retreat sites. An amazing walking trail within the hills offers a great walking safari. ", R.drawable.ngonghills),


                    new MyMovieData("Olorgesailie"," It is a pre-historic site located along Magadi road, about 70 kilometres from Nairobi. The site features an accumulation of stone tools used by early men. Campsites are available within the site. It is also a bird-watchers paradise, with the highest number of migratory bird species in Kenya. ", R.drawable.olorgesailie),


                    new MyMovieData("Amboseli National Park","It is one of Kenya’s most popular parks and the best place to view large herds of elephants up close. The park size is 390.26 square kilometres. Key features include wildlife such as leopards, wild dogs, cheetahs, elephants, buffalos, giraffes, zebras, lions, crocodiles, dik-dik, nocturnal porcupine, and lesser kudu and over 100 bird species. ", R.drawable.amboselinationalpark),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("34") ){
            setUpToolbar();
            setTitle("Kericho");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Uhuru Gardens"," It is a public park located in Kericho town. It is a beautiful garden where you can relax and enjoy the cool breeze and atmosphere of Kericho County. It is also ideal for picnics and team building activities. ", R.drawable.uhurugardens),


                    new MyMovieData("Kimugu River Lodge"," It is aesthetically created with Kipsigis culture in a rural environment that borders the beautiful Kimugu River. It is a nice place to relax, engage in fun-filled activities, to learn the Kipsigis culture and to enjoy the magnificent views of Kimugu River. ", R.drawable.kimuguriverlodge),


                    new MyMovieData("Tea Plantations and Tea Factories"," You can visit the beautiful tea plantations in Kericho County and have a glimpse of how tea is planted and harvested. You can also visit the numerous tea factories such as Kabianga factory, Mau tea factory and Ketepa tea factory to have an idea of how tea is processed. ", R.drawable.teaplantationsandteafactories),


                    new MyMovieData("Mau Forest"," It is the largest indigenous montane forest in East Africa. Several rivers such as Sondu River, Njoro River, Mara River and Ewaso Ng’iro originate from the forest. The forest is home to a variety of birds and wild animals. It is an ideal destination for bird watching and nature walk adventures. ", R.drawable.mauforest),


                    new MyMovieData("Kapkatet Museum"," The museum was established in 2008 to appreciate and preserve the rich culture of the Kipsigis people. It is located in Kapkatet town. It features galleries and exhibitions of artefacts and other traditional merchandise used by the Kipsigis during the early years. ", R.drawable.kapkatetmuseum),


                    new MyMovieData("Chagaik Arboretum"," It is formed by lush green grass and indigenous trees surrounded by tea plantations. Its beautiful and serene environment is ideal for picnics, sightseeing and birding activities. ", R.drawable.chagaikarboretum),


                    new MyMovieData("Tulwap Kipsigis"," It is a cultural site located along the Kipkelion- Londiani junction. It is an important monument in the history of the Kipsigis, a sub-tribe of the Kalenjin ethnic group. It is an important site where the Kipsigis rekindle and revisit their ancient cultural practices of circumcision and worship to God. ", R.drawable.tulwapkipsigis),


                    new MyMovieData("Fort Ternan Museum"," It is an archaeological and prehistoric site located about 3 kilometres from the Londiani-Muhoroni road. Dr. Louis Leakey discovered fossils of the ancient man Kenyapithecus at the site in 1962. It also features exhibitions of early stone tools and artefacts used by the early man. ", R.drawable.forttermuseum),


                    new MyMovieData("Tagabi Monkey Sanctuary"," It is home to the most welcoming primates in Kenya. It is home to vervet monkeys, which can be spotted roaming freely within the sanctuary. A nature trail is also located within the sanctuary. ", R.drawable.tagabimonkeysanctuary),


                    new MyMovieData("Chebulu Conservancy"," It is located in Sigowet. It consists of Chebulu forest, a rainforest that covers about 21 kilometres. The conservancy was set aside as community property and water tower for Chebulu River. Notable attractions at the conservancy include; monkeys, baboons, different species of birds, a campsite and rocks suitable for hiking activities. ", R.drawable.chebuluconservancy),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("35") ){
            setUpToolbar();
            setTitle("Bomet");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("The Kipsegon Ecosytems"," Today more than ever-ecological parks and protected rare habitats are making big headlines, as more folk seek better sustainable approaches to manage our environments. This 27-acre community protected eco system is a biosphere of amusing variety and a walk here is akin to walking in an unspoiled virgin 'eden.' Its flora diversity comes to life as native guide explain the medical or ecological function almost every plant. Then there are the countless bird species, the cool rural air, streams, bogs, and woodlands ", R.drawable.kipsegonecosytems),


                    new MyMovieData("The Hotel","Located within 15 minutes drive of Bomet the 8 room, three-star hotel is a scenic restful take it easy spot for Bomet's visitors. It's design inspired by the 'fresh wave' of SAfrican design that folds into its landscape within its lovely gardens and superb and stunning hills of Bomet. Experience: Barbecue and children's playground, the manicured lawns & lounge, found off Bomet-Narok Rd. ", R.drawable.hotel),


                    new MyMovieData("Motigo Hills","Perfect venue for morning prayers and tourism There are few things more satisfying than finding a superb view, staring at it and being in awe of new beauty. At Motigo Hills tucked away in the heart of Merigi Village merits an adventure to this wildly captivating hillside. The summit provides a viewing spot, from there, a panoramic vista is composed of the Mau Forest Complex, beautiful Farmlands, and hillocks will make any caller cook-a-hoop they made it here, nearby the Motigo Secondary School. Tourists flock the area mostly to experience the sunrise and the sunset atop the hill. In the morning, the site creates a perfect lull for those saying prayers. Although the name of the hill does not have any meaning in the local dialect, it is traced to an old man who once visited the place and fell in love with the landscape. This village get-away has continually lured nature lovers. From here, one can also see the great Mau Forest as well as the great landscape of locals farming. It is arguably the main tourist attraction in this remote area and its elegance, majestic splendour has continued to lure tourists from far, and wide.Motigo Hills is one of the famous places tucked away in the remote villages of Merigi in Bomet County.Tourists flock the area mostly to experience the sunrise and the sunset atop the hill. In the morning, the site creates a perfect lull for those saying prayers. OLD MAN.Others prefer saying morning prayers on the hill, because of its serenity and ‘nearness’ to God.As early as 4am, pilgrims flock the place to say their prayers before dawn lest the sun ‘overhear’ them. Although the name of the hill does not have any meaning in the local dialect, it is traced to an old man who once visited the place and fell in love with the landscape.As the story goes, his origin could not be traced but the man is said to have built himself a house on top of a hill where he lived for many years until his mysterious disappearance.He lived alone and locals believe he might have been devoured by wild animals. Here, tourists love watching the first rays of the sun. They also enjoy watching the sun setting behind the hills on the horizons.A high number of visitors is recorded during the early mornings and late evenings. ", R.drawable.motigohills),


                    new MyMovieData("The Brevan Hotel.","The 3-star rated hotel at the core of the tea landscape of Bomet enjoys great views of the dotted landscape within the tea lover-pleasing haven. Its African inspired design is complemented by a lake; its outdoors setting and garden are among its rate highlights. Experience: Commanding views of the rolling hills of Bomet, Choice of 10 rooms.Located 6kms from Bomet off Narok-Bomet-Kisii Road. ", R.drawable.brevanhotel),


                    new MyMovieData("The Changoi Tea Factory","Unique to Changoi’s Factory is that it is powered entirely by renewable energy making this one of only little sustainable tea estate in Kenya. It is ever stunning multi-layered sweep of tea and verdant rolling hills have for decades 'warmed the hearts' of visitors to this region. With over 140 years of experience in the tea art of growing, selecting, and blending, a trip to Changoi Farm is an enriching experience. The farm now has the largest solar arena in Eastern Africa. ", R.drawable.changoiteafactory),


                    new MyMovieData("Iria Maina Waterfalls."," Iria Maina Waterfall on Itare River in Konoin is one of the moderately known sights in Bomet, with huge potential.In recent times, the County Government in conjunction with several investors, have embarked on fabrication of a hydro power plant with 14 MW capacity. Additionally, Itare River, Iria Maina Falls, and the 'series of caves' on its bank has very significant potential as a must-see site on the Western Area Circuit Found at Boito area, Konoin ", R.drawable.iriamainawaterfalls),


                    new MyMovieData("Tenwek Falls.","The 14ms falls nearby Tenwek Hospital set-hard in a verdant country is necessary see location, especially pleasant soon after the rainy season. They occurs on River Nyangores a tributary of Mara River which flows from Mau Forest, south via Tenwek. Experience: Power generating station established years ago by missionaries; Cave situated below the falls - once housed 'tiondab barak' (the animal of the sky) a local myth. Nearby Church built in 1936, still in use. ", R.drawable.tenwekfalls),


                    new MyMovieData("Maasai Mara National Reserve"," Bomet is a key path to world renowned Masai Mara in the neighbouring Narok County. Due to its proximity to Maasai Mara, the trippers who wish to visit the Mara know Bomet. Locals enjoy weekend trips to the M. Mara for game safaris. Tenwek, which is just 60 kms from the Masai Mara, serves as the jump-off centre. Bomet is situated off the Kisii Narok highway, about 300km Southwest of Nairobi CountyNarok - Bomet Town - 82kms. ", R.drawable.maasaimaranationalreserve),


                    new MyMovieData("The Mau Forest Complex","Bomet borders a long stretchof the indigenous Mau Forest - home to abounding species oflora and fauna including the Yellow Backed Duicker' found only in Mau Forest - in Kenya.It is the largest closed-canopy montane ecosystem in Eastern Africa and serves as a splendid roadside attraction en-route to Kericho from Sotik. Mau Forestencompasses 7 forest regions within the: Mau Narok, Maasai Mau, Eastern and Western Mau, Southern and South West Mau and Bomet's Trans-mara Mau forest. ", R.drawable.mauforestcomplex),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("36") ){
            setUpToolbar();
            setTitle("Kakamega");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Savona Island"," It is a retreat and events centre that features swimming pools, well-manicured lawns, luxury guest rooms and a modern restaurant. It is situated on an isle of about 3 acres, at the edge of Kakamega Forest. ", R.drawable.savonaisland),


                    new MyMovieData("Bukhungu Stadium"," It is not really an attraction site but an event and sporting facility located in Kakamega town. It is a multipurpose stadium where you can visit to watch local football matches and cultural events. The stadium has a capacity of 5,000 people. ", R.drawable.bukhungustadium),


                    new MyMovieData("Muliro Gardens"," It is a public park located in Kakamega town. It was named after Masinde Muliro, one of the notable figures who shaped the political landscape in Kenya. It is a beautiful garden ideal for picnics and team building activities. ", R.drawable.mulirogardens),


                    new MyMovieData("Isiukhu Fall"," It is a small waterfall located within the Kakamega Forest. It is one of the scenic places you need to visit while touring the Kakamega Forest. ", R.drawable.isiukhufall),


                    new MyMovieData("Ilesi Pottery Centre ","It is located along the Kakamega-Kisumu highway. It is one of the biggest pottery-making centres in western Kenya. It is a place you need to visit to have a look at assorted pottery and wares made from moist clay. ", R.drawable.ilesipotterycentre ),


                    new MyMovieData("Rondo Retreat Centre"," It is a serene and tranquil retreat centre for nature lovers. It is home to a variety of rare species of plants and birds, thus making it a gem for birdwatching activities. The centre also offers luxury accommodation in cottages. ", R.drawable.rondoretreatcentre),


                    new MyMovieData("Rosterman Mines"," It is a gold mining site located off the Kakamega-Mumias Road. You can visit the site to have a glimpse of the local gold mining industry. ", R.drawable.rostermanmines),


                    new MyMovieData("Malava Forest"," It is a tropical forest located along the Kakamega- Webuye Road. It covers an area of about 10 hectares. It features indigenous trees, diverse birdlife and monkeys. It is a gem for birdwatching and nature trails. ", R.drawable.malavaforest),


                    new MyMovieData("Crying Stone"," It is located at Ilesi, along the Kakamega-Kisumu Road. It is a rock formation about 40 m high, with a small rock perched on top. There is a stream of water, which flows between the two rocks, creating an impression of a crying stone. It serves as a shrine and cultural centre for the local communities in Kakamega County. ", R.drawable.cryingstone),


                    new MyMovieData("Kakamega Forest"," It is Kenya’s only tropical rainforest and the last remt of the ancient Guineo-congolian rainforest that once stretched all across the continent. It is home to animals such as bush pigs, hedgehogs, colobus monkeys, debrazzar monkeys, different species of birds and trees. It is a paradise for bird watching, hiking, nature walks and rock climbing. ", R.drawable.kakamegaforest),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("37") ){
            setUpToolbar();
            setTitle("Vihiga");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Broadpark Hotel"," It is located along the Kakamega-Kisumu Road, near Gusanga filling station. It offers luxury accommodation in spacious guest rooms categorized as; single rooms, deluxe rooms, and executive suites. ", R.drawable.broadparkhotel),


                    new MyMovieData("Bunyore Hills"," It is a series of hills located in Bunyore area and Kima. The hills offer amazing opportunities for hiking and bird watching adventures. ", R.drawable.bunyorehills),


                    new MyMovieData("Sosa Cottages"," The hotel is set in a tranquil environment characterized by well-manicured lawns and gardens, which offer a unique blend of relaxation and comfort in a village setting. The hotel aims at ensuring that guests get to experience the unique Western Kenya hospitality and have a taste of traditional Maragoli culinary delights. It prides in 40 luxurious guest rooms with a 70-bed capacity. ", R.drawable.sosacottages),


                    new MyMovieData("Nganyi Hill"," The spectacular hills are regarded as the hills of the rainmakers. It is believed that the first rainmaker (Anyole) used to dwell within the hills. There is a community meteorological radio station within the hills. The radio station was actually established to honor Anyole who was a prominent rainmaker. ", R.drawable.nganyihill),


                    new MyMovieData("Kibiri Forest"," It is also part of the extensive Central and East African tropical rainforest eco-system. It is located in Hamisi sub-county. It is a suitable destination for nature walks, picnics, and team building activities. It also serves as a center where the Tirikis conduct their traditional circumcision ceremonies. ", R.drawable.kibiriforest),


                    new MyMovieData("Kaimosi Forest"," It is part of the Central and East African tropical rainforest eco-system. It features indigenous trees and vegetation that form a perfect habitat for different species of birds and arthropods. It is an ideal destination for nature walks, bird watching adventures, picnics, and team building activities. ", R.drawable.kaimosiforest),


                    new MyMovieData("Maragoli Hills"," The scenic hills are located just adjacent to the Mungoma caves. The hills offer exemplary opportunities for birdwatching adventures, hiking, and sightseeing of the beautiful Western Kenya scenery. ", R.drawable.maragolihills),


                    new MyMovieData("Mungoma Caves"," The spectacular caves represent the origin of the Maragoli People. It is believed that ‘Mulogooli’, father of the Maragoli people settled here. The caves double up as a protected shrine where the Maragolis pay annual tributes to their founding father ", R.drawable.mungomacaves),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("38") ){
            setUpToolbar();
            setTitle("Bungoma");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Chetambe Hill"," The historical hill is located in Webuye town. Legendary Bukusu clansmen are said to have died at the hills while fighting the colonialists. The hill offers amazing opportunities for hiking and sightseeing of Webuye town and it’s environ. ", R.drawable.chetambehill),


                    new MyMovieData("Kabuchai Hills"," The scenic hills offer excellent opportunities for hiking, nature walks, camping and bird watching adventures. ", R.drawable.kabuchaihills),


                    new MyMovieData("Teremi Falls"," The waterfall emanates from River Kuywa on the southern slopes of Mount Elgon, at an altitude of about 2000 meters. It is also one of the unexplored sites in Bungoma County. A magnificent waterfall is surrounded by beautiful vegetation that provides a conducive habitat for wild animals. A walking trail is situated near the splendid waterfall. ", R.drawable.teremifalls),


                    new MyMovieData("Buteyo Miti Park"," A locally owned park sits on about 32 acres of land. It features a tree nursery for indigenous trees and a section where herbal medicine is offered. It is a well-maintained park ideal for nature adventures, educational visits and research activities. ", R.drawable.buteyomitipark),


                    new MyMovieData("Malakisi Falls"," It is one of the unexplored sites in Bungoma County. The splendid waterfall is located within the Mount Elgon biosphere, close to the rock footprints that locals claim to be of Jesus. You can tour the splendid waterfall that is also surrounded by beautiful vegetation and various bird species. ", R.drawable.malakisifalls),


                    new MyMovieData("Mwibalewa Mwanja"," It is a sacred site situated about 3 kilometers from Sang’alo hills. The site features a freestanding granite monolith, believed to be Kenya’s largest single stone monolith. Numerous bushes that are breeding grounds for reptiles such as snakes and lizards surround the stone monolith. MwibalewaMwanja rock serves as a source for various streams, which merge into River Nzoia. ", R.drawable.mwibalewamwanja),


                    new MyMovieData("Elijah Masinde Mausoleum"," Elijah Masinde was a freedom fighter and founder of the Diniya Musambwa church. A mausoleum was built at his home in Maeni, about 10 kilometres from Kimilili town. You can visit the mausoleum to learn about the history of Elijah Masinde, and to have a glimpse of his traditional artefacts and tools. ", R.drawable.elijahmasindemausoleum),


                    new MyMovieData("Sang’alo Hill"," It is a scenic hill dotted with rock formations, bushy vegetation and trees that form a habitat for ", R.drawable.sangalohill),


                    new MyMovieData("Nabuyole Falls"," It is a scenic waterfall located in River Nzoia, between Chetambe Hills in Webuye. The waterfall is said to have a powerful force that can pull one towards its basin if you go near it. It is one of the most amazing places to visit in Bungoma County. The fall was initially known as Broderick falls. ", R.drawable.nabuyolefalls),


                    new MyMovieData("Chetambe Fort Ruins"," A Tachoni warrior called ChetambeIfile, from where he mobilized his troops to fight the colonialists, built the fort. It is built behind a 12-foot defensive ditch. It is the site where about 500 people were killed by British troops in 1895. ", R.drawable.chetambefortruins),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("39") ){
            setUpToolbar();
            setTitle("Busia");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Bukoma Beach"," It is a public beach located in Bunyala West ward, Budalangi constituency. It is also an ideal place for swimming adventures, fishing and boat riding activities. ", R.drawable.bukomabeach),


                    new MyMovieData("Bumbe Beach"," Bumbe beach is situated in Samia. It is a perfect place to enjoy swimming, boat rides, water sports and fishing adventures in Lake Victoria. ", R.drawable.bumbebeach),


                    new MyMovieData("Chelelemuk Hill"," The hill is situated in Malaba town, a few kilometres from the Kenya-Uganda border. It is also one of the hiking, camping and trail walking destinations in Busia County. ", R.drawable.chelelemukhill),


                    new MyMovieData("Emakina Hills"," The magnificent hills are located in Nambale town. The hills feature bushy vegetation and trees, which form an important habitat for different species of birds. You can visit the hills for hiking and birdwatching adventures. ", R.drawable.emakinahills),


                    new MyMovieData("Sio-Siteko Swamp"," The wetland traverses Busia and Samia districts in Kenya and Uganda. It is a renowned habitat for over 100 species of birds, including the endangered grey-crowned crane. It is part of the catchment area that covers 35,000 hectares of land featuring River Sio, Malakisi and Malaba. ", R.drawable.siositekoswamp),


                    new MyMovieData("Yala Swamp"," It is a wetland region of over 200 square kilometers in the southwestern edge of Busia County. It serves as a filter for water that flows into Lake Victoria from River Nzoia and Yala. The swamp is a habitat of over 100 species of birds, the endangered sitatunga antelope, endangered fish species such as Oreochromisesculentus and Oreochromis variabilis. ", R.drawable.yalaswamp),


                    new MyMovieData("Namenya Hills"," The spectacular hills are located in Bunyala. The estimated terrain level of the hills is 1134 meters. Bushes and indigenous trees surround the hills, which attract over 100 bird species. It is a favourable destination for bird watching and hiking adventures. ", R.drawable.namenyahills),


                    new MyMovieData("Kavirondo Series Rocks"," The rock series are developed around Busia town, Nambale and Butula. They form a very impressive topographical feature, actually Busiacounty’s most outstanding topographical feature. The series of rocks include mudstones, granites, dolerites, black felsites, conglomerates and sandstones. ", R.drawable.kavirondoseriesrocks),


                    new MyMovieData("Samia Hills"," The magnificent hills are located in Samia sub-county. The hills consist of acid and sub-acid lavas, tuffs and agglomerates, banded quartzite and ironstones. The hills offer amazing opportunities for hiking and bird watching adventures. ", R.drawable.samiahills),


                    new MyMovieData("Kakapel National Monument"," It is a rock art site located on a huge rock shelter in Teso North, Busia County. It was officially opened to the public in 2007 after a rehabilitation exercise done by the National Museums of Kenya. It has paintings that illustrate wild animals, rainmaking and initiation symbols. It is Kenya’s leading rock art centre. ", R.drawable.kakapelnationalmonument),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("40") ){
            setUpToolbar();
            setTitle("Siaya");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Villa International Palace Hotel"," It is located in Madeya, off Kisumu-Busia Highway. It offers accommodation in guest rooms categorized as; single suite rooms, executive suites, deluxe suites, and superior suites. It also prides in a modern swimming pool that offers amazing opportunities for recreation. ", R.drawable.villainternationalpalacehotel),


                    new MyMovieData("Pride Hotel Bondo"," It is located off Bondo-Usenge road. It offers luxury accommodation in single rooms, double rooms, deluxe rooms, executive rooms, and cottage rooms. It also prides in modern conference facilities, a state of the art swimming pool and an onsite restaurant that offers sumptuous meals. ", R.drawable.pridehotelbondo),


                    new MyMovieData("Got Ramogi Hill"," The sacred hill is located in Yimbo. It serves as a point of unification for the Luos who usually gather at the place to celebrate their cultural uniqueness. There is also a shrine located within the hill, where the Legio Maria followers conduct their prayers. ", R.drawable.gotramogihill),


                    new MyMovieData("Yala Swamp"," It is a wetland region of over 200 square kilometers that covers both Siaya and Busia counties. The swamp is a habitat for over 100 species of birds, the endangered sitatunga antelope, endangered fish species such as Oreochromisesculentus and Oreochromisvariabilis. ", R.drawable.yalaswamp),


                    new MyMovieData("Uhanya Beach"," It is a perfect place to enjoy swimming, boat rides, other water sports such as kayaking, and fishing adventures on Lake Victoria. ", R.drawable.uhanyabeach),


                    new MyMovieData("El Molo Crocodile Park and Lodge"," It is a budget-friendly lodge and crocodile park located in Uhanya, Siaya County. It is an ideal destination for backpackers, campers, family getaways, and team building activities. Accommodation is offered in 2 cottages and a 6 bedroom house. You can also visit the place to acquaint yourself with the life cycle of different species of crocodiles. ", R.drawable.elmolocrocodileparkandlodge),


                    new MyMovieData("Ndanu Falls"," The scenic waterfalls are located about a kilometer from Siaya town. The breathtaking falls are surrounded by beautiful vegetation that attracts different species of birds, and numerous rocks. It is a favorite destination for sightseeing and bird watching adventures. ", R.drawable.ndanufalls),


                    new MyMovieData("Sauti Kuu Foundation Resource, Culture and Sports Centre"," This is a platform for disadvantaged children and young people that allows them to uncover their strengths and realize their full potential to live independent successful lives. The center was open by former US President Barack Obama on 16th July 2018. It is located in Kogelo ", R.drawable.sautikuufoundationresourcecultureandsportscentre),


                    new MyMovieData("Kogelo Cultural Centre"," Kogelo is the hometown of Barack Obama, former president of the United States of America. It is a showcase of culture that depicts the humble beginning and originality of Barack Obama, the world’s greatest political leader. The cultural center also preserves the rich culture of the Luo community, through displays of Luo artifacts and traditional homesteads. ", R.drawable.kogeloculturalcentre),


                    new MyMovieData("Jaramogi Oginga Odinga Mausoleum"," It is a community-based museum situated in Bondo, at Jaramogi Oginga Odinga’s homestead. It was established as a sign of honor and remembrance of Jaramogi Oginga Odinga, Kenya’s first Vice President. Attractions here include several Luo artifacts and the late Jaramogi’s books, awards and other artifacts. It is more of a cultural center where you can visit to acquaint yourself with the rich culture of the Luos. ", R.drawable.jaramogiogingaodingamausoleum),


                    new MyMovieData("Lake Kanyaboli National Reserve"," Lake Kanyaboli is the second largest ox-bow lake in Africa. Lake Kanyaboli is sandwiched between Yala swamp and Akara hills. Major attractions to see here include; different species of birds/endemic birds such as the papyrus gonolek, papyrus canary, papyrus yellow warbler, and Caruthers cisticola. The rare sitatunga antelopes can also be spotted here. It is actually one of the best places in Siaya County to visit for bird watching adventures, fishing expeditions, and picnics. ", R.drawable.lakekanyabolinationalreserve),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("41") ){
            setUpToolbar();
            setTitle("Kisumu");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Kiboko Bay"," It is an amazing tourist destination endowed with natural attractions and charms. You can watch the vibrant birdlife; enjoy boat rides and an excursion to the Dunga fishing village. Accommodation is also offered in luxurious safari tents and deluxe cottages. ", R.drawable.kibokobay),


                    new MyMovieData("Art Markets"," You can visit the Maasai market located along the Kisumu- Nairobi road. Numerous art pieces, decorations and paintings can be found here. Another famous art market is the Kisumu Art House where a variety of art collections can be found. ", R.drawable.artmarkets),


                    new MyMovieData("Dunga Hill Camp"," It is a serene site located on the shores of Lake Victoria that offers a perfect environment for camping, picnics, kayaking, boat riding, hippo watching, bird watching and team building activities. Luxury accommodation is offered at the facility in tented camps. ", R.drawable.dungahillcamp),


                    new MyMovieData("Dunga Beach"," It is a popular beach in Kisumu, located on the eastern shores of Lake Victoria. It is known for fishing activities and boat riding. There are also numerous restaurants on site where you can enjoy fresh fish at pocket-friendly prices. ", R.drawable.dungabeach),


                    new MyMovieData("Lwang’ni Beach"," It is a famous fish outlet on the shores of Lake Victoria, where you can enjoy fresh tilapia at affordable prices. This is one of the places you should never fail to visit when in Kisumu. It is located off OgingaOdinga Road, Kisumu. ", R.drawable.lwangnibeach),


                    new MyMovieData("Ndere Island National Park"," It is an island of serenity and beauty located off the Kisumu- Bondo road. It takes approximately 45 minutes with a speedboat direct from Kisumu. A wide variety of animals like hippos, baboons, monitor lizards, snakes, Nile crocodiles, impalas, sitatunga antelope, waterbucks, zebras and different species of birds can be found at the park. ", R.drawable.ndereislandnationalpark),


                    new MyMovieData("Kit Mikayi"," It is a large rock formation, with about three (3) rocks on top. It is situated approximately 29 kilometres from Kisumu Town. It is a sacred site amongst the locals who live there. They conduct prayers and fasting sessions at the facility. It is also a pilgrimage site for the Legio Maria sect. There is a picnic area just below the rocks where you can spend some quality time with your family or friends ", R.drawable.kitmikayi),


                    new MyMovieData("Hippo Point"," It is an open viewing point for hippos on Lake Victoria. There is a camping site and a fishing port on site. It is actually a romantic place where you can enjoy sundowners and family picnics. ", R.drawable.hippopoint),


                    new MyMovieData("Kisumu Museum"," The museum was opened in 1980. It is located along the Kisumu- Kericho Highway. It features a gallery of cultural materials of people from Western Kenya, in particular, Luo artefacts and other traditional aspects like the Luo homestead. It also features an outdoor snake park, tortoise pens, aquariums and a crocodile site. ", R.drawable.kisumumuseum),


                    new MyMovieData("Kisumu Impala Sanctuary"," It is located approximately 3 kilometres from Kisumu CBD. A beautiful sanctuary hosts impalas, vervet monkeys, the rare sitatunga antelope, buffalos, giraffes, cheetahs, zebras and other primates. It is also home to five campsites with spectacular views of Lake Victoria, the world’s second largest freshwater lake. The sanctuary is a perfect spot for birdwatching, nature walks, boat rides and hiking activities. ", R.drawable.kisumuimpalasanctuary),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("42") ){
            setUpToolbar();
            setTitle("Homa Bay");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Abasuba Community Peace Museum"," The museum was established in 2000. It is a community initiative to promote and protect the cultural and natural heritage of the Abasuba. The Abasuba have however been assimilated by the Luo. You can visit the museum to learn the history and culture of the Abasuba people. ", R.drawable.abasubacommunitypeacemuseum),


                    new MyMovieData("Gwasi Hills"," You can explore the spectacular hills covered with bushlands and forests. It is also a paradise for diverse species of birds. It is a perfect destination for hiking activities and nature walks. ", R.drawable.gwasihills),


                    new MyMovieData("Mfangano, Ngodhe and Rusinga Islands"," The scenic islands offer excellent sites and opportunities for fishing expeditions, swimming, birdwatching, water sports, waterbus rides and camping. All the islands are located in Lake Victoria. ", R.drawable.mfanganongodheandrusingaislands),


                    new MyMovieData("Takawiri Island"," It is a private hypsographic island with a small stretch of sandy white beach. It is a perfect game for lovers of a tranquil environment. You can engage in fishing, swimming, bird watching and boat riding while at the island. It also features an island resort that offers chalet accommodation, local and international cuisine. ", R.drawable.takawiriisland),


                    new MyMovieData("Mawanga Rock Art"," It is the main rock art site on the Lake Victoria basin. It is situated in Mfangano Islands, a few kilometres from Mawanga village. You can visit the place to view scenic rock arts created several years ago by hunters and gatherers who lived within the area. ", R.drawable.mawangarockart),


                    new MyMovieData("Homa Hills Hot Springs"," The scenic salty hot springs can boil an egg in less than 15 minutes. Evaporation at the site leaves behind a salt scum called ‘bala’, which locals use as salt for their livestock. Locals also believe that water from the spring can be used to treat skin diseases. ", R.drawable.homahillshotsprings),


                    new MyMovieData("Kanjera Archaeological Site"," It is located on the southern side of the Winam Gulf. It is a prehistoric site where excavations began in 1987. Several pieces of evidence of early human activity have been discovered at the site. Some of the excavations found include animal fossils and stone tools. ", R.drawable.kanjeraarchaeologicalsite),


                    new MyMovieData("Tom Mboya Mausoleum"," It is a historical site located in Kasawanga Village, about 7 kilometres from Mbita. It was built two years after the assassination of Tom Mboya in 1969. It was gazetted as a national monument in 2001, in honour of Tom Mboya’s contribution towards the struggle for Kenya’s independence. The mausoleum contains books, newspapers, gifts and accolades that Tom Mboya received during his life. The mausoleum is open daily from 9 am to 6 pm ", R.drawable.tommboyamausoleum),


                    new MyMovieData("Simbi Nyaima"," It is a volcanic crater lake located in Kendu Bay. It was formed 6 centuries ago after an earthquake that was accompanied by a volcanic eruption. Locals believe that water from the lake has medicinal value and can be used to cure many diseases. The Lake is also a seasonal home of migrating flamingos from different regions in Kenya. ", R.drawable.simbinyaima),


                    new MyMovieData("Ruma National Park"," It lies on the flat foot of the seasonally watered Lambwe River Valley, approximately 30 kilometres from Rusinga Island. It is Kenya’s last remaining sanctuary for the endangered roan antelope. It also features exceptional birdlife, towering cliffs, and wildlife such as leopards, buffaloes, giraffes, hyenas, impalas, vervet monkeys and lions. It is an ideal destination for camping, birdwatching, game viewing, picnic and team building activities. ", R.drawable.rumanationalpark),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("43") ){
            setUpToolbar();
            setTitle("Migori");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{

                    new MyMovieData("Migori Country Lodge"," It is a luxury lodge located in Migori Town. It offers comfortable accommodation in elegantly furnished guest rooms. It also prides in state of the art conference facilities, an onsite restaurant that serves sumptuous meals, a well-stocked bar that serves both alcoholic and nonalcoholic drinks. ", R.drawable.migoricountrylodge),


                    new MyMovieData("Treat House Resort"," It is located in Rongo, off the Kisii-Migori Highway. It boasts of very spacious and clean guestrooms, extensive gardens ideal for holding events and other outdoor functions, an onsite restaurant, a bar/lounge and modern conference facilities. ", R.drawable.treathouseresort),


                    new MyMovieData("Sunaton Hotel"," It offers luxury accommodation in budget single rooms, deluxe single rooms, and executive suites. It also prides in a well-manicured garden ideal for holding outdoor events, an onsite restaurant that serves both local and international cuisines and state of the art meeting/banquet facilities. ", R.drawable.sunatonhotel),


                    new MyMovieData("Calabash Hotel"," It is situated in a serene environment along Suna-Migori Road. It features an on-site restaurant that serves local and continental dishes, a well-stocked bar with alcoholic and non-alcoholic drinks, free wi-Fi, free parking and an airport shuttle upon request. It offers comfortable accommodation in guest rooms fitted with wardrobes, TVs with satellite reception and en-suite showers. ", R.drawable.calabashhotel),


                    new MyMovieData("Gogo Falls"," It is a dam spillway on River Kuja, located in Rapogi about 30 kilometers from Migori Town. It doubles as an archaeological site where some of the earliest appearances of artifacts such as pottery and iron artifacts were discovered. ", R.drawable.gogofalls),


                    new MyMovieData("Mugabo Caves"," It is actually a natural rock formation that resembles a house-like composition. The attraction is located in Nyatike. It offers amazing opportunities for sightseeing adventures and hiking. ", R.drawable.mugabocaves),


                    new MyMovieData("Sori Karungu"," It is a picturesque fishing village in Migori County, on the shores of Lake Victoria near the frontier with Tanzania. It is a nice place to visit for photography sessions, fishing expeditions, and sightseeing adventures. ", R.drawable.sorikarungu),


                    new MyMovieData("Macalder Gold Mines","The macalder gold mines are located in Nyatike. You can visit the place to have a glimpse of how small scale artisan gold mining happens. ", R.drawable.macaldergoldmines),


                    new MyMovieData("Got Kweru"," It is a pilgrimage site for the Legio Maria sect. The legendary founder and leader (Ondeto) of the sect was buried here. The Legio Maria adherents frequently hold prayers and worship at this location. ", R.drawable.gotkweru),


                    new MyMovieData("Thimlich Ohinga"," A pre-historic site features rock dwellings, forts, and living places, which depict the early lifestyle of the people who settled at the site during the early Luo migration and settlement in South Nyanza. It is approximately a one-hour drive from Migori Town to the pre-historic site. ", R.drawable.thimlichohinga)



            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);
        }
        else if (parsedStringID.equals("44") ){
            setUpToolbar();
            setTitle("Kisii");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Kisii Golf Club (Erera)"," It is an exceptional golfing club in Kisii County, with a nine (9) whole golf course. It also prides in other recreational facilities such as a modern gym, a state of the art swimming pool and an onsite restaurant that offers various delicacies. ", R.drawable.kisiigolfclub),


                    new MyMovieData("Nyamasibi Hills"," The spectacular hills with an elevation of about 2170 meters offer excellent and unique opportunities for hiking and sightseeing of the beautiful Kisii County and its environs. ", R.drawable.nyamasibihills),


                    new MyMovieData("Kiong’anyo Hills"," The picturesque hills offer ideal opportunities for hiking and other nature-related adventures. ", R.drawable.kionganyohills),


                    new MyMovieData("Nyangweta Forest"," The forest is located in Gucha South district. It covers approximately 104 hectares. It is also one of the major attractions for nature lovers in Kisii County. You can visit the forest for nature walks and bird watching adventures. ", R.drawable.nyangwetaforest),


                    new MyMovieData("River Gucha"," It is one of the main rivers that drain into Lake Victoria. It originates in the highlands of Kiabonyoru in Nyamira County. It is a major attraction for nature lovers. ", R.drawable.rivergucha),


                    new MyMovieData("Sameta Hills"," The scenic hills also provide exceptional opportunities for hiking adventures and sightseeing of other beautiful sceneries in Kisii County and beyond. ", R.drawable.sametahills),


                    new MyMovieData("Kamel Park Hotel ","x It is a 5-star hotel located in Kiogoro, which is a 20 minutes’ drive from Kisii Town CBD. The state of the art hotel redefines the art of hospitality for both business and leisure travelers. Kamel Park Hotel’s location is one of the highest points of the largely hilly and undulating landscape of Kisii County. The high altitude provides an ideal microclimate for unwinding and leisure. The hotel boasts of a breathtaking view of the lush scenery that dots Kisii Town and its environs. ", R.drawable.kamelparkhotel ),


                    new MyMovieData("Nyakwana Falls "," It is a breathtaking waterfall located in River Gucha which originates in the highlands of Kiabonyoru. This is one of the best places to visit in Kisii County for sightseeing adventures. ", R.drawable.nyakwanafalls ),


                    new MyMovieData("Manga Hills"," The picturesque hills provide ideal opportunities for hiking and sightseeing adventures. The hills also serve as a boundary between Kisii and Nyamira counties. ", R.drawable.mangahills),


                    new MyMovieData("Tabaka Soapstone Mining and Carvings"," Tabaka is definitely one place you need to visit while touring Kisii County. It is located about 24 kilometres from Kisii town. You can visit the place to have a glimpse of how soapstone is mined and the various beautiful carvings made from soapstone. Tabaka is actually the main source of soapstone in Kenya. You can purchase the numerous soapstone carvings at affordable prices. ", R.drawable.tabakasoapstoneminingandcarvings),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("45") ){
            setUpToolbar();
            setTitle("Nyamira");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Bonyunyu Dam"," The project that aims to harness the Gucha River,to benefit communities in Nyamira and Kisii counties will also include a massive dam,that is set to enliven the rural county of Nyamira.The government of Netherlands and of Kenya have assigned Kshs.28 million from each toward the feasibility studies on the Bonyunyu’s project which has commenced; and being carried out by a reputable firm as per bilateral rules and regulations.On completion,it is envisioned that it will amplify touring sights in Nyamira and introduce a water-related sporting. ", R.drawable.bonyunyudam),


                    new MyMovieData("Kiabonyoru Hill","Rising to 3000 ms at its high point the Kiabonyoru Hill,the highest in Nyamira and,also the highest area in South-western Kenya region is a source of salient rivers found in the Gusii highlands and which all empty into Lake Victoria.From its summit,Kiabonyoru offers a scenic vantage point to view the low-lying areas as far as Homa Hills,and lake Victoria in the west and to the east views of the expansive Sotik Tea Estates.Further south spreads the vast plains of the famous Maasai Mara National Reserve. ", R.drawable.kiabonyoruhill),


                    new MyMovieData("Emanga Ridge"," The Abagusii community associate themselves with Emanga ridge which is located at the top of Manga hills in the region.The ridge,which is about 100 acres,divides both Kisii and Nyamira counties martking their boundaries whereby Nyamira county takes the top of the cliff while Kisii takes the lower part.The area has been earmarked as a historical feature and carries special significance for the Abagusii community.According to the 94-year-old Samson Obae,who dwell at the foot of the cliff,Emanga was the first place the settled before they spread to other parts of Gusii region. ", R.drawable.emangaridge),


                    new MyMovieData("Keera Caves"," 4 kilometres from Nyamira Town is a site whose rich history continues draw visitors in by their numbers.A few meters from Keera waterfalls is a cave where rainmakers once gathered to make their sacrifices.Visitors gather to watch the water cascade,even after all these years,it is still fascinating,and the myths surrounding Keera falls only serve to pique their interest further.In the past residents of Nyamira county often brought bundles of firewood here to appease a creature they had heard of in stories told by their grandparents.Under the waterfall is a site where traditional rites were performed.Whenever there was drought ,old men would perform a traditional dance at the site and carry bundles of firewood into the cave.This,they believed,would lead to rain. ", R.drawable.keeracaves),


                    new MyMovieData("Trek up the Manga Hills."," Manga escarpment offers unique scenery and great picnics sites in Nyamira County, with a rich refreshing and breath-taking view of flush land below. A steep,rocky,ragged five-kilometre long cliff line defines what can only be described as a marvel of mother nature.Picnic lovers get more than what they bargain for.Besides the fantastic view,they are regaled with myths and legends about two mysterious caves at the escarpment.The hill offers Nyamira County a gift of nature that can generate great revenue if tapped well,says Mzee Christopher Nyangweso,85, a volunteer tour guide.The escarpment has rich historical information on the legends and myths of the Abagusii community. ", R.drawable.trekupthemangahills),


                    new MyMovieData("America Hotel"," America hotel is remarkable for its good services and delicious meals.Guests can enjoy great value for their money spent at the America hotel ", R.drawable.americahotel),


                    new MyMovieData("River Kuja"," Also, referred to as the Gucha River, River Kuja is located in Nyamira county.It originates in the highlands of Kiabonyoru in Nyamira County, passing through the heart of Gucha District and runs west through Migori county where it joins the Migori River and flows as the Kuja-Migori river into Lake Victoria. ", R.drawable.riverkuja),


                    new MyMovieData("Manga Hills"," In 1907,Mr.Warrior Otenyo who was among those that resisted the British was buried without his head on the hills.This is after he attacked an army administrator known as Gas Northcott with a spear.The administrator never died and organized for a revenge that saw Mr.Otenyo arrested.He was later tried in a public court and then,killed by a British army at Kisii stadium.His head was cut and transported to London as proof of his death.Otenyo’s body was then,left on a public bridge as a warning to others who opposed the colonials.In accordance with culture,the Gusii elders carried his headless body and buried it at the top of Manga Escarpment(hills).However,up to date,the specific grave where the warrior’s body was laid has never been identified. ", R.drawable.mangahills),


                    new MyMovieData("Nyanchwa Hills"," Also known as”Ekerore”, Nyanchwa hills offer an amazing view of Kisii town. ", R.drawable.nyanchwahills),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }
        else if (parsedStringID.equals("46") ){
            setUpToolbar();
            setTitle("Nairobi");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            myMovieData = new MyMovieData[]{
                    new MyMovieData("Tall Buildings ","Most of the tallest buildings in Kenya are found in Nairobi, the capital and largest city in the country. In Nairobi, there are 18 buildings that stand taller than 80 metres (260 ft) and several under construction. The tallest building in the city is the new 32-storey, 200 metres (660 ft) Britam Towers. The second-tallest building in the city is the 33-storey, 163 metres (535 ft) UAP Tower. The most recent skyscrapers to be constructed are Prism Tower, Le'Mac and FCB Mirhab Tower. Nairobi's history of towers began with the IPS Building (1967), the Hilton Nairobi (1969), the NSSF Building (1973), and the Kenyatta International Conference Centre in 1974. Buildings in the city remained relatively short until the late 1960s when the city experienced its first skyscraper boom. From 1960 to 1980, Nairobi witnessed a major expansion of skyscraper and high-rise construction. Many of the city's office towers were completed during this period, such as the New Central Bank Tower. A near twenty-year full in building construction came after this expansion, though Nairobi has experienced a smaller second building expansion beginning in the late 1990s and continuing into the present. As of 2015, Nairobi had 50 completed high-rise buildings, with 6 more under construction, and another 6 proposed. Other towns in the country are starting to experience a surge in the construction of skyscrapers. For instance, the recently completed Moi University Pension Scheme Complex (Daima Tower) in Eldoret completed in 2016 stands at 89 meters featuring among the tallest in Kenya. Construction of high-rise buildings are on going in other regions such as Mombasa. 29. Mc Millan Memorial ", R.drawable.tallbuildings ),


                    new MyMovieData("Kipande House"," This is where Kenyans were once required to be registered and issued with identity cards, hence the building’s name. ", R.drawable.kipandehouse),


                    new MyMovieData("Kazuri Beads Factory Tour","If you are looking for some unique souvenirs and gifts for family and friends, the Kazuri Beads Factory is a great place to shop and help out disadvantaged local women at the same time. Kazuri means 'small and beautiful' in Swahili, and these shiny, brightly colored beads surely fit the bill. Join a free factory tour and see how local women, including many single mothers, make the beads and other pottery items from scratch. After the tour, you can purchase some to take with you, knowing you are purchasing from a World Fair Trade Organization member. Prices are relatively reasonable. This is a great tour to combine with a visit to the Karen Blixen Museum, as the factory lies right nearby. ", R.drawable.kazuribeadsfactorytour),


                    new MyMovieData("Parliament","The Parliament building is the symbol of and houses the Kenyan legislature. It represents the history of Kenya’s goverce and thus making it one of the top places to visit while in the city. ", R.drawable.parliament),


                    new MyMovieData("Nairobi national park","Nairobi National Park is a unique ecosystem by being the only protected area in the world close to a capital city. The park is located only 7 km from Nairobi city centre. Major wildlife attractions are the Black rhino, lion, leopard, cheetah, hyena, buffaloes, Giraffe, zebra, wildebeest, elands and diverse birdlife with over 400 species recorded. It’s an awesome place to spend your weekends and also houses other attractions include the Ivory burning site Monument, Nairobi Safari Walk, the Orphanage and the walking trails at hippo pools. ", R.drawable.nairobinationalpark),


                    new MyMovieData("Oloolua Nature Trail"," The National Museums of Kenya established the 5km long Oloolua Nature Trail in part of the Oloolua forest, in Karen, providing a quiet peaceful place for city residents looking to escape the city hustle and bustle. The trail is open every day from 9am to 6pm. ", R.drawable.olooluanaturetrail),


                    new MyMovieData("Art centres","Nairobi has some of the continent’s most renowned art centres like Kuona Trust and the Godown arts centre where you get to interact and see some of the art worked completed and being worked on by Kenyan artists. ", R.drawable.artcentres),


                    new MyMovieData("KICC","The Kenyatta International Conference Centre is an internationally renowned venue for conferences, meetings, exhibitions and special events and among the tallest buildings in Nairobi. For Ksh. 200 bob, you can go to the rooftop and enjoy a marvelous and exclusive view of the city. ", R.drawable.kicc),


                    new MyMovieData("Kenya National Archives"," The Kenya National Archives is situated at the edge of the central business district in downtown Nairobi along Moi Avenue next to Ambassadeur Hotel. It was established in 1965 and holds 40,000 volumes. It also houses the Murumbi Gallery, which is currently the largest Pan-African art gallery in Africa and contains ancient art collections from different regions and communities of Africa. The government of Kenya acquired the collected artifacts after a concessionary arrangement was agreed upon with Joseph Murumbi, who had initially turned down several huge offers to buy his collections by overseas bidders. ", R.drawable.kenyanationalarchives),


                    new MyMovieData("August Memorial park","The August 7 Memorial Park is located at the 1998 Bomb blast scene along Haile Selassie Avenue. It is dedicated to those who lost their lives and contains a notice board listing their names. ", R.drawable.augustmemorialpark),


                    new MyMovieData("Paradise lost","Paradise lost is a beautiful oasis in the middle of a coffee farm close to Kiambu Town, about 10km from Nairobi. It is one of very few places close to Nairobi that offers a myriad of attractions and activities for the whole family. The most popular attraction at Paradise Lost is a labyrinth of caves eroded by the waters of the nearby Gichi River, with their entrance screened by a spectacular waterfall. These caves are estimated to be 2.5 million years old, based on obsidian rock artefacts from the late stone age that were discovered inside. Artificial lighting has been installed a few meters into the caves up to a large cavern within. ", R.drawable.paradiselost),


                    new MyMovieData("Maasai ostrich farm","The Maasai Ostrich Farm is located about 45 km south of Nairobi. You will not only enjoy a taste of Ostrich meat but you will also get a chance to ride on Ostrich. ", R.drawable.maasaiostrichfarm),


                    new MyMovieData("Paintball Fury Limited","Paintball Fury Limited is located in Karen and Langata and offers you the chance to enjoy paintball which simulates armed combat with teams fighting to possess and advance a flag to the opponent end, without being shot at. Protective gear like overalls, headgear and a back and chest protector are provided once you purchase 100 paintballs (minimum) for 1000 Kenya shillings. ", R.drawable.paintballfurylimited),


                    new MyMovieData("Mamba village","Nairobi Mamba Village is a sanctuary for crocodiles located 12 km south of Nairobi City. The farm also houses Ostrich and is a popular destination for tourists and students. The best time to visit is during crocodiles feeding time. You will be thrilled at how high giant crocs can jump to grab thrown pieces of meat oblivious of the other gaping giant crocodiles. ", R.drawable.mambavillage),


                    new MyMovieData("Village market ","The Village Market is located in the Gigiri and is one of Kenya’s largest shopping, recreation and entertainment complex housing over 150 stores outlets. There are several outlets that specialize in African artifacts and other Kenyan crafts. Moreover, every Friday, the shopping center hosts the Maasai Market â€“a cultural bazaar that brings together around 400 artisans and craftsmen who specialize in an array of ethnic relics. ", R.drawable.villagemarket ),


                    new MyMovieData(" GP-Karting","If you love, speed and racing then step away from the console and get yourself to gp karting in Langata. The venue is open from Tuesday to Sunday between 9am and 6pm. ", R.drawable. gpkarting),


                    new MyMovieData("Uhuru gardens","Uhuru gardens is the largest memorial park in Kenya. The inaugural ceremony for Kenya’s first president, President Jomo Kenyatta was conducted at this park on 12 December 1963 when Kenya gained its independence. A 24-metre high monument commemorating Kenyas’ struggle for independence is the centrepiece of attractions at Uhuru Gardens. ", R.drawable.uhurugardens),


                    new MyMovieData("Bomas of Kenya","The Bomas of Kenya offer you a chance to get an insight into the cultures of some of Kenya’s tribes with tribal villages and interactions with some of those versed in the same. ", R.drawable.bomasofkenya),


                    new MyMovieData("Nairobi Arboretum","Nairobi Arboretum was established in 1907 by Mr. Batiscombe, then Deputy Conservator of Forests, to try out introduced forestry trees for Kenya.It is located along state house road in Kilimani. The Arboretum occupies 30 hectares, holds over 350 tree species, and offers a great space for walks, picnics and events. ", R.drawable.nairobiarboretum),


                    new MyMovieData("Panari sky centre ice skati","You have seen it in movies and probably want to try it out. Panari sky centre offers you the opportunity to turn your dreams of ice-skating into reality. An hour in the Ice Rink will cost about 500 for kids and 700 Kenya shillings for adults respectively and boots are provided on arrival. ", R.drawable.panariskycentreiceskati),


                    new MyMovieData("8. Blue Sky Tours in Diamond Plaza","You do not have to go out into the wild to enjoy some rock climb thanks to Blue Sky’s indoor rock climbing facility located in the Diamond plaza. Whether you are a pro or an amatuer out to try something new there is something for everyone. ", R.drawable.blueskytoursindiamond),


                    new MyMovieData("David Sheldrick Trust Elephant Orphan Centre"," Dame Daphne established the Trust in honour of her late husband David Sheldrick, the founding warden of the Tsavo National Parks, and a pioneer conservationist in Kenya. The orphanage caters for the welfare of orphaned Elephants and Rhinos who are raised in the sanctuary and eventually released back to the wild. ", R.drawable.davidsheldricktrustelephantorphancentre),


                    new MyMovieData("Ngong Hills "," The Ngong Hills is about 22km southwest of the city, makes it a very popular weekend destination for visitors. The hike up Ngong Hills starts from Ngong town at the northern foot of the hills 1961m above sea level, and traverses the whole range to the southern end at Kona Baridi. This takes about 4 to 5 hour to complete, depending on fitness levels. ", R.drawable.ngonghills ),


                    new MyMovieData("Karura Forest"," Karura Forest is an urban forest in Nairobi, the capital of Kenya. The forest was gazetted in 1932 and is managed by the Kenya Forest Service in conjunction with the Friends of Karura Forest. Features in the forest include a waterfall, bamboo forest, marshland, Mau Mau caves and an old church. The first trail, which is four kilometres long and connects Limuru Road with Old Kiambu Road, was opened in May 2009. ", R.drawable.karuraforest),


                    new MyMovieData("Giraffe Center","Jock Leslie-Melville, the Kenyan grandson of a Scottish Earl, started the Giraffe Centre when he and his wife Betty captured a baby giraffe to start a programme of breeding giraffe in captivity at their home in Langata – home of the present centre. Since then the programme has had huge success, resulting in the introduction of several breeding pairs of Rothschild Giraffe into Kenyan national parks. It is located at Karen, approximately 5 kilometres from the centre of Nairobi. ", R.drawable.giraffecenter),


                    new MyMovieData("Karen Blixen "," The Karen Blixen Museum, located 10 km outside of Nairobi, is the former African home of Danish author Karen Blixen, famous for her book Out of Africa that chronicles life at the estate. ", R.drawable.karenblixen ),


                    new MyMovieData("Railway Museum"," The Nairobi Railway Museum was established in 1971 to preserve and display the relics and records of the railways of East Africa and is located adjacent to Nairobi railway station.The museum’s collection of locomotives is increasing with the addition of some early diesel locomotives and, examples of passenger coaches. ", R.drawable.railwaymuseum),


                    new MyMovieData("National Museum"," The Nairobi National Museum was founded in1920, and established at its present location in 1929. Want to learn about the country’s history, it’s people, culture and art then this is aplace you can start with. The Museum aims to interpret Kenya’s rich heritage and offers a one stop for visitors to sample the country’s rich heritage both for education and for leisure. It is open on all 356 days throughout the year from 0830hrs -17300hrs. ", R.drawable.nationalmuseum),

            };

            myMovieAdapter = new MyMovieAdapter(myMovieData,Venues.this,this);

            recyclerView.setAdapter(myMovieAdapter);


        }




    }
    public void darkbutton(View view) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

    }

    public void setUpToolbar() {
        getSelectedShape();
        drawerLayout = findViewById(R.id.drawerLayout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.County, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.black));
        actionBarDrawerToggle.syncState();
    }




    private void getSelectedShape()
    {
        Intent previousIntent = getIntent();
        parsedStringID = previousIntent.getStringExtra("id");
        selectedShape = Counties.countiesList.get(Integer.valueOf(parsedStringID));
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.toleft, R.anim.toright);
    }

    @Override
    public void onNoteClick(int position) {
        Intent intent = new Intent(Venues.this, VenueDetails.class);
        intent.putExtra("selected_note", myMovieData[position].getMovieName() );
        intent.putExtra("selected_image", myMovieData[position].getMovieImage() );
        intent.putExtra("selected_detail", myMovieData[position].getMovieDate() );

        startActivity(intent);
    }
}
