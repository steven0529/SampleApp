package com.reyes.devassessment.util;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class ListManager<T> {

    private Context context;

    private List<T> items;
    private List<T> loadedItems;

    private Class<T> genericClass;

    private AdapterView<Adapter> itemAdapterView;
    private View loadingPanel;
    private View noDataFound;
    private int resourceId;

    public ListManager(Context context, AdapterView<Adapter> itemAdapterView,
                       View loadingPanel, View noDataFound, int resourceId,
                       Class<T> genericClass) {
        super();
        this.itemAdapterView = itemAdapterView;
        this.loadingPanel = loadingPanel;
        this.noDataFound = noDataFound;
        this.resourceId = resourceId;
        this.genericClass = genericClass;
        this.context = context;
    }

    @SuppressWarnings("unchecked")
    public ArrayAdapter<T> populateList(List<T> items,
                                        Class<? extends ArrayAdapter<T>> arrayAdapterClass) {
        itemAdapterView.setVisibility(View.VISIBLE);
        loadingPanel.setVisibility(View.GONE);
        noDataFound.setVisibility(View.GONE);

        this.items = items;

        T[] itemsArray;
        this.loadedItems = items;
        itemsArray = loadedItems.toArray((T[]) Array.newInstance(
                genericClass, items.size()));


        Constructor<? extends ArrayAdapter<T>>[] constructors = (Constructor<? extends ArrayAdapter<T>>[]) arrayAdapterClass
                .getConstructors();
        Object arrayAdapterObj = null;
        try {
            arrayAdapterObj = constructors[0].newInstance(context, resourceId,
                    itemsArray);

            ArrayAdapter<T> arrayAdapter = (ArrayAdapter<T>) arrayAdapterObj;

            itemAdapterView.setAdapter((ArrayAdapter<T>) arrayAdapter);

            arrayAdapter.notifyDataSetChanged();

            itemAdapterView.setSelection(0);
            itemAdapterView.requestFocus();
            return arrayAdapter;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void showLoading() {
        itemAdapterView.setVisibility(View.GONE);
        loadingPanel.setVisibility(View.VISIBLE);
        noDataFound.setVisibility(View.GONE);
    }

    public void displayNoDataFound() {
        itemAdapterView.setVisibility(View.GONE);
        loadingPanel.setVisibility(View.GONE);
        noDataFound.setVisibility(View.VISIBLE);
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public List<T> getLoadedItems() {
        return loadedItems;
    }

    public void setLoadedItems(List<T> loadedItems) {
        this.loadedItems = loadedItems;
    }

}
