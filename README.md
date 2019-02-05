# Sport Loader
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/741c49ce40a24b508f327cf2857a1003)](https://www.codacy.com/app/MickaelCalatr/SportLoader?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=MickaelCalatr/SportLoader&amp;utm_campaign=Badge_Grade)
[![](https://img.shields.io/github/license/MickaelCalatr/CircleLoader.svg?style=flat)](https://opensource.org/licenses/MIT)
[![Download](https://api.bintray.com/packages/calatr/Sport_Loader/SportLoader/images/download.svg?version=1.2.0)](https://bintray.com/calatr/Sport_Loader/SportLoader/1.2.0/link)

This is a simple loader library on sport theme for android API 21+.
I needed to create a progress wheel on sport theme. So I created this.

This is how it looks in standard mode but you can configure it as you want.

<img src="assets/soccer_demo.gif" width="29%"/>
<img src="assets/bowling_demo.gif" width="27%"/>
<img src="assets/car_demo.gif" width="28%"/>

## Dependency
Just and this line in your dependencies project.
```gradle
dependencies {
        implementation 'com.mickaelcalatr:sportloadingview:1.2.0'
}
```
## Usage
You can create your own SportLoadingView in xml like this.

```xml
    <com.mickael.sportloadingview.SportLoadingView
        android:id="@+id/loading_circle"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:background="@color/color_loader"
        app:background_alpha="0.7"
        app:image_height="200dp"
        app:image_width="200dp"
        app:image_loader="@drawable/bowling_ball"
        app:fadeInOut_duration="500"
        app:rotate_duration="900"/>
```

To start the loading you can use:
```java
SportLoadingView loadingView = (CircleLoaderView) findViewById(R.id.loading_circle);
loadingView.startLoading();
```
 and to stop the loading use:
```java
loadingView.stopLoading();
```

You can also change all variables programmatically using getter and setter.
```java
loadingView.setMaxAlpha(float maxAlpha)

loadingView.setImage(Drawable image)

loadingView.setBackground(Drawable background)

loadingView.setBackground(int color)

loadingView.setTranslateDuration(int translateDuration)

loadingView.setFadeInOutDuration(int fadeInOutDuration)

loadingView.setRotateDuration(int rotateDuration)

loadingView.setRotate(RotateAnimation rotate)
```

## Other options
In the xml definition, besides the property, you can set:

-   image_loader (reference) set a new image in the loader
-   image_width (dimension) set the image width
-   image_height (dimension) set the image height
-   background_font (reference or color) set an image or a color to the background
-   background_alpha (float) set the alpha maximum to the alpha transition (0 to don't use it)
-   rotate_duration (integer) set the rotation duration
-   translate_duration (integer) set the translation duration
-   fadeInOut_duration (integer) set the fade in and fade out animation duration

## Version

-   1.2 Change repository name, push the library on maven and add javadoc.
-   1.1 Adding function to change options programmatically
-   1.0 Initial release

## Special thanks
Icons made by <a href="https://www.freepik.com/" title="Freepik">Freepik</a>
from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a>
is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="blank"> CC 3.0 BY</a>

## License

```license
The MIT License (MIT)

Copyright (c) 2019 Calatraba Mickael

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
