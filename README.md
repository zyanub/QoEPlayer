# QoEPlayer

This implementation is built on top of an open-source android player -- ExoPlayer from Google. Only the SimplePlayer is modified whereas FullPlayer is left "as is".

To use the code, please cite the following paper:
Z. Yan, Q. Liu, T. Zhang, and C. W. Chen, "Exploring QoE for power efficiency: a field study on mobile videos with LCD displays," in Proc. of ACM International Conference on Multimedia (MM), Brisbane, Australia, Oct. 2015.

Steps to use the code:
1. Copy the "QoETest" folder (sample video sequence and backlight scaling profile) into the root directory of your phone (For streaming: you can upload these files to your server and update their url in the data structure -- "Sample" in Samples.java)
2. Compile and run the code in "ExoPlayer-master" folder (tested by Android Studio 1.0.1)
3. Enjoy video playing with dynamic backlight scaling!
