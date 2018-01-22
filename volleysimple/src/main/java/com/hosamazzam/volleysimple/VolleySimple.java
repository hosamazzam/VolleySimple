package com.hosamazzam.volleysimple;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by hosam azzam on 08/11/2016.
 */

public class VolleySimple {

    private static VolleySimple vollaySimple;
    private static RequestQueue Queue;
    private static StringRequest stringRequest;
    private static JsonObjectRequest jsonObjectRequest;
    private static JsonArrayRequest jsonArrayRequest;
    private static ImageRequest imageRequest;
    private static RequestFuture<String> requestFuture;
    private static Context mcontext;
    private NetworkListener networkListener;
    private ProgressDialog progressDialog;
    private String pdTitle = "Loading", pdMsg = "Please wait...";

    private VolleySimple(Context context) {
        mcontext = context;
        Queue = Volley.newRequestQueue(mcontext);
    }

    public static VolleySimple getInstance(Context context) {
        if (vollaySimple == null) {
            if (mcontext != context) {
                vollaySimple = new VolleySimple(context);
            }
        }
        return vollaySimple;
    }

    public void setCallbackListener(NetworkListener callbackListener) {
        this.networkListener = callbackListener;
    }

    public void asyncStringGet(String url) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        networkListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                networkListener.onFailure(error);

            }
        });

        Queue.add(stringRequest);

    }

    public void asyncStringGet(String url, Boolean withDefaultProgressBar) {
        try {
            if (url == null)
                throw new RuntimeException("url can NOT be null");
            if (withDefaultProgressBar)
                progressDialog = ProgressDialog.show(mcontext, pdTitle, pdMsg, false, false);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
        stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        networkListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                networkListener.onFailure(error);

            }
        });

        Queue.add(stringRequest);

    }

    public void asyncStringGet(String url, final ProgressDialog progressDialog) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (progressDialog == null)
            throw new RuntimeException("ProgressDialog can NOT be null ");
        stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        networkListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                networkListener.onFailure(error);

            }
        });

        Queue.add(stringRequest);

    }

    public void asyncStringGet(String url, final NetworkListener<String> callbackListener) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (callbackListener == null)
            throw new RuntimeException("callbackListener can NOT be null");
        stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callbackListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callbackListener.onFailure(error);

            }
        });

        Queue.add(stringRequest);

    }

    public void asyncStringGet(String url, final NetworkListener<String> callbackListener, Boolean withDefaultProgressBar) {
        try {
            if (url == null)
                throw new RuntimeException("url can NOT be null");
            if (callbackListener == null)
                throw new RuntimeException("callbackListener can NOT be null");
            if (withDefaultProgressBar)
                progressDialog = ProgressDialog.show(mcontext, pdTitle, pdMsg, false, false);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
        stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        callbackListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                callbackListener.onFailure(error);

            }
        });

        Queue.add(stringRequest);

    }

    public void asyncStringGet(String url, final NetworkListener<String> callbackListener, final ProgressDialog progressDialog) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (callbackListener == null)
            throw new RuntimeException("callbackListener can NOT be null");
        if (progressDialog == null)
            throw new RuntimeException("ProgressDialog can NOT be null ");
        stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        callbackListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                callbackListener.onFailure(error);

            }
        });

        Queue.add(stringRequest);

    }

    public void asyncStringGet(String url, Object tag) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (tag == null)
            throw new RuntimeException("tag can NOT be null");
        stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        networkListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                networkListener.onFailure(error);

            }
        });
        stringRequest.setTag(tag);
        Queue.add(stringRequest);

    }

    public void asyncStringGet(String url, Object tag, Boolean withDefaultProgressBar) {
        try {
            if (url == null)
                throw new RuntimeException("url can NOT be null");
            if (tag == null)
                throw new RuntimeException("tag can NOT be null");
            if (withDefaultProgressBar)
                progressDialog = ProgressDialog.show(mcontext, pdTitle, pdMsg, false, false);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
        stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        networkListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                networkListener.onFailure(error);

            }
        });
        stringRequest.setTag(tag);
        Queue.add(stringRequest);

    }

    public void asyncStringGet(String url, Object tag, final ProgressDialog progressDialog) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (tag == null)
            throw new RuntimeException("tag can NOT be null");
        if (progressDialog == null)
            throw new RuntimeException("ProgressDialog can NOT be null ");
        stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        networkListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                networkListener.onFailure(error);

            }
        });
        stringRequest.setTag(tag);
        Queue.add(stringRequest);

    }

    public void asyncStringGet(String url, Object tag, final NetworkListener<String> callbackListener) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (tag == null)
            throw new RuntimeException("url can NOT be null");
        if (callbackListener == null)
            throw new RuntimeException("callbackListener can NOT be null");
        stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callbackListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callbackListener.onFailure(error);

            }
        });
        stringRequest.setTag(tag);
        Queue.add(stringRequest);

    }

    public void asyncStringGet(String url, Object tag, final NetworkListener<String> callbackListener, Boolean withDefaultProgressBar) {
        try {
            if (url == null)
                throw new RuntimeException("url can NOT be null");
            if (tag == null)
                throw new RuntimeException("tag can NOT be null");
            if (callbackListener == null)
                throw new RuntimeException("callbackListener can NOT be null");
            if (withDefaultProgressBar)
                progressDialog = ProgressDialog.show(mcontext, pdTitle, pdMsg, false, false);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
        stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        callbackListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                callbackListener.onFailure(error);

            }
        });
        stringRequest.setTag(tag);
        Queue.add(stringRequest);

    }

    public void asyncStringGet(String url, Object tag, final NetworkListener<String> callbackListener, final ProgressDialog progressDialog) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (tag == null)
            throw new RuntimeException("tag can NOT be null");
        if (callbackListener == null)
            throw new RuntimeException("callbackListener can NOT be null");
        if (progressDialog == null)
            throw new RuntimeException("ProgressDialog can NOT be null ");
        stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        callbackListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                callbackListener.onFailure(error);

            }
        });
        stringRequest.setTag(tag);
        Queue.add(stringRequest);

    }


    public void asyncImageGet(String url, final ImageView imageView) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (imageView == null)
            throw new RuntimeException("imageView can NOT be null");
        imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                imageView.setImageBitmap(response);
            }
        }, 0, 0, ImageView.ScaleType.CENTER_INSIDE, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }

    public void asyncImageGet(String url, final ImageListener imageListener) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (imageListener == null)
            throw new RuntimeException("imageListener can NOT be null");
        imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                imageListener.onResponse(response);
            }
        }, 0, 0, ImageView.ScaleType.CENTER_INSIDE, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                imageListener.onFailure(error);
            }
        });
    }

    public void asyncImageGet(String url, final ImageView imageView, int maxWidth, int maxHeight) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (imageView == null)
            throw new RuntimeException("imageView can NOT be null");
        imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                imageView.setImageBitmap(response);
            }
        }, maxWidth, maxHeight, ImageView.ScaleType.CENTER_INSIDE, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }

    public void asyncImageGet(String url, final ImageListener imageListener, int maxWidth, int maxHeight) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (imageListener == null)
            throw new RuntimeException("imageListener can NOT be null");
        imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                imageListener.onResponse(response);
            }
        }, maxWidth, maxHeight, ImageView.ScaleType.CENTER_INSIDE, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                imageListener.onFailure(error);
            }
        });
    }

    public void asyncImageGet(String url, final ImageView imageView, int maxWidth, int maxHeight, ImageView.ScaleType scaleType) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (imageView == null)
            throw new RuntimeException("imageView can NOT be null");
        if (scaleType == null)
            throw new RuntimeException("scaleType can NOT be null");
        imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                imageView.setImageBitmap(response);
            }
        }, maxWidth, maxHeight, scaleType, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }

    public void asyncImageGet(String url, final ImageListener imageListener, int maxWidth, int maxHeight, ImageView.ScaleType scaleType) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (imageListener == null)
            throw new RuntimeException("imageListener can NOT be null");
        if (scaleType == null)
            throw new RuntimeException("scaleType can NOT be null");
        imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                imageListener.onResponse(response);
            }
        }, maxWidth, maxHeight, scaleType, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                imageListener.onFailure(error);
            }
        });
    }

    public void asyncImageGet(String url, final ImageView imageView, int maxWidth, int maxHeight, ImageView.ScaleType scaleType, Bitmap.Config decodeConfig) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (imageView == null)
            throw new RuntimeException("imageView can NOT be null");
        if (scaleType == null)
            throw new RuntimeException("scaleType can NOT be null");
        if (decodeConfig == null)
            throw new RuntimeException("decodeConfig can NOT be null");
        imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                imageView.setImageBitmap(response);
            }
        }, maxWidth, maxHeight, scaleType, decodeConfig, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }

    public void asyncImageGet(String url, final ImageListener imageListener, int maxWidth, int maxHeight, ImageView.ScaleType scaleType, Bitmap.Config decodeConfig) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (imageListener == null)
            throw new RuntimeException("imageListener can NOT be null");
        if (scaleType == null)
            throw new RuntimeException("scaleType can NOT be null");
        if (decodeConfig == null)
            throw new RuntimeException("decodeConfig can NOT be null");
        imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                imageListener.onResponse(response);
            }
        }, maxWidth, maxHeight, scaleType, decodeConfig, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                imageListener.onFailure(error);
            }
        });
    }

    public void asyncImageGet(String url, final ImageView imageView, ImageView.ScaleType scaleType) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (imageView == null)
            throw new RuntimeException("imageView can NOT be null");
        if (scaleType == null)
            throw new RuntimeException("scaleType can NOT be null");
        imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                imageView.setImageBitmap(response);
            }
        }, 0, 0, scaleType, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }

    public void asyncImageGet(String url, final ImageListener imageListener, ImageView.ScaleType scaleType) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (imageListener == null)
            throw new RuntimeException("imageListener can NOT be null");
        if (scaleType == null)
            throw new RuntimeException("scaleType can NOT be null");
        imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                imageListener.onResponse(response);
            }
        }, 0, 0, scaleType, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                imageListener.onFailure(error);
            }
        });
    }


    public String syncStringGet(String url) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        requestFuture = RequestFuture.newFuture();
        stringRequest = new StringRequest(Request.Method.GET, url, requestFuture, requestFuture);
        Queue.add(stringRequest);
        try {
            return requestFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String syncStringGet(String url, String tag) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (tag == null)
            throw new RuntimeException("tag can NOT be null");
        requestFuture = RequestFuture.newFuture();
        stringRequest = new StringRequest(Request.Method.GET, url, requestFuture, requestFuture);
        stringRequest.setTag(tag);
        Queue.add(stringRequest);
        try {
            return requestFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void asyncStringPost(String url, final Map<String, String> params) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (params == null)
            throw new RuntimeException("params can NOT be null");
        stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        networkListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                networkListener.onFailure(error);

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
        };

        Queue.add(stringRequest);

    }

    public void asyncStringPost(String url, final Map<String, String> params, Boolean withDefaultProgressBar) {
        try {
            if (url == null)
                throw new RuntimeException("url can NOT be null");
            if (params == null)
                throw new RuntimeException("params can NOT be null");
            if (withDefaultProgressBar)
                progressDialog = ProgressDialog.show(mcontext, pdTitle, pdMsg, false, false);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
        stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        networkListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                networkListener.onFailure(error);

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
        };

        Queue.add(stringRequest);

    }

    public void asyncStringPost(String url, final Map<String, String> params, final ProgressDialog progressDialog) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (params == null)
            throw new RuntimeException("params can NOT be null");
        if (progressDialog == null)
            throw new RuntimeException("ProgressDialog can NOT be null ");
        stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        networkListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                networkListener.onFailure(error);

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
        };

        Queue.add(stringRequest);

    }

    public void asyncStringPost(String url, final Map<String, String> params, final NetworkListener<String> callbackListener) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (params == null)
            throw new RuntimeException("params can NOT be null");
        if (callbackListener == null)
            throw new RuntimeException("callbackListener can NOT be null");
        stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callbackListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callbackListener.onFailure(error);

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
        };

        Queue.add(stringRequest);

    }

    public void asyncStringPost(String url, final Map<String, String> params, final NetworkListener<String> callbackListener, Boolean withDefaultProgressBar) {
        try {
            if (url == null)
                throw new RuntimeException("url can NOT be null");
            if (params == null)
                throw new RuntimeException("params can NOT be null");
            if (callbackListener == null)
                throw new RuntimeException("callbackListener can NOT be null");
            if (withDefaultProgressBar)
                progressDialog = ProgressDialog.show(mcontext, pdTitle, pdMsg, false, false);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
        stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        callbackListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                callbackListener.onFailure(error);

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
        };

        Queue.add(stringRequest);

    }

    public void asyncStringPost(String url, final Map<String, String> params, final NetworkListener<String> callbackListener, final ProgressDialog progressDialog) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (params == null)
            throw new RuntimeException("params can NOT be null");
        if (callbackListener == null)
            throw new RuntimeException("callbackListener can NOT be null");
        if (progressDialog == null)
            throw new RuntimeException("ProgressDialog can NOT be null ");
        stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        callbackListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                callbackListener.onFailure(error);

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
        };

        Queue.add(stringRequest);

    }

    public void asyncStringPost(String url, Object tag, final Map<String, String> params) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (tag == null)
            throw new RuntimeException("tag can NOT be null");
        if (params == null)
            throw new RuntimeException("params can NOT be null");
        stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        networkListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                networkListener.onFailure(error);

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
        };

        stringRequest.setTag(tag);
        Queue.add(stringRequest);

    }

    public void asyncStringPost(String url, Object tag, final Map<String, String> params, Boolean withDefaultProgressBar) {
        try {
            if (url == null)
                throw new RuntimeException("url can NOT be null");
            if (tag == null)
                throw new RuntimeException("tag can NOT be null");
            if (params == null)
                throw new RuntimeException("params can NOT be null");
            if (withDefaultProgressBar)
                progressDialog = ProgressDialog.show(mcontext, pdTitle, pdMsg, false, false);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
        stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        networkListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                networkListener.onFailure(error);

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
        };

        stringRequest.setTag(tag);
        Queue.add(stringRequest);

    }

    public void asyncStringPost(String url, Object tag, final Map<String, String> params, final ProgressDialog progressDialog) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (tag == null)
            throw new RuntimeException("tag can NOT be null");
        if (params == null)
            throw new RuntimeException("params can NOT be null");
        if (progressDialog == null)
            throw new RuntimeException("ProgressDialog can NOT be null ");
        stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        networkListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                networkListener.onFailure(error);

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
        };

        stringRequest.setTag(tag);
        Queue.add(stringRequest);

    }

    public void asyncStringPost(String url, Object tag, final Map<String, String> params, final NetworkListener<String> callbackListener) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (tag == null)
            throw new RuntimeException("tag can NOT be null");
        if (params == null)
            throw new RuntimeException("params can NOT be null");
        if (callbackListener == null)
            throw new RuntimeException("callbackListener can NOT be null");
        stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callbackListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callbackListener.onFailure(error);

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
        };

        stringRequest.setTag(tag);
        Queue.add(stringRequest);

    }

    public void asyncStringPost(String url, Object tag, final Map<String, String> params, final NetworkListener<String> callbackListener, Boolean withDefaultProgressBar) {
        try {
            if (url == null)
                throw new RuntimeException("url can NOT be null");
            if (tag == null)
                throw new RuntimeException("tag can NOT be null");
            if (params == null)
                throw new RuntimeException("params can NOT be null");
            if (callbackListener == null)
                throw new RuntimeException("callbackListener can NOT be null");
            if (withDefaultProgressBar)
                progressDialog = ProgressDialog.show(mcontext, pdTitle, pdMsg, false, false);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
        stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        callbackListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                callbackListener.onFailure(error);

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
        };

        stringRequest.setTag(tag);
        Queue.add(stringRequest);

    }

    public void asyncStringPost(String url, Object tag, final Map<String, String> params, final NetworkListener<String> callbackListener, final ProgressDialog progressDialog) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (tag == null)
            throw new RuntimeException("tag can NOT be null");
        if (params == null)
            throw new RuntimeException("params can NOT be null");
        if (callbackListener == null)
            throw new RuntimeException("callbackListener can NOT be null");
        if (progressDialog == null)
            throw new RuntimeException("ProgressDialog can NOT be null ");
        stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        callbackListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                callbackListener.onFailure(error);

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
        };

        stringRequest.setTag(tag);
        Queue.add(stringRequest);

    }


    public String syncStringPost(String url, final Map<String, String> params) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (params == null)
            throw new RuntimeException("params can NOT be null");
        requestFuture = RequestFuture.newFuture();
        stringRequest = new StringRequest(Request.Method.POST, url, requestFuture, requestFuture) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
        };
        Queue.add(stringRequest);

        try {
            return requestFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String syncStringPost(String url, Object tag, final Map<String, String> params) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (tag == null)
            throw new RuntimeException("tag can NOT be null");
        if (params == null)
            throw new RuntimeException("params can NOT be null");
        requestFuture = RequestFuture.newFuture();
        stringRequest = new StringRequest(Request.Method.POST, url, requestFuture, requestFuture) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
        };

        stringRequest.setTag(tag);
        Queue.add(stringRequest);

        try {
            return requestFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void asyncJsonObject(int method, JSONObject jsonObject, String url) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        jsonObjectRequest = new JsonObjectRequest(method, url, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        networkListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                networkListener.onFailure(error);

            }
        });

        Queue.add(jsonObjectRequest);

    }

    public void asyncJsonObject(int method, JSONObject jsonObject, String url, Boolean withDefaultProgressBar) {
        try {
            if (url == null)
                throw new RuntimeException("url can NOT be null");
            if (withDefaultProgressBar)
                progressDialog = ProgressDialog.show(mcontext, pdTitle, pdMsg, false, false);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
        jsonObjectRequest = new JsonObjectRequest(method, url, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        networkListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                networkListener.onFailure(error);

            }
        });

        Queue.add(jsonObjectRequest);

    }

    public void asyncJsonObject(int method, JSONObject jsonObject, String url, final ProgressDialog progressDialog) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (progressDialog == null)
            throw new RuntimeException("ProgressDialog can NOT be null ");
        jsonObjectRequest = new JsonObjectRequest(method, url, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        networkListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                networkListener.onFailure(error);

            }
        });

        Queue.add(jsonObjectRequest);

    }

    public void asyncJsonObject(int method, JSONObject jsonObject, String url, final NetworkListener<JSONObject> callbackListener) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (callbackListener == null)
            throw new RuntimeException("callbackListener can NOT be null");
        jsonObjectRequest = new JsonObjectRequest(method, url, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        callbackListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callbackListener.onFailure(error);

            }
        });

        Queue.add(jsonObjectRequest);

    }

    public void asyncJsonObject(int method, JSONObject jsonObject, String url, final NetworkListener<JSONObject> callbackListener, Boolean withDefaultProgressBar) {
        try {
            if (url == null)
                throw new RuntimeException("url can NOT be null");
            if (callbackListener == null)
                throw new RuntimeException("callbackListener can NOT be null");
            if (withDefaultProgressBar)
                progressDialog = ProgressDialog.show(mcontext, pdTitle, pdMsg, false, false);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
        jsonObjectRequest = new JsonObjectRequest(method, url, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        callbackListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                callbackListener.onFailure(error);

            }
        });

        Queue.add(jsonObjectRequest);

    }

    public void asyncJsonObject(int method, JSONObject jsonObject, String url, final NetworkListener<JSONObject> callbackListener, final ProgressDialog progressDialog) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (callbackListener == null)
            throw new RuntimeException("callbackListener can NOT be null");
        if (progressDialog == null)
            throw new RuntimeException("ProgressDialog can NOT be null ");
        jsonObjectRequest = new JsonObjectRequest(method, url, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        callbackListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                callbackListener.onFailure(error);

            }
        });

        Queue.add(jsonObjectRequest);

    }

    public void asyncJsonObject(int method, JSONObject jsonObject, String url, Object tag) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (tag == null)
            throw new RuntimeException("tag can NOT be null");
        jsonObjectRequest = new JsonObjectRequest(method, url, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        networkListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                networkListener.onFailure(error);

            }
        });
        jsonObjectRequest.setTag(tag);
        Queue.add(jsonObjectRequest);

    }

    public void asyncJsonObject(int method, JSONObject jsonObject, String url, Object tag, Boolean withDefaultProgressBar) {
        try {
            if (url == null)
                throw new RuntimeException("url can NOT be null");
            if (tag == null)
                throw new RuntimeException("tag can NOT be null");
            if (withDefaultProgressBar)
                progressDialog = ProgressDialog.show(mcontext, pdTitle, pdMsg, false, false);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
        jsonObjectRequest = new JsonObjectRequest(method, url, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        networkListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                networkListener.onFailure(error);

            }
        });
        jsonObjectRequest.setTag(tag);
        Queue.add(jsonObjectRequest);

    }

    public void asyncJsonObject(int method, JSONObject jsonObject, String url, Object tag, final ProgressDialog progressDialog) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (tag == null)
            throw new RuntimeException("tag can NOT be null");
        if (progressDialog == null)
            throw new RuntimeException("ProgressDialog can NOT be null ");
        jsonObjectRequest = new JsonObjectRequest(method, url, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        networkListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                networkListener.onFailure(error);

            }
        });
        jsonObjectRequest.setTag(tag);
        Queue.add(jsonObjectRequest);

    }

    public void asyncJsonObject(int method, JSONObject jsonObject, String url, Object tag, final NetworkListener<JSONObject> callbackListener) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (tag == null)
            throw new RuntimeException("url can NOT be null");
        if (callbackListener == null)
            throw new RuntimeException("callbackListener can NOT be null");
        jsonObjectRequest = new JsonObjectRequest(method, url, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        callbackListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callbackListener.onFailure(error);

            }
        });
        jsonObjectRequest.setTag(tag);
        Queue.add(jsonObjectRequest);

    }

    public void asyncJsonObject(int method, JSONObject jsonObject, String url, Object tag, final NetworkListener<JSONObject> callbackListener, Boolean withDefaultProgressBar) {
        try {
            if (url == null)
                throw new RuntimeException("url can NOT be null");
            if (tag == null)
                throw new RuntimeException("tag can NOT be null");
            if (callbackListener == null)
                throw new RuntimeException("callbackListener can NOT be null");
            if (withDefaultProgressBar)
                progressDialog = ProgressDialog.show(mcontext, pdTitle, pdMsg, false, false);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
        jsonObjectRequest = new JsonObjectRequest(method, url, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        callbackListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                callbackListener.onFailure(error);

            }
        });
        jsonObjectRequest.setTag(tag);
        Queue.add(jsonObjectRequest);

    }

    public void asyncJsonObject(int method, JSONObject jsonObject, String url, Object tag, final NetworkListener<JSONObject> callbackListener, final ProgressDialog progressDialog) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (tag == null)
            throw new RuntimeException("tag can NOT be null");
        if (callbackListener == null)
            throw new RuntimeException("callbackListener can NOT be null");
        if (progressDialog == null)
            throw new RuntimeException("ProgressDialog can NOT be null ");
        jsonObjectRequest = new JsonObjectRequest(method, url, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        callbackListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                callbackListener.onFailure(error);

            }
        });
        jsonObjectRequest.setTag(tag);
        Queue.add(jsonObjectRequest);

    }


    public void asyncJsonArray(int method, JSONArray jsonArray, String url) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        jsonArrayRequest = new JsonArrayRequest(method, url, jsonArray,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        networkListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                networkListener.onFailure(error);

            }
        });

        Queue.add(jsonArrayRequest);

    }

    public void asyncJsonArray(int method, JSONArray jsonArray, String url, Boolean withDefaultProgressBar) {
        try {
            if (url == null)
                throw new RuntimeException("url can NOT be null");
            if (withDefaultProgressBar)
                progressDialog = ProgressDialog.show(mcontext, pdTitle, pdMsg, false, false);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
        jsonArrayRequest = new JsonArrayRequest(method, url, jsonArray,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        networkListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                networkListener.onFailure(error);

            }
        });

        Queue.add(jsonArrayRequest);

    }

    public void asyncJsonArray(int method, JSONArray jsonArray, String url, final ProgressDialog progressDialog) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (progressDialog == null)
            throw new RuntimeException("ProgressDialog can NOT be null ");
        jsonArrayRequest = new JsonArrayRequest(method, url, jsonArray,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        networkListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                networkListener.onFailure(error);

            }
        });

        Queue.add(jsonArrayRequest);

    }

    public void asyncJsonArray(int method, JSONArray jsonArray, String url, final NetworkListener<JSONArray> callbackListener) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (callbackListener == null)
            throw new RuntimeException("callbackListener can NOT be null");
        jsonArrayRequest = new JsonArrayRequest(method, url, jsonArray,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        callbackListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callbackListener.onFailure(error);

            }
        });

        Queue.add(jsonArrayRequest);

    }

    public void asyncJsonArray(int method, JSONArray jsonArray, String url, final NetworkListener<JSONArray> callbackListener, Boolean withDefaultProgressBar) {
        try {
            if (url == null)
                throw new RuntimeException("url can NOT be null");
            if (callbackListener == null)
                throw new RuntimeException("callbackListener can NOT be null");
            if (withDefaultProgressBar)
                progressDialog = ProgressDialog.show(mcontext, pdTitle, pdMsg, false, false);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
        jsonArrayRequest = new JsonArrayRequest(method, url, jsonArray,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        callbackListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                callbackListener.onFailure(error);

            }
        });

        Queue.add(jsonArrayRequest);

    }

    public void asyncJsonArray(int method, JSONArray jsonArray, String url, final NetworkListener<JSONArray> callbackListener, final ProgressDialog progressDialog) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (callbackListener == null)
            throw new RuntimeException("callbackListener can NOT be null");
        if (progressDialog == null)
            throw new RuntimeException("ProgressDialog can NOT be null ");
        jsonArrayRequest = new JsonArrayRequest(method, url, jsonArray,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        callbackListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                callbackListener.onFailure(error);

            }
        });

        Queue.add(jsonArrayRequest);

    }

    public void asyncJsonArray(int method, JSONArray jsonArray, String url, Object tag) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (tag == null)
            throw new RuntimeException("tag can NOT be null");
        jsonArrayRequest = new JsonArrayRequest(method, url, jsonArray,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        networkListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                networkListener.onFailure(error);

            }
        });
        jsonArrayRequest.setTag(tag);
        Queue.add(jsonArrayRequest);

    }

    public void asyncJsonArray(int method, JSONArray jsonArray, String url, Object tag, Boolean withDefaultProgressBar) {
        try {
            if (url == null)
                throw new RuntimeException("url can NOT be null");
            if (tag == null)
                throw new RuntimeException("tag can NOT be null");
            if (withDefaultProgressBar)
                progressDialog = ProgressDialog.show(mcontext, pdTitle, pdMsg, false, false);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
        jsonArrayRequest = new JsonArrayRequest(method, url, jsonArray,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        networkListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                networkListener.onFailure(error);

            }
        });
        jsonArrayRequest.setTag(tag);
        Queue.add(jsonArrayRequest);

    }

    public void asyncJsonArray(int method, JSONArray jsonArray, String url, Object tag, final ProgressDialog progressDialog) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (tag == null)
            throw new RuntimeException("tag can NOT be null");
        if (progressDialog == null)
            throw new RuntimeException("ProgressDialog can NOT be null ");
        jsonArrayRequest = new JsonArrayRequest(method, url, jsonArray,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        networkListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                networkListener.onFailure(error);

            }
        });
        jsonArrayRequest.setTag(tag);
        Queue.add(jsonArrayRequest);

    }

    public void asyncJsonArray(int method, JSONArray jsonArray, String url, Object tag, final NetworkListener<JSONArray> callbackListener) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (tag == null)
            throw new RuntimeException("url can NOT be null");
        if (callbackListener == null)
            throw new RuntimeException("callbackListener can NOT be null");
        jsonArrayRequest = new JsonArrayRequest(method, url, jsonArray,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callbackListener.onFailure(error);

            }
        });
        jsonArrayRequest.setTag(tag);
        Queue.add(jsonArrayRequest);

    }

    public void asyncJsonArray(int method, JSONArray jsonArray, String url, Object tag, final NetworkListener<JSONArray> callbackListener, Boolean withDefaultProgressBar) {
        try {
            if (url == null)
                throw new RuntimeException("url can NOT be null");
            if (tag == null)
                throw new RuntimeException("tag can NOT be null");
            if (callbackListener == null)
                throw new RuntimeException("callbackListener can NOT be null");
            if (withDefaultProgressBar)
                progressDialog = ProgressDialog.show(mcontext, pdTitle, pdMsg, false, false);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
        jsonArrayRequest = new JsonArrayRequest(method, url, jsonArray,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        callbackListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                callbackListener.onFailure(error);

            }
        });
        jsonArrayRequest.setTag(tag);
        Queue.add(jsonArrayRequest);

    }

    public void asyncJsonArray(int method, JSONArray jsonArray, String url, Object tag, final NetworkListener<JSONArray> callbackListener, final ProgressDialog progressDialog) {
        if (url == null)
            throw new RuntimeException("url can NOT be null");
        if (tag == null)
            throw new RuntimeException("tag can NOT be null");
        if (callbackListener == null)
            throw new RuntimeException("callbackListener can NOT be null");
        if (progressDialog == null)
            throw new RuntimeException("ProgressDialog can NOT be null ");
        jsonArrayRequest = new JsonArrayRequest(method, url, jsonArray,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException("Progress Dialog not been init");
                        }
                        callbackListener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    throw new RuntimeException("Progress Dialog not been init");
                }
                callbackListener.onFailure(error);

            }
        });
        jsonArrayRequest.setTag(tag);
        Queue.add(jsonArrayRequest);

    }


    public void cancelRequest(Object tag) {
        if (tag == null)
            throw new RuntimeException("tag can NOT be null");
        if (Queue != null) {
            Queue.cancelAll(tag);
        }
    }

    public RequestQueue getQueue() {
        return Queue;
    }

    public interface NetworkListener<T> {
        void onResponse(T response);

        void onFailure(Exception e);
    }

    public interface ImageListener {
        void onResponse(Bitmap bitmap);

        void onFailure(Exception e);
    }

    public interface RequestMethod {
        int GET = 0;
        int POST = 1;
    }

}
