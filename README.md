A simple test project using my own custom ImageDownloader library 

To use the ImageDownloader:

		ImageDownloader
          .within(mContext)
          .into(ImageDownloader.Method.GET, url)
          .asBitmap()
          .setCacheManager(bitmapCacheManager)
          .setCallback(new HttpListener<Bitmap>() {
              @Override
              public void onRequest() {
                //Add request methods here.
              }
              @Override
              public void onResponse(Bitmap data) {
                //Add response methods here
              }
              @Override
              public void onError() {
              //Handle error here.
              }
              @Override
              public void onCancel() {
                //Handle when onCancel here.
              }
  	});
          
Note: enable cache via CacheManager, please see example inside test project
