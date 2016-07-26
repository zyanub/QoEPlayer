/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
Modified by Zhisheng Yan, State University of New York at Buffalo.
Please cite this paper when using the code:
Zhisheng Yan, Qian Liu, Tong Zhang, Chang Wen Chen, "Exploring QoE for Power Efficiency: A Field Study on Mobile Videos
with LCD Displays", ACM Multimedia Conference (MM), Brisbane, Australia, Oct. 2015.
Contact: zyan3@buffalo.edu

This activity archives the samples (clips) using the above structure. You can declare them in SampleChooserActivity when actually
need to show them
 */
package com.google.android.exoplayer.demo;

import android.os.Environment;

/**
 * Holds statically defined sample definitions.
 */
/* package */ class Samples {

  public static class Sample {

    public final String name;
    public final String contentId;
    public final String uri;
    public final int type;
    public final boolean isEncypted;
    public final boolean fullPlayer;

    public Sample(String name, String contentId, String uri, int type, boolean isEncrypted,
        boolean fullPlayer) {
      this.name = name; // the index number of different version of video yan
      this.contentId = contentId; // the name of a seq with many versions
      this.uri = uri;
      this.type = type;
      this.isEncypted = isEncrypted;
      this.fullPlayer = fullPlayer;
    }

  }
    public static String baseDir = Environment.getExternalStorageDirectory().getAbsolutePath();

    public static final Sample[] Test = new Sample[] {
            new Sample("Original", "twodays_09",
                    "http://www.cse.buffalo.edu/UBMM/Media/Zhisheng/twodays.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "twodays_09",
                    "http://www.cse.buffalo.edu/UBMM/Media/Zhisheng/twodays.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("3", "twodays",
                    "http://www.cse.buffalo.edu/UBMM/Media/Zhisheng/twodays.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("Original", "gonegirl_09",
                    "file:///storage/emulated/0/QoETest/gonegirl.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("4", "gonegirl_09",
                    "file:///storage/emulated/0/QoETest/gonegirl.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("5", "gonegirl",
                    "file:///storage/emulated/0/QoETest/gonegirl.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("Original", "wild_09",
                    "file:///storage/emulated/0/QoETest/wild.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("6", "wild_09",
                    "file:///storage/emulated/0/QoETest/wild.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("7", "wild",
                    "file:///storage/emulated/0/QoETest/wild.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("Original", "foxcatcher",
                    "file:///storage/emulated/0/QoETest/foxcatcher.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("8", "foxcatcher_09",
                    "file:///storage/emulated/0/QoETest/foxcatcher.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("9", "foxcatcher",
                    "file:///storage/emulated/0/QoETest/foxcatcher.mp4", DemoUtil.TYPE_OTHER, false, false),
    }; // yan


    public static final Sample[] Readme = new Sample[] {
            new Sample("readme (important)", "readme",
                    "readme", DemoUtil.TYPE_OTHER, false, false),
    }; // yan
    public static final Sample[] Instr1 = new Sample[] {
            new Sample("Test instruction", "1",
                    "instr", DemoUtil.TYPE_OTHER, false, false),
    }; // yan
    public static final Sample[] Instr2 = new Sample[] {
            new Sample("Test instruction", "2",
                    "instr", DemoUtil.TYPE_OTHER, false, false),
    }; // yan
    public static final Sample[] Instr3 = new Sample[] {
            new Sample("Test instruction", "3",
                    "instr", DemoUtil.TYPE_OTHER, false, false),
    }; // yan
// for test 1
    public static final Sample[] American_Sniper = new Sample[] {
            new Sample("1", "as_shot",
                    "file:///storage/emulated/0/QoETest/as.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "as_gos",
                    "file:///storage/emulated/0/QoETest/as.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("3", "as_cont",
                    "file:///storage/emulated/0/QoETest/as.mp4", DemoUtil.TYPE_OTHER, false, false),
    }; // yan

    public static final Sample[] Big_Buck_Bunny = new Sample[] {
            new Sample("1", "bbb_shot",
                    baseDir + "/QoETest/bbb1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "bbb_gos",
                    baseDir + "/QoETest/bbb1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("3", "bbb_cont",
                    baseDir + "/QoETest/bbb1.mp4", DemoUtil.TYPE_OTHER, false, false),
    }; // yan

    public static final Sample[] Theory = new Sample[] {
            new Sample("1", "theory_shot",
                    "file:///storage/emulated/0/QoETest/theory.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "theory_gos",
                    "file:///storage/emulated/0/QoETest/theory.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("3", "theory_cont",
                    "file:///storage/emulated/0/QoETest/theory.mp4", DemoUtil.TYPE_OTHER, false, false),
    }; // yan

    public static final Sample[] Tear = new Sample[] {
            new Sample("1", "tear_shot",
                    "file:///storage/emulated/0/QoETest/tear1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "tear_gos",
                    "file:///storage/emulated/0/QoETest/tear1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("3", "tear_cont",
                    "file:///storage/emulated/0/QoETest/tear1.mp4", DemoUtil.TYPE_OTHER, false, false),
    }; // yan

//for consitency test
    public static final Sample[] TrainingClip = new Sample[]{ //.74,.68
        new Sample("TrainingClip", "emd2to2g",
                baseDir + "/QoETest/emd2to2.mp4", DemoUtil.TYPE_OTHER, false, false),
        new Sample("TrainingClip", "emd2to2b",
                baseDir +"/QoETest/emd2to2.mp4", DemoUtil.TYPE_OTHER, false, false),
    };

    public static final Sample[] EMD1TO5 = new Sample[]{ // 0.82,0.72,0.62,0.54
        new Sample("1", "emd1to5",
                baseDir +"/QoETest/emd1to5.mp4", DemoUtil.TYPE_OTHER, false, false),
        new Sample("2", "emd1to5",
                baseDir +"/QoETest/emd1to5.mp4", DemoUtil.TYPE_OTHER, false, false),
        new Sample("3", "emd1to5",
                baseDir +"/QoETest/emd1to5.mp4", DemoUtil.TYPE_OTHER, false, false),
        new Sample("4", "emd1to5",
                baseDir +"/QoETest/emd1to5.mp4", DemoUtil.TYPE_OTHER, false, false),
    };
    public static final Sample[] EMD1TO4 = new Sample[]{ //.77,.67,.63
            new Sample("1", "emd1to4",
                    baseDir +"/QoETest/emd1to4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "emd1to4",
                    baseDir +"/QoETest/emd1to4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("3", "emd1to4",
                    baseDir +"/QoETest/emd1to4.mp4", DemoUtil.TYPE_OTHER, false, false),
    };
    public static final Sample[] EMD1TO3 = new Sample[]{ //.74,.68
            new Sample("1", "emd1to3",
                    baseDir +"/QoETest/emd1to3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "emd1to3",
                    baseDir +"/QoETest/emd1to3.mp4", DemoUtil.TYPE_OTHER, false, false),
    };
    public static final Sample[] EMD1TO2 = new Sample[]{ //.78,.77
            new Sample("1", "emd1to2",
                    baseDir +"/QoETest/emd1to2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "emd1to2",
                    baseDir +"/QoETest/emd1to2.mp4", DemoUtil.TYPE_OTHER, false, false),
    };

    public static final Sample[] EMD2TO5 = new Sample[]{ //.63,.53,.47
            new Sample("1", "emd2to5",
                    baseDir +"/QoETest/emd2to5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "emd2to5",
                    baseDir +"/QoETest/emd2to5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("3", "emd2to5",
                    baseDir +"/QoETest/emd2to5.mp4", DemoUtil.TYPE_OTHER, false, false),
    };
    public static final Sample[] EMD2TO5_ = new Sample[]{ //.63,.53,.52
            new Sample("1", "emd2to5_",
                    baseDir +"/QoETest/emd2to5_.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "emd2to5_",
                    baseDir +"/QoETest/emd2to5_.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("3", "emd2to5_",
                    baseDir +"/QoETest/emd2to5_.mp4", DemoUtil.TYPE_OTHER, false, false),
    };
    public static final Sample[] EMD2TO4 = new Sample[]{ //.72,.63
            new Sample("1", "emd2to4",
                    baseDir +"/QoETest/emd2to4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "emd2to4",
                    baseDir +"/QoETest/emd2to4.mp4", DemoUtil.TYPE_OTHER, false, false),
    };
    public static final Sample[] EMD2TO3 = new Sample[]{ //.66
            new Sample("1", "emd2to3",
                    baseDir +"/QoETest/emd2to3.mp4", DemoUtil.TYPE_OTHER, false, false),
    };

    public static final Sample[] EMD3TO5 = new Sample[]{ //.57,.47
            new Sample("1", "emd3to5",
                    baseDir +"/QoETest/emd3to5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "emd3to5",
                    baseDir +"/QoETest/emd3to5.mp4", DemoUtil.TYPE_OTHER, false, false),
    };
    public static final Sample[] EMD3TO4 = new Sample[]{ //,.59
            new Sample("1", "emd3to4",
                    baseDir +"/QoETest/emd3to4.mp4", DemoUtil.TYPE_OTHER, false, false),
    };

    public static final Sample[] EMD4TO5 = new Sample[]{ //,.49
            new Sample("1", "emd4to5",
                    baseDir +"/QoETest/emd4to5.mp4", DemoUtil.TYPE_OTHER, false, false),
    };

    public static final Sample[] EMD_UP = new Sample[] {
        new Sample("1", "emd5to2up",
                baseDir +"/QoETest/emd5to2.mp4", DemoUtil.TYPE_OTHER, false, false),
        new Sample("2", "emd5to1up",
                baseDir +"/QoETest/emd5to1.mp4", DemoUtil.TYPE_OTHER, false, false),
        new Sample("3", "emd5to3up",
                baseDir +"/QoETest/emd5to3.mp4", DemoUtil.TYPE_OTHER, false, false),
        new Sample("4", "emd5to4up",
                baseDir +"/QoETest/emd5to4.mp4", DemoUtil.TYPE_OTHER, false, false),
        new Sample("5", "emd4to3up",
                baseDir +"/QoETest/emd4to3.mp4", DemoUtil.TYPE_OTHER, false, false),
        new Sample("6", "emd4to2up",
                baseDir +"/QoETest/emd4to2.mp4", DemoUtil.TYPE_OTHER, false, false),
        new Sample("7", "emd4to1up",
                baseDir +"/QoETest/emd4to1.mp4", DemoUtil.TYPE_OTHER, false, false),
        new Sample("8", "emd3to2up",
                baseDir +"/QoETest/emd3to2.mp4", DemoUtil.TYPE_OTHER, false, false),
        new Sample("9", "emd3to1up",
                baseDir +"/QoETest/emd3to1.mp4", DemoUtil.TYPE_OTHER, false, false),
        new Sample("10", "emd2to1up",
                baseDir +"/QoETest/emd2to1.mp4", DemoUtil.TYPE_OTHER, false, false),
    }; // yan

// for test 2
    public static final Sample[] ti1emd1 = new Sample[] {
            new Sample("Original", "ti1emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("1", "ti1emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "ti1emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("3", "ti1emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("4", "ti1emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("5", "ti1emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("6", "ti1emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("7", "ti1emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("8", "ti1emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("9", "ti1emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("10", "ti1emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("11", "ti1emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("12", "ti1emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("13", "ti1emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("14", "ti1emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("15", "ti1emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("16", "ti1emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("17", "ti1emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("18", "ti1emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("19", "ti1emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("20", "ti1emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
    }; // yan

    public static final Sample[] ti1emd2 = new Sample[] {
            new Sample("Original", "ti1emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("1", "ti1emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "ti1emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("3", "ti1emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("4", "ti1emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("5", "ti1emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("6", "ti1emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("7", "ti1emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("8", "ti1emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("9", "ti1emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("10", "ti1emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("11", "ti1emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("12", "ti1emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("13", "ti1emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("14", "ti1emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("15", "ti1emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("16", "ti1emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("17", "ti1emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("18", "ti1emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("19", "ti1emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("20", "ti1emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
    }; // yan

    public static final Sample[] ti1emd3 = new Sample[] {
            new Sample("Original", "ti1emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("1", "ti1emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "ti1emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("3", "ti1emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("4", "ti1emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("5", "ti1emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("6", "ti1emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("7", "ti1emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("8", "ti1emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("9", "ti1emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("10", "ti1emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
    }; // yan

    public static final Sample[] ti1emd4 = new Sample[] {
            new Sample("Original", "ti1emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("1", "ti1emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "ti1emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("3", "ti1emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("4", "ti1emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("5", "ti1emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("6", "ti1emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("7", "ti1emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("8", "ti1emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("9", "ti1emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("10", "ti1emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("11", "ti1emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("12", "ti1emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("13", "ti1emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("14", "ti1emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("15", "ti1emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("16", "ti1emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("17", "ti1emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("18", "ti1emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("19", "ti1emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("20", "ti1emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
    }; // yan

    public static final Sample[] ti1emd5 = new Sample[] {
            new Sample("Original", "ti1emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("1", "ti1emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "ti1emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("3", "ti1emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("4", "ti1emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("5", "ti1emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("6", "ti1emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("7", "ti1emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("8", "ti1emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("9", "ti1emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("10", "ti1emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("11", "ti1emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("12", "ti1emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("13", "ti1emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("14", "ti1emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("15", "ti1emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("16", "ti1emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("17", "ti1emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("18", "ti1emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("19", "ti1emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("20", "ti1emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti1emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
    }; // yan

    public static final Sample[] ti2emd1 = new Sample[] {
            new Sample("Original", "ti2emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("1", "ti2emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "ti2emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("3", "ti2emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("4", "ti2emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("5", "ti2emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("6", "ti2emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("7", "ti2emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("8", "ti2emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("9", "ti2emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("10", "ti2emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("11", "ti2emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("12", "ti2emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("13", "ti2emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("14", "ti2emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("15", "ti2emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("16", "ti2emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("17", "ti2emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("18", "ti2emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("19", "ti2emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("20", "ti2emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
    }; // yan

    public static final Sample[] ti2emd2 = new Sample[] {
            new Sample("Original", "ti2emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("1", "ti2emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "ti2emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("3", "ti2emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("4", "ti2emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("5", "ti2emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("6", "ti2emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("7", "ti2emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("8", "ti2emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("9", "ti2emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("10", "ti2emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("11", "ti2emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("12", "ti2emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("13", "ti2emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("14", "ti2emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("15", "ti2emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("16", "ti2emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("17", "ti2emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("18", "ti2emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("19", "ti2emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("20", "ti2emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
    }; // yan

    public static final Sample[] ti2emd3 = new Sample[] {
            new Sample("Original", "ti2emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("1", "ti2emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "ti2emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("3", "ti2emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("4", "ti2emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("5", "ti2emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("6", "ti2emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("7", "ti2emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("8", "ti2emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("9", "ti2emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("10", "ti2emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("11", "ti2emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("12", "ti2emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("13", "ti2emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("14", "ti2emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("15", "ti2emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("16", "ti2emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("17", "ti2emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("18", "ti2emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("19", "ti2emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("20", "ti2emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
    }; // yan

    public static final Sample[] ti2emd4 = new Sample[] {
            new Sample("Original", "ti2emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("1", "ti2emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "ti2emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("3", "ti2emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("4", "ti2emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("5", "ti2emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("6", "ti2emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("7", "ti2emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("8", "ti2emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("9", "ti2emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("10", "ti2emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("11", "ti2emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("12", "ti2emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("13", "ti2emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("14", "ti2emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("15", "ti2emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("16", "ti2emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("17", "ti2emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("18", "ti2emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("19", "ti2emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("20", "ti2emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
    }; // yan

    public static final Sample[] ti2emd5 = new Sample[] {
            new Sample("Original", "ti2emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("1", "ti2emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "ti2emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("3", "ti2emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("4", "ti2emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("5", "ti2emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("6", "ti2emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("7", "ti2emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("8", "ti2emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("9", "ti2emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("10", "ti2emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti2emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
    }; // yan

    public static final Sample[] ti3emd1 = new Sample[] {
            new Sample("Original", "ti3emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("1", "ti3emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "ti3emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("3", "ti3emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("4", "ti3emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("5", "ti3emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("6", "ti3emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("7", "ti3emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("8", "ti3emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("9", "ti3emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("10", "ti3emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
    }; // yan

    public static final Sample[] ti3emd2 = new Sample[] {
            new Sample("Original", "ti3emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("1", "ti3emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "ti3emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("3", "ti3emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("4", "ti3emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("5", "ti3emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("6", "ti3emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("7", "ti3emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("8", "ti3emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("9", "ti3emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("10", "ti3emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
    }; // yan

    public static final Sample[] ti3emd3 = new Sample[] {
            new Sample("Original", "ti3emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("1", "ti3emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "ti3emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("3", "ti3emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("4", "ti3emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("5", "ti3emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("6", "ti3emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("7", "ti3emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("8", "ti3emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("9", "ti3emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("10", "ti3emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("11", "ti3emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("12", "ti3emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("13", "ti3emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("14", "ti3emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("15", "ti3emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("16", "ti3emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("17", "ti3emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("18", "ti3emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("19", "ti3emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("20", "ti3emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
    }; // yan

    public static final Sample[] ti3emd4 = new Sample[] {
            new Sample("Original", "ti3emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("1", "ti3emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "ti3emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("3", "ti3emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("4", "ti3emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("5", "ti3emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("6", "ti3emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("7", "ti3emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("8", "ti3emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("9", "ti3emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("10", "ti3emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("11", "ti3emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("12", "ti3emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("13", "ti3emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("14", "ti3emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("15", "ti3emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("16", "ti3emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("17", "ti3emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("18", "ti3emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("19", "ti3emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("20", "ti3emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
    }; // yan

    public static final Sample[] ti3emd5 = new Sample[] {
            new Sample("Original", "ti3emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("1", "ti3emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "ti3emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("3", "ti3emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("4", "ti3emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("5", "ti3emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("6", "ti3emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("7", "ti3emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("8", "ti3emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("9", "ti3emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("10", "ti3emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("11", "ti3emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("12", "ti3emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("13", "ti3emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("14", "ti3emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("15", "ti3emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("16", "ti3emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("17", "ti3emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("18", "ti3emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("19", "ti3emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("20", "ti3emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti3emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
    }; // yan

    public static final Sample[] ti4emd1 = new Sample[] {
            new Sample("Original", "ti4emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("1", "ti4emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "ti4emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("3", "ti4emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("4", "ti4emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("5", "ti4emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("6", "ti4emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("7", "ti4emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("8", "ti4emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("9", "ti4emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("10", "ti4emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("11", "ti4emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("12", "ti4emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("13", "ti4emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("14", "ti4emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("15", "ti4emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("16", "ti4emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("17", "ti4emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("18", "ti4emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("19", "ti4emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("20", "ti4emd1_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd1.mp4", DemoUtil.TYPE_OTHER, false, false),
    }; // yan

    public static final Sample[] ti4emd2 = new Sample[] {
            new Sample("Original", "ti4emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("1", "ti4emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "ti4emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("3", "ti4emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("4", "ti4emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("5", "ti4emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("6", "ti4emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("7", "ti4emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("8", "ti4emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("9", "ti4emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("10", "ti4emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("11", "ti4emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("12", "ti4emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("13", "ti4emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("14", "ti4emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("15", "ti4emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("16", "ti4emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("17", "ti4emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("18", "ti4emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("19", "ti4emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("20", "ti4emd2_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd2.mp4", DemoUtil.TYPE_OTHER, false, false),
    }; // yan

    public static final Sample[] ti4emd3 = new Sample[] {
            new Sample("Original", "ti4emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("1", "ti4emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "ti4emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("3", "ti4emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("4", "ti4emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("5", "ti4emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("6", "ti4emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("7", "ti4emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("8", "ti4emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("9", "ti4emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("10", "ti4emd3_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd3.mp4", DemoUtil.TYPE_OTHER, false, false),
    }; // yan

    public static final Sample[] ti4emd4 = new Sample[] {
            new Sample("Original", "ti4emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("1", "ti4emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "ti4emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("3", "ti4emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("4", "ti4emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("5", "ti4emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("6", "ti4emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("7", "ti4emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("8", "ti4emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("9", "ti4emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("10", "ti4emd4_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd4.mp4", DemoUtil.TYPE_OTHER, false, false),
    }; // yan

    public static final Sample[] ti4emd5 = new Sample[] {
            new Sample("Original", "ti4emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("1", "ti4emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("2", "ti4emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("3", "ti4emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("4", "ti4emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("5", "ti4emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("6", "ti4emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("7", "ti4emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("8", "ti4emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("9", "ti4emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
            new Sample("10", "ti4emd5_sin",
                    "file:///storage/emulated/0/QoETest/ti4emd5.mp4", DemoUtil.TYPE_OTHER, false, false),
    }; // yan

    public static final Sample[] Streaming_Test = new Sample[] {
            new Sample("Original", "dinner_sin",
                    "http://www.cse.buffalo.edu/UBMM/Media/Zhisheng/dinner.mp4", DemoUtil.TYPE_OTHER, false, false),
    }; // yan



/*
   public static final Sample[] SIMPLE = new Sample[] {
    new Sample("Google Glass (DASH)", "bf5bb2419360daf1",
        "http://www.youtube.com/api/manifest/dash/id/bf5bb2419360daf1/source/youtube?"
        + "as=fmp4_audio_clear,fmp4_sd_hd_clear&sparams=ip,ipbits,expire,as&ip=0.0.0.0&"
        + "ipbits=0&expire=19000000000&signature=255F6B3C07C753C88708C07EA31B7A1A10703C8D."
        + "2D6A28B21F921D0B245CDCF36F7EB54A2B5ABFC2&key=ik0", DemoUtil.TYPE_DASH, false,
        false),
    new Sample("Google Play (DASH)", "3aa39fa2cc27967f",
        "http://www.youtube.com/api/manifest/dash/id/3aa39fa2cc27967f/source/youtube?"
        + "as=fmp4_audio_clear,fmp4_sd_hd_clear&sparams=ip,ipbits,expire,as&ip=0.0.0.0&ipbits=0&"
        + "expire=19000000000&signature=7181C59D0252B285D593E1B61D985D5B7C98DE2A."
        + "5B445837F55A40E0F28AACAA047982E372D177E2&key=ik0", DemoUtil.TYPE_DASH, false,
        false),
    new Sample("Super speed (SmoothStreaming)", "uid:ss:superspeed",
        "http://playready.directtaps.net/smoothstreaming/SSWSS720H264/SuperSpeedway_720.ism",
        DemoUtil.TYPE_SS, false, false),
    new Sample("Dizzy (Misc)", "uid:misc:dizzy",
        "http://html5demos.com/assets/dizzy.mp4", DemoUtil.TYPE_OTHER, false, false),
      };

  public static final Sample[] YOUTUBE_DASH_MP4 = new Sample[] {
    new Sample("Google Glass", "bf5bb2419360daf1",
        "http://www.youtube.com/api/manifest/dash/id/bf5bb2419360daf1/source/youtube?"
        + "as=fmp4_audio_clear,fmp4_sd_hd_clear&sparams=ip,ipbits,expire,as&ip=0.0.0.0&"
        + "ipbits=0&expire=19000000000&signature=255F6B3C07C753C88708C07EA31B7A1A10703C8D."
        + "2D6A28B21F921D0B245CDCF36F7EB54A2B5ABFC2&key=ik0", DemoUtil.TYPE_DASH, false,
        true),
    new Sample("Google Play", "3aa39fa2cc27967f",
        "http://www.youtube.com/api/manifest/dash/id/3aa39fa2cc27967f/source/youtube?"
        + "as=fmp4_audio_clear,fmp4_sd_hd_clear&sparams=ip,ipbits,expire,as&ip=0.0.0.0&ipbits=0&"
        + "expire=19000000000&signature=7181C59D0252B285D593E1B61D985D5B7C98DE2A."
        + "5B445837F55A40E0F28AACAA047982E372D177E2&key=ik0", DemoUtil.TYPE_DASH, false,
        true),
  };

  public static final Sample[] YOUTUBE_DASH_WEBM = new Sample[] {
    new Sample("Google Glass", "bf5bb2419360daf1",
        "http://www.youtube.com/api/manifest/dash/id/bf5bb2419360daf1/source/youtube?"
        + "as=fmp4_audio_clear,webm2_sd_hd_clear&sparams=ip,ipbits,expire,as&ip=0.0.0.0&ipbits=0&"
        + "expire=19000000000&signature=A3EC7EE53ABE601B357F7CAB8B54AD0702CA85A7."
        + "446E9C38E47E3EDAF39E0163C390FF83A7944918&key=ik0", DemoUtil.TYPE_DASH, false, true),
    new Sample("Google Play", "3aa39fa2cc27967f",
        "http://www.youtube.com/api/manifest/dash/id/3aa39fa2cc27967f/source/youtube?"
        + "as=fmp4_audio_clear,webm2_sd_hd_clear&sparams=ip,ipbits,expire,as&ip=0.0.0.0&ipbits=0&"
        + "expire=19000000000&signature=B752B262C6D7262EC4E4EB67901E5D8F7058A81D."
        + "C0358CE1E335417D9A8D88FF192F0D5D8F6DA1B6&key=ik0", DemoUtil.TYPE_DASH, false, true),
  };

  public static final Sample[] SMOOTHSTREAMING = new Sample[] {
    new Sample("Super speed", "uid:ss:superspeed",
        "http://playready.directtaps.net/smoothstreaming/SSWSS720H264/SuperSpeedway_720.ism",
        DemoUtil.TYPE_SS, false, true),
    new Sample("Super speed (PlayReady)", "uid:ss:pr:superspeed",
        "http://playready.directtaps.net/smoothstreaming/SSWSS720H264PR/SuperSpeedway_720.ism",
        DemoUtil.TYPE_SS, true, true),
  };

  public static final Sample[] WIDEVINE_GTS = new Sample[] {
    new Sample("WV: HDCP not specified", "d286538032258a1c",
        "http://www.youtube.com/api/manifest/dash/id/d286538032258a1c/source/youtube?"
        + "as=fmp4_audio_cenc,fmp4_sd_hd_cenc&sparams=ip,ipbits,expire,as&ip=0.0.0.0&ipbits=0"
        + "&expire=19000000000&signature=41EA40A027A125A16292E0A5E3277A3B5FA9B938."
        + "0BB075C396FFDDC97E526E8F77DC26FF9667D0D6&key=ik0", DemoUtil.TYPE_DASH, true, true),
    new Sample("WV: HDCP not required", "48fcc369939ac96c",
        "http://www.youtube.com/api/manifest/dash/id/48fcc369939ac96c/source/youtube?"
        + "as=fmp4_audio_cenc,fmp4_sd_hd_cenc&sparams=ip,ipbits,expire,as&ip=0.0.0.0&ipbits=0"
        + "&expire=19000000000&signature=315911BDCEED0FB0C763455BDCC97449DAAFA9E8."
        + "5B41E2EB411F797097A359D6671D2CDE26272373&key=ik0", DemoUtil.TYPE_DASH, true, true),
    new Sample("WV: HDCP required", "e06c39f1151da3df",
        "http://www.youtube.com/api/manifest/dash/id/e06c39f1151da3df/source/youtube?"
        + "as=fmp4_audio_cenc,fmp4_sd_hd_cenc&sparams=ip,ipbits,expire,as&ip=0.0.0.0&ipbits=0"
        + "&expire=19000000000&signature=A47A1E13E7243BD567601A75F79B34644D0DC592."
        + "B09589A34FA23527EFC1552907754BB8033870BD&key=ik0", DemoUtil.TYPE_DASH, true, true),
    new Sample("WV: Secure video path required", "0894c7c8719b28a0",
        "http://www.youtube.com/api/manifest/dash/id/0894c7c8719b28a0/source/youtube?"
        + "as=fmp4_audio_cenc,fmp4_sd_hd_cenc&sparams=ip,ipbits,expire,as&ip=0.0.0.0&ipbits=0"
        + "&expire=19000000000&signature=2847EE498970F6B45176766CD2802FEB4D4CB7B2."
        + "A1CA51EC40A1C1039BA800C41500DD448C03EEDA&key=ik0", DemoUtil.TYPE_DASH, true, true),
    new Sample("WV: HDCP + secure video path required", "efd045b1eb61888a",
        "http://www.youtube.com/api/manifest/dash/id/efd045b1eb61888a/source/youtube?"
        + "as=fmp4_audio_cenc,fmp4_sd_hd_cenc&sparams=ip,ipbits,expire,as&ip=0.0.0.0&ipbits=0"
        + "&expire=19000000000&signature=61611F115EEEC7BADE5536827343FFFE2D83D14F."
        + "2FDF4BFA502FB5865C5C86401314BDDEA4799BD0&key=ik0", DemoUtil.TYPE_DASH, true, true),
    new Sample("WV: 30s license duration", "f9a34cab7b05881a",
        "http://www.youtube.com/api/manifest/dash/id/f9a34cab7b05881a/source/youtube?"
        + "as=fmp4_audio_cenc,fmp4_sd_hd_cenc&sparams=ip,ipbits,expire,as&ip=0.0.0.0&ipbits=0"
        + "&expire=19000000000&signature=88DC53943385CED8CF9F37ADD9E9843E3BF621E6."
        + "22727BB612D24AA4FACE4EF62726F9461A9BF57A&key=ik0", DemoUtil.TYPE_DASH, true, true),
  };

  public static final Sample[] MISC = new Sample[] {
    new Sample("Dizzy", "uid:misc:dizzy", "http://html5demos.com/assets/dizzy.mp4",
        DemoUtil.TYPE_OTHER, false, true),
    new Sample("Dizzy (https->http redirect)", "uid:misc:dizzy2", "https://goo.gl/MtUDEj",
        DemoUtil.TYPE_OTHER, false, true),
    new Sample("Apple AAC 10s", "uid:misc:appleaacseg", "https://devimages.apple.com.edgekey.net/"
        + "streaming/examples/bipbop_4x3/gear0/fileSequence0.aac",
        DemoUtil.TYPE_OTHER, false, true),
  };
*/
  private Samples() {}

}