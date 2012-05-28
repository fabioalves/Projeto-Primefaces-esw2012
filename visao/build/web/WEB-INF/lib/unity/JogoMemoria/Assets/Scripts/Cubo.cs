using UnityEngine;
using System.Collections;

public class Cubo : MonoBehaviour {

    
	// Use this for initialization
	void Start () {
	
	}
	
	// Update is called once per frame
	void Update () {
        
        if (Input.GetAxis("Fire1") == 1f)
        {
            transform.Translate(1, 2, transform.position.z);// = Quaternion.Inverse(transform.rotation);
        }
	
	}
}
