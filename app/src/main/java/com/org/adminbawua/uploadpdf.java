package com.org.adminbawua;

import static android.provider.OpenableColumns.DISPLAY_NAME;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.HashMap;

public class uploadpdf extends AppCompatActivity {
    private Button addPdf;
    private Button seePdf;
    private Button lookPdf;
    private Button selectPdf;
    private Button ttPdf;
    private Button ddPdf;
    private Button bbPdf;
    private Button choosePdf;
    private Button drawPdf;

    private ImageView pdfImageView;
    private EditText pdfMA102Title;
    private EditText pdfMT102Title;
    private EditText pdfMT101Title;
    private EditText pdfMT103Title;
    private EditText pdfME103Title;
    private EditText pdfME106Title;
    private EditText pdfME104Title;
    private EditText pdfCP101Title;
    private EditText pdfH103Title;
    private Button uploadPdfBtn;
    private Button uploadPdfBot;
    private Button uploadPdfoB;
    private Button uploadPdfb;
    private Button uploadPdfBm;
    private Button uploadPdfBon;
    private Button uploaPdfBtn;
    private Button uploadPdBtn;
    private Button uploadPfBtn;

    private Bitmap bitmap;
    private DatabaseReference databaseReference;
    private StorageReference storageReference;
    private ProgressDialog pd;
    private String pdfName,title;

    private final int REQ = 1;
    private Uri pdfData;

    String downloadUrl = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        storageReference = FirebaseStorage.getInstance().getReference();


        pd = new ProgressDialog(this);
        addPdf = findViewById(R.id.addPdf);
        seePdf = findViewById(R.id.seePdf);
        ddPdf = findViewById(R.id.ddPdf);
        ttPdf = findViewById(R.id.ttPdf);
        selectPdf = findViewById(R.id.selectPdf);
        choosePdf = findViewById(R.id.choosePdf);
        drawPdf = findViewById(R.id.drawPdf);
        bbPdf = findViewById(R.id.bbPdf);
        lookPdf = findViewById(R.id.lookPdf);
        pdfMA102Title = findViewById(R.id.pdfMA102Title);
        pdfMT102Title = findViewById(R.id.pdfMT102Title);
        pdfMT101Title = findViewById(R.id.pdfMT101Title);
        pdfME103Title = findViewById(R.id.pdfME103Title);
        pdfME106Title = findViewById(R.id.pdfME106Title);
        pdfME104Title = findViewById(R.id.pdfME104Title);
        pdfCP101Title = findViewById(R.id.pdfCP101Title);
        pdfMT103Title = findViewById(R.id.pdfMT103Title);
        pdfH103Title = findViewById(R.id.pdfH103Title);
        uploadPdfBtn = findViewById(R.id.uploadPdfButton);
        uploadPdfBot = findViewById(R.id.uploadPdfButto);
        uploadPdfoB = findViewById(R.id.uploadPdfButt);
        uploadPdfb = findViewById(R.id.uploadPdfBut);
        uploadPdfBm = findViewById(R.id.uploadPdfBu);
        uploadPdfBon = findViewById(R.id.uploadPdfB);
        uploadPdBtn = findViewById(R.id.uploadPdfBn);
        uploadPfBtn = findViewById(R.id.uploadPdfBt);
        uploaPdfBtn = findViewById(R.id.uploadPdfBtton);


        seePdf.setOnClickListener((view) -> {
            openGallery();
        });

        uploadPdfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title = pdfME103Title.getText().toString();
                if (title.isEmpty()) {
                    pdfME103Title.setError("Empty");
                    pdfME103Title.requestFocus();
                } else if (pdfData == null) {
                    Toast.makeText(uploadpdf.this, "Please upload pdf", Toast.LENGTH_SHORT).show();
                } else {
                    uploadPdf();
                }

            }
        });
        selectPdf.setOnClickListener((view) -> {
            openGallery();
        });

        uploadPdfBot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title = pdfMT102Title.getText().toString();
                if (title.isEmpty()) {
                    pdfMT102Title.setError("Empty");
                    pdfMT102Title.requestFocus();
                } else if (pdfData == null) {
                    Toast.makeText(uploadpdf.this, "Please upload pdf", Toast.LENGTH_SHORT).show();
                } else {
                    uploadPdf();
                }

            }
        });
        lookPdf.setOnClickListener((view) -> {
            openGallery();
        });

        uploadPdfBm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title = pdfME106Title.getText().toString();
                if (title.isEmpty()) {
                    pdfME106Title.setError("Empty");
                    pdfME106Title.requestFocus();
                } else if (pdfData == null) {
                    Toast.makeText(uploadpdf.this, "Please upload pdf", Toast.LENGTH_SHORT).show();
                } else {
                    uploadPdf();
                }

            }
        });
        choosePdf.setOnClickListener((view) -> {
            openGallery();
        });

        uploadPdfoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title = pdfMT101Title.getText().toString();
                if (title.isEmpty()) {
                    pdfMT101Title.setError("Empty");
                    pdfMT101Title.requestFocus();
                } else if (pdfData == null) {
                    Toast.makeText(uploadpdf.this, "Please upload pdf", Toast.LENGTH_SHORT).show();
                } else {
                    uploadPdf();
                }

            }
        });
        ddPdf.setOnClickListener((view) -> {
            openGallery();
        });

        uploadPdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title = pdfMT103Title.getText().toString();
                if (title.isEmpty()) {
                    pdfMT103Title.setError("Empty");
                    pdfMT103Title.requestFocus();
                } else if (pdfData == null) {
                    Toast.makeText(uploadpdf.this, "Please upload pdf", Toast.LENGTH_SHORT).show();
                } else {
                    uploadPdf();
                }

            }
        });
        bbPdf.setOnClickListener((view) -> {
            openGallery();
        });

        uploaPdfBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title = pdfH103Title.getText().toString();
                if (title.isEmpty()) {
                    pdfH103Title.setError("Empty");
                    pdfH103Title.requestFocus();
                } else if (pdfData == null) {
                    Toast.makeText(uploadpdf.this, "Please upload pdf", Toast.LENGTH_SHORT).show();
                } else {
                    uploadPdf();
                }

            }
        });
        addPdf.setOnClickListener((view) -> {
            openGallery();
        });

        uploadPdfBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title = pdfMA102Title.getText().toString();
                if (title.isEmpty()) {
                    pdfMA102Title.setError("Empty");
                    pdfMA102Title.requestFocus();
                } else if (pdfData == null) {
                    Toast.makeText(uploadpdf.this, "Please upload pdf", Toast.LENGTH_SHORT).show();
                } else {
                    uploadPdf();
                }

            }
        });
        drawPdf.setOnClickListener((view) -> {
            openGallery();
        });

        uploadPdfBon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title = pdfME104Title.getText().toString();
                if (title.isEmpty()) {
                    pdfME104Title.setError("Empty");
                    pdfME104Title.requestFocus();
                } else if (pdfData == null) {
                    Toast.makeText(uploadpdf.this, "Please upload pdf", Toast.LENGTH_SHORT).show();
                } else {
                    uploadPdf();
                }

            }
        });
        ttPdf.setOnClickListener((view) -> {
            openGallery();
        });

        uploadPfBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title = pdfCP101Title.getText().toString();
                if (title.isEmpty()) {
                    pdfCP101Title.setError("Empty");
                    pdfCP101Title.requestFocus();
                } else if (pdfData == null) {
                    Toast.makeText(uploadpdf.this, "Please upload pdf", Toast.LENGTH_SHORT).show();
                } else {
                    uploadPdf();
                }

            }
        });
    }
    private void uploadPdf() {
        pd.setTitle("please wait.....");
        pd.setMessage("uploading pdf");
        pd.show();

    StorageReference  reference  = storageReference.child("pdf/"+ title+(".pdf"));
    reference.putFile(pdfData)
            .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Task<Uri>uriTask =taskSnapshot.getStorage().getDownloadUrl();
                    while (!uriTask.isComplete());
                    Uri uri = uriTask.getResult();
                    uploadData(String.valueOf(uri));
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    pd.dismiss();
                    Toast.makeText(uploadpdf.this, "Something went wrong", Toast.LENGTH_SHORT).show();

                }
            });
    }

    private void uploadData(String downloadUrl) {
        String uniqueKey= databaseReference.child("pdf").push().getKey();
        HashMap data=new HashMap();
        data.put("pdfMA102Title",title);
        data.put("pdfMAUrl",downloadUrl);
        databaseReference.child("pdf").child(uniqueKey).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                pd.dismiss();
                Toast.makeText(uploadpdf.this, "pdf upload successfully", Toast.LENGTH_SHORT).show();
                pdfMA102Title.setText("");
            }

        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();

                Toast.makeText(uploadpdf.this, "fail to upload pdf", Toast.LENGTH_SHORT).show();

            }
        });
                
    }

    private void openGallery() {
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select pdf file"), REQ);
    }

    @SuppressLint("Range")
    @Override
    protected void onActivityResult(int requestCode, int resutCode,@Nullable Intent data) {
        super.onActivityResult(requestCode, resutCode, data);
        if (requestCode == REQ && resutCode == RESULT_OK) {
            pdfData = data.getData();

            if(pdfData.toString().startsWith("context://")){
                Cursor cursor = null;
                try {
                    cursor = uploadpdf.this.getContentResolver().query(pdfData,null,null,null,null);
                    if(cursor!=  null  && cursor.moveToFirst()){
                        pdfName = cursor.getString(cursor.getColumnIndex(DISPLAY_NAME));
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (pdfData.toString().startsWith("file://")) {
                pdfName =new File(pdfData.toString()).getName();

            }
            Toast.makeText(this, "pdf selected", Toast.LENGTH_SHORT).show();
        }
    }
}
