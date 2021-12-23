package com.airbnb.lottie.parser;

import android.graphics.Rect;

import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;


public class LottieCompositionMoshiParser {
  private static final JsonReader.Options NAMES = JsonReader.Options.of(
      "w", // 0
      "h", // 1
      "ip", // 2
      "op", // 3
      "fr", // 4
      "v", // 5
      "layers", // 6
      "assets", // 7
      "fonts", // 8
      "chars", // 9
      "markers" // 10
  );

  public static LottieComposition parse(JsonReader reader) throws IOException {
    float scale = Utils.dpScale();
    float startFrame = 0f;
    float endFrame = 0f;
    float frameRate = 0f;
    final LongSparseArray<Layer> layerMap = new LongSparseArray<>();
    final List<Layer> layers = new ArrayList<>();
    int width = 0;
    int height = 0;
    Map<String, List<Layer>> precomps = new HashMap<>();
    Map<String, LottieImageAsset> images = new HashMap<>();
    Map<String, Font> fonts = new HashMap<>();
    List<Marker> markers = new ArrayList<>();
    SparseArrayCompat<FontCharacter> characters = new SparseArrayCompat<>();

    LottieComposition composition = new LottieComposition();
    reader.beginObject();
    while (reader.hasNext()) {
      switch (reader.selectName(NAMES)) {
        case 0:
          width = reader.nextInt();
          break;
        case 1:
          height = reader.nextInt();
          break;
        case 2:
          startFrame = (float) reader.nextDouble();
          break;
        case 3:
          endFrame = (float) reader.nextDouble() - 0.01f;
          break;
        case 4:
          frameRate = (float) reader.nextDouble();
          break;
        case 5:
          String version 