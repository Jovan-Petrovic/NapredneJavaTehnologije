/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import java.util.LinkedList;
import java.util.List;
import model.MathModel;

/**
 *
 * @author student1
 */
public class MathOperationStorage {

    private static final MathOperationStorage instance = new MathOperationStorage();
    private final List<MathModel> data;

    private MathOperationStorage() {
        this.data = new LinkedList<>();
    }

    public void add(MathModel model) {
        data.add(model);
    }

    public List<MathModel> getData() {
        return data;
    }

    public static MathOperationStorage getInstance() {
        return instance;
    }

}
