//package panos.gui.test;
//
//import com._ureason.ui.jfc.UBaseTextField;
//import com.ureason.util.Model;
//import com.ureason.util.UBitSet;
//import com.ureason.util.UBitSet.DisplayFormat;
//import com.ureason.util.metadata.MetaData;
//import org.jetbrains.annotations.Nullable;
//
//import javax.swing.*;import javax.swing.JFormattedTextField;import javax.swing.JTextField;
//import java.lang.Class;import java.lang.Object;import java.lang.Override;import java.lang.String;import java.text.ParseException;
//import java.util.regex.Pattern;
//
///*
// * Copyright (c) UReason.  All Rights Reserved.
// * <p/>
// * @author Panos
// */
//public class UBitSetFieldOld extends UBaseTextField<UBitSet>
//{
//
//  private UBitSet _bitSet;
//
//  public UBitSetFieldOld(UBitSet value)
//  {
//    super();
//    setObject(value, true);
//  }
//
//  @Override
//  protected JTextField createTextField()
//  {
//    JFormattedTextField textField = new JFormattedTextField(new JFormattedTextField.AbstractFormatter() {
//
//      private DisplayFormat _displayFormat;
//
//      @Override
//      public Object stringToValue(String text) throws ParseException
//      {
//        _displayFormat = null;
//        String hexPattern = "\\A\\b0x[0-9a-fA-F]+\\b\\Z";
//        String decPattern = "\\A\\b0d[0-9]+\\b\\Z";
//        String binaryPattern = "\\A\\b[0-1]+\\b\\Z";
//
//        boolean valid = false;
//        //<editor-fold desc="check case of pasting a string">
//        if (Pattern.compile(hexPattern).matcher(text).matches()) {
//          _displayFormat = DisplayFormat.HEX;
//          valid = true;
//        }
//        else if(Pattern.compile(decPattern).matcher(text).matches()){
//          _displayFormat = DisplayFormat.DEC;
//          valid = true;
//        }
//        else if(Pattern.compile(binaryPattern).matcher(text).matches()){
//          _displayFormat = DisplayFormat.BIN;
//          valid = true;
//        }
//
//        return valid ? new UBitSet(text, text.length()) : "";
//      }
//
//      @Override
//      public String valueToString(Object value) throws ParseException
//      {
//        String res = value instanceof UBitSet ?
//                        _displayFormat == DisplayFormat.HEX ? ((UBitSet) value).toHexString() :
//                        _displayFormat == DisplayFormat.DEC ? ((UBitSet) value).toDecimalString() :
//                        _displayFormat == DisplayFormat.BIN ? ((UBitSet) value).toBinaryString() : null :
//                     value instanceof String ? value.toString() : null;
//
//        return res;
//
//      }
//    });
////    textField.setDocument(new BitSetDocument());
////    textField.addPropertyChangeListener("value", new PropertyChangeListener() {
////      @Override
////      public void propertyChange(PropertyChangeEvent evt)
////      {
////        saveToModel();
////        getTextComponent().selectAll();
////      }
////    });
//    return textField;
//  }
//
//  @Override
//  protected Class getDataClass()
//  {
//    return UBitSet.class;
//  }
//
//  @Override
//  protected UBitSet getData()
//  {
//    return _bitSet;
//  }
//
//  @Override
//  protected void setData(UBitSet data)
//  {
//    _bitSet = data;
//  }
//
//  @Override
//  protected void setControlValue(UBitSet value)
//  {
//    ((JFormattedTextField) getTextField()).setValue(value);
//    try
//    {
//      ((JFormattedTextField) getTextField()).commitEdit();
//    } catch (ParseException e)
//    {
//      e.printStackTrace();
//    }
//    getTextField().selectAll();
//  }
//
//  @Nullable
//  @Override
//  protected UBitSet getControlValue()
//  {
//    Object value = ((JFormattedTextField) getTextField()).getValue();
//    return value instanceof String ? new UBitSet((String) value, ((String) value).length()) :
//           value instanceof UBitSet ? ((UBitSet) value) : new UBitSet("00000000",8);
//  }
//
//  @Override
//  public void setModel(@Nullable Model model)
//  {
//    setObject(model != null ? model.getData() : null);
//  }
//
//  @Nullable
//  @Override
//  public MetaData getModelMetaData()
//  {
//    return null;
//  }
//}
