/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
 
public interface CommonCallBack {
     void onGetSucces();

    void onGetFailed(String message);

    void onGetError(String error);
}
