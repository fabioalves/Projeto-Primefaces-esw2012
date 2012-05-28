using UnityEngine;
using System.Collections;

public class Stars : MonoBehaviour
{
    public float speed;

    private Transform myTransform;
    void Start()
    {
        myTransform = transform;
    }

    void Update()
    {
        float amtToMove = speed * Time.deltaTime;
        myTransform.Translate(Vector3.down * amtToMove, Space.World);

        if (myTransform.position.y < -11.49)
        {
            myTransform.position = new Vector3(myTransform.position.x, 14.9f, myTransform.position.z);
        }
    }
    
}
