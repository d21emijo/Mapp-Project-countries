# Mapp-Project-countries

## Mål
Målet med uppgiften var att skapa en app där i förstahand användaren får ranka sina resemål, detta i en recyclerview där varje view är ett land där
lite fakta finns om landet.
appen var tänkt att vara lätt att navigera med så lite information som möjligt, där eventuella nya funktioner skulle få nya screens.
### tänkta utföranden
Då denna app är för den resande och upptäckaren så hämtas all data från nätet med hjälp av JsonTask, då tanken var att man kanske inte alltid har
internet access var tanken att den data som hämtas läggs över i asseten countries.json och använda denna om inget internet fanns då detta var lite för advancerat
får det vänta till countries V.2 kommer ut

Inflate recyclerview så att att städer eller resemål dyker upp i en recyclerview inuti recyclerviewn var en annnan tanke som också var tvungen att läggas på is.



## Utförande

### recyclerview
Det första som gjordes var att skapa en recyclerview i MainActivity.java 

```
        recyclerView = findViewById(R.id.recycler_view);
        recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);
```
vi hittar vi vår recyclerview, skapar vår adapter och bestämmer att vi ska ha en linearlayout.



```
    @Override
    public void onBindViewHolder(CountriesViewHolder holder, int position) {
        Countries countries = items.get(position);//hämta index position

        holder.country.setText("name: "+countries.getName()); //skriva ut i title name för index
        holder.population.setText("Continent: " +countries.getLocation());
        holder.whatdo.setText(String.valueOf("population: " + countries.getSize())+ " thousand");

    }
```
i våran adapter så gör vi plats för vår text och vad vi ska skriva ut i recyclerviewn.
här skriver vi ut de namn jag döpt länderna till , antal invånare och kontinent.

![image](https://user-images.githubusercontent.com/102797583/170471535-55aededa-dee1-4380-a8e7-81e11c5f2a10.png)

### Json

Det första vi gör är att vi måste veta vart vi letar för att hämta datan vi behöver detta gör vi genom att lägga in länken i JSON_URL.
```
private final String JSON_URL = "https://mobprog.webug.se/json-api?login=d21emijo";
```

för att ladda ner filer skapar vi en ny Jsontask och hämtar datan.

```
new JsonTask(this).execute(JSON_URL); //ladda ner filen
```
när vi har filen lägger vi in det i våran List av countries.

```
        Gson gson = new Gson();
        Type type = new TypeToken<List<Countries>>() {}.getType();
        List<Countries> listOfCountries = gson.fromJson(json, type); //hämta lista från gson
        recyclerViewAdapter.setItems(listOfCountries);  //hämta lista
        recyclerViewAdapter.notifyDataSetChanged();     //uppdatera
```

### about


För att komma till aboutsidan så används en knapp i MainActivity för att skapa en ny Intent eller screen.

```
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("===","button press");
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);


            }


        });

```

När vi väl har klickat på våran knapp och vi kommer till about sidan så startar vi en webview där vi bestämmer vad vi ska visa i loadurl,
här är det filen about.html som ligger i våran assets.

```
    WebView myWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        Log.d("===","aboutactivityhär");

        myWebView = findViewById(R.id.myWebView);
        myWebView.getSettings().setJavaScriptEnabled(true); //inga javascripts i about
        myWebView.loadUrl("file:///android_asset/about.html");
        //myWebView.setWebViewClient(new WebViewClient());
```
![image](https://user-images.githubusercontent.com/102797583/170481751-9fb0aad9-7fd0-45aa-800e-937697334489.png)



## egen reflektion

Tyckte detta var en rolig uppgift där vi fick användning av allt det vi lärt oss tidigare i kursen. Det svåra i uppgiften (om man bortser från 
de saker jag försökt lägga till som vi inte gått igenom) var att balansera när man skulle commita då jag i efterhand ser att jag ändrat i flera
filer eller på olika saker i koden.

