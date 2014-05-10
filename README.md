Circular Counter
=============
Circular Counter is an Android Widget I needed to implement for an application I was developing. As it could be useful to more people, I tried to make it generic enough to share and be used by others.

The view shows a value in the center together with 3 bars that grow depending on the values received. Digging into code you can easily increase or decrease the number of bars.

<a href="https://play.google.com/store/apps/details?id=com.db.circularcounterdemo">
  <img alt="Android app on Google Play" src="https://developer.android.com/images/brand/en_app_rgb_wo_45.png" />
</a>

Screenshots
----------------

![Demo Screenshot][5]


Usage
--------

Add ``CircularCounter`` widget to your layout. Configure the view customization elements using styleable attributes or/and programatically. This is a basic example, explore the code to get to know it in detail.

```xml

    <com.db.circularcounter.CircularCounter
        xmlns:counter="http://schemas.android.com/apk/res-auto"
        android:id="@+id/counter"
        android:layout_width="300dp"
        android:layout_height="300dp"
        counter:range="60"
        counter:textSize="100sp"
        counter:textColor="#ffffff"
        counter:metricSize="20sp"
        counter:metricText="metric"
    />

```

```java

    //First Bar
    counter.setFirstWidth(getResources().getDimension(R.dimen.first))
    counter.setFirstColor(Color.parseColor(colors[0]))

    //Second Bar
    counter.setSecondWidth(getResources().getDimension(R.dimen.second))
    counter.setSecondColor(Color.parseColor(colors[1]))

    //Third Bar
    counter.setThirdWidth(getResources().getDimension(R.dimen.third))
    counter.setThirdColor(Color.parseColor(colors[2]))
            
    counter.setBackgroundColor(Color.parseColor(colors[3]));

```

To pass values to the view use  ``setValues(value1, value2, value3)``. First value will be the one shown in text.


[1]: ./screenshot.png